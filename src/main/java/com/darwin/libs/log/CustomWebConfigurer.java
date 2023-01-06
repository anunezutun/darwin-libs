package com.darwin.libs.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** Configutation class.
 *
 * @author Team Backend Darwin
 */
@Component
public class CustomWebConfigurer implements WebMvcConfigurer {

  @Autowired
  private InterceptLog interceptLog;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(interceptLog);
  }

}
