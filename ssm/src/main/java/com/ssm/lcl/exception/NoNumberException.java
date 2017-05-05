package com.ssm.lcl.exception;

/**
 * 库存不足异常
 */
@SuppressWarnings("serial")
public class NoNumberException extends RuntimeException {

	public NoNumberException(String message) {
		super(message);
	}

	public NoNumberException(String message, Throwable cause) {
		super(message, cause);
	}

}
