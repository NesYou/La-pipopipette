package vs;

public class DejaPresentException extends Exception {
	String message;
	public DejaPresentException(String message){
		this.message=message;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}