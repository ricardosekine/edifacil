package br.com.edifacil.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the object_type database table.
 * 
 */
@Entity
@Table(name="object_type")
@NamedQuery(name="ObjectType.findAll", query="SELECT o FROM ObjectType o")
public class ObjectType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="insert_date")
	private Date insertDate;

	private String name;

	//bi-directional many-to-one association to Object
	@OneToMany(mappedBy="objectType")
	private Set<Object> objects;

	public ObjectType() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Object> getObjects() {
		return this.objects;
	}

	public void setObjects(Set<Object> objects) {
		this.objects = objects;
	}

	public Object addObject(Object object) {
		getObjects().add(object);
		object.setObjectType(this);

		return object;
	}

	public Object removeObject(Object object) {
		getObjects().remove(object);
		object.setObjectType(null);

		return object;
	}

}