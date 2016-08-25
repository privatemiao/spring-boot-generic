package org.mel.framework.exception;

/**
 * 
 * 不分设备，一个用户只能有一个有效session。 当用户登录系统时，会将原来已经登录且未过期的Session注销掉（采用更改session状态的方式）。
 * 
 * @author Mel
 *
 */
public class DirtySessionException extends GenericException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getCode() {
		return ERROR_CODE_DIRTY_SESSION;
	}

	public DirtySessionException() {
		super("You already login this system on other device!");
	}

	public DirtySessionException(String message, Throwable cause) {
		super(message, cause);
	}

	public DirtySessionException(String message) {
		super(message);
	}

	public DirtySessionException(Throwable cause) {
		super(cause);
	}

}
