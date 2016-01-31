package br.com.edifacil.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 *
 * @author Ricardo
 */
@Entity
public class User {

	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	/** The user name. */
	private String name;
	
	/** The password. */
	private String password;
	
	/** The is logged. */
	@Transient
	private boolean isLogged;
	
	/** The message. */
	@Transient
	private String message;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the checks if is logged.
	 *
	 * @return the checks if is logged
	 */
	public boolean getIsLogged() {
		return isLogged;
	}
	
	/**
	 * Sets the logged.
	 *
	 * @param isLogged the new logged
	 */
	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
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

	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

}
