package daniel.netanel.expensesmanagement;

/**
 * The specific Exception of the project
 */
@SuppressWarnings("serial")
public class MovementPlatformException extends Exception {

	public MovementPlatformException() {
		super();
	}

	public MovementPlatformException(String message) {
		super(message);
	}

	public MovementPlatformException(String message, Throwable cause) {
		super(message, cause);
	}
}