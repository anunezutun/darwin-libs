package com.darwin.libs.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * Class that throws exceptions when auditing changes.
 *
 * @author Team Backend Darwin
 */
@Slf4j
public class AuditProcessException extends RuntimeException {

  public AuditProcessException(String message, Throwable cause) {
    super(message, cause);
  }
}
