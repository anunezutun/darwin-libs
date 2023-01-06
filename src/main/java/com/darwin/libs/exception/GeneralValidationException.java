package com.darwin.libs.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Class to manage the validation exceptions in the app.
 *
 * @author Team Backend Darwin
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class GeneralValidationException extends RuntimeException {

  private final List<FormatMessage> messages;

  public GeneralValidationException(List<FormatMessage> messages) {
    this.messages = messages;
  }

}
