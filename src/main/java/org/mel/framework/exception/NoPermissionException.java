package org.mel.framework.exception;

public class NoPermissionException extends GenericException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoPermissionException() {
		super("Permission denied!");
	}

	public NoPermissionException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoPermissionException(String message) {
		super(message);
	}

	public NoPermissionException(Throwable cause) {
		super(cause);
	}

	@Override
	public int getCode() {
		return GenericException.ERROR_CODE_NO_PERMISSION_ERROR;
	}

}
