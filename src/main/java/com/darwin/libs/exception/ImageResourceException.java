package com.darwin.libs.exception;

/**
 * Class to manage image exception events in the app.
 *
 * @author Team Backend Darwin
 */
public class ImageResourceException extends Exception {

  public ImageResourceException(String message) {
    super(message);
  }

  public ImageResourceException(Throwable cause) {
    super(cause);
  }

}
