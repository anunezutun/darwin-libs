package com.darwin.libs.exception;

/**
 * Class to manage authentication failed exception events in the app.
 *
 * @author Team Backend Darwin
 */
public class AuthenticationFailedException extends RuntimeException {

  public AuthenticationFailedException(String message) {
    super(message);
  }

}
