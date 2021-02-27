package algorSystemCourse.s3.w12.fromGithub;

public class NodeAlreadyExistsException extends Exception {

	public static final String MESSAGE = "A Node already exists that contains the int value: ";

	public NodeAlreadyExistsException() {

	}

	public NodeAlreadyExistsException(String message) {
		super(message);
	}
}
