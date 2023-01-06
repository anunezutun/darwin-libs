package com.darwin.libs.logbook;

import static org.zalando.logbook.Conditions.exclude;
import static org.zalando.logbook.Conditions.requestTo;
import static org.zalando.logbook.HeaderFilters.replaceHeaders;
import static org.zalando.logbook.QueryFilters.replaceQuery;
import static org.zalando.logbook.json.JsonBodyFilters.replaceJsonStringProperty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.zalando.logbook.BodyFilter;
import org.zalando.logbook.DefaultHttpLogWriter;
import org.zalando.logbook.DefaultSink;
import org.zalando.logbook.DefaultStrategy;
import org.zalando.logbook.HeaderFilter;
import org.zalando.logbook.HttpRequest;
import org.zalando.logbook.Logbook;
import org.zalando.logbook.QueryFilter;
import org.zalando.logbook.SplunkHttpLogFormatter;
import org.zalando.logbook.servlet.LogbookFilter;

/** This class allows configure LogBook.
 *
 * @author Team Backend Darwin
 */
@Getter
@Setter
@Component
@ConfigurationProperties("logbook")
public class HttpTraceConfig {

  private Obfuscation obfuscation = new Obfuscation();
  private Exclude exclude = new Exclude();

  /**
   * Custom LogBook Filter.
   *
   * @return Bean object.
   */
  @Bean
  public FilterRegistrationBean<LogbookFilter> customLogbookFilter() {
    FilterRegistrationBean<LogbookFilter> bean =
            new FilterRegistrationBean<>(createSensibleFieldsObfuscation());
    bean.setOrder(-100);
    return bean;
  }

  private LogbookFilter createSensibleFieldsObfuscation() {
    return new LogbookFilter(
            Logbook.builder()
                    .strategy(new DefaultStrategy())
                    .condition(getExcludeRequestPaths())
                    .headerFilter(getHeaderFilters())
                    .queryFilters(getQueryFilters())
                    .bodyFilter(getBodyFilter())
                    .sink(new DefaultSink(new SplunkHttpLogFormatter(), new DefaultHttpLogWriter()))
                    .build());
  }

  private Predicate<HttpRequest> getExcludeRequestPaths() {
    List<Predicate<HttpRequest>> predicates = new ArrayList<>();
    for (String requestPath : exclude.getRequestTo()) {
      predicates.add(requestTo(requestPath));
    }
    return exclude(predicates);
  }

  private HeaderFilter getHeaderFilters() {
    Set<String> headerFilters = new HashSet<>();
    List<String> header = obfuscation.getSensibleFields().getHeader();
    if (header != null && !header.isEmpty()) {
      headerFilters.addAll(header);
    }
    return replaceHeaders(headerFilters, Constants.GENERAL_REPLACEMENT_VALUE);
  }

  private Set<QueryFilter> getQueryFilters() {
    Set<QueryFilter> queryFilters = new HashSet<>();
    List<String> requestParam = obfuscation.getSensibleFields().getRequestParam();
    if (requestParam != null && !requestParam.isEmpty()) {
      requestParam.forEach(queryParam ->
              queryFilters.add(replaceQuery(queryParam, Constants.GENERAL_REPLACEMENT_VALUE)));
    }
    return queryFilters;
  }

  private BodyFilter getBodyFilter() {
    Set<String> bodyFilter = new HashSet<>();
    List<String> body = obfuscation.getSensibleFields().getBody();
    if (body != null && !body.isEmpty()) {
      bodyFilter.addAll(body);
    }
    return replaceJsonStringProperty(bodyFilter, Constants.GENERAL_REPLACEMENT_VALUE);
  }

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  static class Obfuscation {
    private SensibleFields sensibleFields = new SensibleFields();
  }

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  static class SensibleFields {
    private List<String> header = new ArrayList<>();
    private List<String> requestParam = new ArrayList<>();
    private List<String> body = new ArrayList<>();
  }

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  static class Exclude {
    private List<String> requestTo = new ArrayList<>();
  }
}