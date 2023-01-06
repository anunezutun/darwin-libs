package com.darwin.libs.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Class to define the output format for services.
 *
 * @param <T> Type of class to be modeled by the FormatOutput object.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FormatOutput<T> {

  /**
   * Data object of response.
   */
  private T data;

  /**
   * Messages list of response.
   */
  private List<FormatMessage> messages;

}
