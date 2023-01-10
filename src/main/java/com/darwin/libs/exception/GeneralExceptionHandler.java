package com.darwin.libs.exception;

import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Class to manage the general exceptions in the app.
 *
 * @author Team Backend Darwin
 */
@ControllerAdvice
@Slf4j
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

  /**
   * Handles the general validation exception.
   *
   * @param exception Exception to be managed.
   * @return Response entity with the exception data.
   */
  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public final ResponseEntity<FormatOutput<Object>> handleUserNotFoundException(
      Exception exception) {
    log.error(exception.toString());
    FormatMessage message = new FormatMessage(
        String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), exception.getMessage());
    FormatOutput<Object> formatOutput = new FormatOutput<>();
    formatOutput.setMessages(List.of(message));
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(formatOutput);
  }

  /**
   * Handles the general validation exception.
   *
   * @param exception Validation exception to be managed.
   * @return Response entity with the exception data.
   */
  @ExceptionHandler(GeneralValidationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<FormatOutput<Object>> handleGeneralValidationException(
      GeneralValidationException exception) {
    log.error(exception.toString());
    FormatOutput<Object> formatOutput = new FormatOutput<>();
    formatOutput.setMessages(exception.getMessages());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(formatOutput);
  }

  /**
   * Handles the authentication exception.
   *
   * @param exception Authentication failed exception to be managed.
   * @return Response entity with the exception data.
   */
  @ExceptionHandler(AuthenticationFailedException.class)
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  public ResponseEntity<FormatOutput<Object>> handleAuthenticationFailedException(
      AuthenticationFailedException exception) {
    log.error(exception.toString());
    FormatMessage message = new FormatMessage(
        String.valueOf(HttpStatus.UNAUTHORIZED.value()), exception.getMessage());
    FormatOutput<Object> formatOutput = new FormatOutput<>();
    formatOutput.setMessages(List.of(message));
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(formatOutput);
  }

  /**
   * Handles the illegal argument exception.
   *
   * @param exception Illegal argument exception to be managed.
   * @return Response entity with the exception data.
   */
  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<FormatOutput<Object>> handleIllegalArgumentException(
      IllegalArgumentException exception) {
    log.error(exception.getMessage(), exception);
    FormatMessage message = new FormatMessage(
        String.valueOf(HttpStatus.BAD_REQUEST.value()),
        ExceptionMessages.INTERNAL_FAIL_LOADING_DATA);
    FormatOutput<Object> formatOutput = new FormatOutput<>();
    formatOutput.setMessages(List.of(message));
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(formatOutput);
  }

  /**
   * Handles the not found exception.
   *
   * @param exception Not found exception to be managed.
   * @return Response entity with the exception data.
   */
  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<FormatOutput<Object>> handleItemNotFoundException(
      NotFoundException exception) {
    log.error(exception.getMessage(), exception);
    FormatMessage message = new FormatMessage(
        String.valueOf(HttpStatus.NOT_FOUND.value()), exception.getMessage());
    FormatOutput<Object> formatOutput = new FormatOutput<>();
    formatOutput.setMessages(List.of(message));
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(formatOutput);
  }

  /**
   * Handles the image not found exception.
   *
   * @param exception Image exception to be managed.
   * @return Response entity with the exception data.
   */
  @ExceptionHandler(ImageResourceException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<FormatOutput<Object>> handleItemNotFoundException(
      ImageResourceException exception) {
    log.error(exception.getMessage(), exception);
    FormatMessage message = new FormatMessage(
        String.valueOf(HttpStatus.BAD_REQUEST.value()), exception.getMessage());
    FormatOutput<Object> formatOutput = new FormatOutput<>();
    formatOutput.setMessages(List.of(message));
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(formatOutput);
  }

  /**
   * Handles the uncaught exceptions.
   *
   * @param exception Runtime exception to be managed.
   * @return Response entity with the exception data.
   */
  @ExceptionHandler(RuntimeException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<FormatOutput<Object>> handleAllUncaughtException(
      RuntimeException exception) {
    log.error(exception.getMessage(), exception);
    FormatMessage message = new FormatMessage(
        String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),
        ExceptionMessages.INTERNAL_FAIL_LOADING_DATA);
    FormatOutput<Object> formatOutput = new FormatOutput<>();
    formatOutput.setMessages(List.of(message));
    return ResponseEntity.internalServerError().body(formatOutput);
  }

  /**
   * Override method to handle the not valid arguments in the requests.
   *
   * @param ex      Not valid argument exception.
   * @param headers Response headers.
   * @param status  Selected response status.
   * @param request Request received.
   * @return ResponseEntity object.
   */
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      @NotNull MethodArgumentNotValidException ex, @Nullable HttpHeaders headers,
      @Nullable HttpStatus status, @Nullable WebRequest request) {
    List<FormatMessage> messages = ex.getBindingResult().getFieldErrors().stream().map(
        x -> new FormatMessage(x.getField(), x.getDefaultMessage())
    ).collect(Collectors.toList());
    FormatOutput<Object> formatOutput = new FormatOutput<>();
    formatOutput.setMessages(messages);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(formatOutput);
  }

}
