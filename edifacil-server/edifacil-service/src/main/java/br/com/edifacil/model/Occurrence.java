package br.com.edifacil.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the occurrence database table.
 * 
 */
@Entity
@NamedQuery(name="Occurrence.findAll", query="SELECT o FROM Occurrence o")
public class Occurrence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="creation_date")
	private Date creationDate;

	private String description;

	private String status;

	//bi-directional many-to-one association to OccurrenceType
	@ManyToOne
	@JoinColumn(name="occurrence_type_id")
	private OccurrenceType occurrenceType;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Occurrence() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public OccurrenceType getOccurrenceType() {
		return this.occurrenceType;
	}

	public void setOccurrenceType(OccurrenceType occurrenceType) {
		this.occurrenceType = occurrenceType;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}