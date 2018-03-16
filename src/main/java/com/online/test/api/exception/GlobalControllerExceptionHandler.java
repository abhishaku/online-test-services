package com.online.test.api.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.online.test.api.services.response.BaseResponse;

@RestControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

	@ExceptionHandler(value = RequestException.class)
	public final ResponseEntity<Object> handleRequestNotValidException(final Exception exception,
			final WebRequest request) {
		final HttpStatus responseStatus = HttpStatus.BAD_REQUEST;
		final RequestException requestException = (RequestException) exception;

		LOGGER.error("RequestException ocurred! Sending HTTP status '{}' along {}", responseStatus,
				requestException.getMessage());
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		BaseResponse resp = new BaseResponse();
		resp.setSuccess(false);
		resp.setMessage(requestException.getMessage());
		return new ResponseEntity<>(resp, headers, responseStatus);
	}
}
