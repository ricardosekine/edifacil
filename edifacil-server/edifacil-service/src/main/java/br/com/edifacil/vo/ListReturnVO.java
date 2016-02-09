package br.com.edifacil.vo;

import java.io.Serializable;
import java.util.List;

/**
 * The Class ListReturnVO.
 *
 * @param <E> the element type
 */
public class ListReturnVO <E> implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The return list. */
	private List<E> returnList;
	
	/** The message. */
	private String message;

	/**
	 * Gets the return list.
	 *
	 * @return the returnList
	 */
	public List<E> getReturnList() {
		return returnList;
	}

	/**
	 * Sets the return list.
	 *
	 * @param returnList the returnList to set
	 */
	public void setReturnList(List<E> returnList) {
		this.returnList = returnList;
	}

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
	
}
