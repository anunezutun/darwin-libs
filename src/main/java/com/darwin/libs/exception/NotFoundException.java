package com.darwin.libs.exception;

/**
 * Class to manage not found exception events in the app.
 *
 * @author Team Backend Darwin
 */
public class NotFoundException extends RuntimeException {

  public NotFoundException(String message) {
    super(message);
  }

}
