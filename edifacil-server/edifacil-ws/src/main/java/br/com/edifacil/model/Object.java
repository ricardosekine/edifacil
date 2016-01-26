package br.com.edifacil.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the object database table.
 * 
 */
@Entity
@NamedQuery(name="Object.findAll", query="SELECT o FROM Object o")
public class Object implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Lob
	private String desc;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="insert_date")
	private Date insertDate;

	private String name;

	//bi-directional many-to-one association to ObjectType
	@ManyToOne
	@JoinColumn(name="object_type_id")
	private ObjectType objectType;

	//bi-directional many-to-one association to ObjectInfo
	@OneToMany(mappedBy="object")
	private Set<ObjectInfo> objectInfos;

	public Object() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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

	public ObjectType getObjectType() {
		return this.objectType;
	}

	public void setObjectType(ObjectType objectType) {
		this.objectType = objectType;
	}

	public Set<ObjectInfo> getObjectInfos() {
		return this.objectInfos;
	}

	public void setObjectInfos(Set<ObjectInfo> objectInfos) {
		this.objectInfos = objectInfos;
	}

	public ObjectInfo addObjectInfo(ObjectInfo objectInfo) {
		getObjectInfos().add(objectInfo);
		objectInfo.setObject(this);

		return objectInfo;
	}

	public ObjectInfo removeObjectInfo(ObjectInfo objectInfo) {
		getObjectInfos().remove(objectInfo);
		objectInfo.setObject(null);

		return objectInfo;
	}

}