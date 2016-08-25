package org.mel.framework.exception;

public class LoginException extends GenericException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginException() {
		super("Username or password error!");
	}

	public LoginException(String message, Throwable cause) {
		super(message, cause);
	}

	public LoginException(String message) {
		super(message);
	}

	public LoginException(Throwable cause) {
		super(cause);
	}

	@Override
	public int getCode() {
		return GenericException.ERROR_CODE_LOGINID_PASSWORD_ERROR;
	}

}
