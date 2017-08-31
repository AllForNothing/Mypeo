package cn.tedu.ttms.common.exception;

public class SaveRuntimeException extends RuntimeException {

	public SaveRuntimeException() {
		super();
	}

	public SaveRuntimeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SaveRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public SaveRuntimeException(String message) {
		super(message);
	}

	public SaveRuntimeException(Throwable cause) {
		super(cause);
	}

}