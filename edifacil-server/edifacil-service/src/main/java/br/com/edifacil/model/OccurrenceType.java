package br.com.edifacil.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the occurrence_type database table.
 * 
 */
@Entity
@Table(name="occurrence_type")
@NamedQuery(name="OccurrenceType.findAll", query="SELECT o FROM OccurrenceType o")
public class OccurrenceType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;

	//bi-directional many-to-one association to Occurrence
	@OneToMany(mappedBy="occurrenceType")
	private List<Occurrence> occurrences;

	public OccurrenceType() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Occurrence> getOccurrences() {
		return this.occurrences;
	}

	public void setOccurrences(List<Occurrence> occurrences) {
		this.occurrences = occurrences;
	}

	public Occurrence addOccurrence(Occurrence occurrence) {
		getOccurrences().add(occurrence);
		occurrence.setOccurrenceType(this);

		return occurrence;
	}

	public Occurrence removeOccurrence(Occurrence occurrence) {
		getOccurrences().remove(occurrence);
		occurrence.setOccurrenceType(null);

		return occurrence;
	}

}