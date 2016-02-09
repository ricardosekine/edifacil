package br.com.edifacil.vo;

import java.io.Serializable;

/**
 * The Class ReturnVO.
 */
public class ReturnVO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The message. */
	private String message;
	
	/** The success. */
	private boolean success;
	
	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Sets the message.
	 *
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Checks if is success.
	 *
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}
	
	/**
	 * Sets the success.
	 *
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
