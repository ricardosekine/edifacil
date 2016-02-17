package br.com.edifacil.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


// TODO: Auto-generated Javadoc
/**
 * The persistent class for the occurrence database table.
 * 
 */
@Entity
@NamedQuery(name="Occurrence.findAll", query="SELECT o FROM Occurrence o")
public class Occurrence implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	/** The creation date. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="creation_date")
	private Date creationDate;

	/** The title. */
	private String title;
	
	/** The description. */
	private String description;

	/** The status. */
	private String status;

	/** The occurrence type. */
	//bi-directional many-to-one association to OccurrenceType
	@ManyToOne
	@JoinColumn(name="occurrence_type_id")
	private OccurrenceType occurrenceType;

	/** The user. */
	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	/**
	 * Instantiates a new occurrence.
	 */
	public Occurrence() {
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the creation date.
	 *
	 * @return the creation date
	 */
	public Date getCreationDate() {
		return this.creationDate;
	}

	/**
	 * Sets the creation date.
	 *
	 * @param creationDate the new creation date
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the occurrence type.
	 *
	 * @return the occurrence type
	 */
	public OccurrenceType getOccurrenceType() {
		return this.occurrenceType;
	}

	/**
	 * Sets the occurrence type.
	 *
	 * @param occurrenceType the new occurrence type
	 */
	public void setOccurrenceType(OccurrenceType occurrenceType) {
		this.occurrenceType = occurrenceType;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return this.user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}

}