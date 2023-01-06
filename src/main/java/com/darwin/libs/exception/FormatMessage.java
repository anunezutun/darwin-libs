package com.darwin.libs.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Class to define the output messages segment format.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FormatMessage implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * Status or error code of message.
   */
  String code;

  /**
   * Detail information of message.
   */
  String detail;

}