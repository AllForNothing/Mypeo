package cn.tedu.ttms.common.exception;

public class UpdateRuntimeException 
extends RuntimeException {

	public UpdateRuntimeException() {
		super();
	}

	public UpdateRuntimeException(String message, Throwable cause, boolean enableSuppression,boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UpdateRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public UpdateRuntimeException(String message) {
		super(message);
	}

	public UpdateRuntimeException(Throwable cause) {
		super(cause);
	}		
}