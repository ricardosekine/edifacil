package br.com.edifacil.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the object_info database table.
 * 
 */
@Entity
@Table(name="object_info")
@NamedQuery(name="ObjectInfo.findAll", query="SELECT o FROM ObjectInfo o")
public class ObjectInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Lob
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="insert_date")
	private Date insertDate;

	//bi-directional many-to-one association to ObjectAttachment
	@OneToMany(mappedBy="objectInfo")
	private Set<ObjectAttachment> objectAttachments;

	//bi-directional many-to-one association to Object
	@ManyToOne
	private Object object;

	//bi-directional many-to-one association to UserInfo
	@ManyToOne
	@JoinColumn(name="user_info_id")
	private UserInfo userInfo;

	public ObjectInfo() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public Set<ObjectAttachment> getObjectAttachments() {
		return this.objectAttachments;
	}

	public void setObjectAttachments(Set<ObjectAttachment> objectAttachments) {
		this.objectAttachments = objectAttachments;
	}

	public ObjectAttachment addObjectAttachment(ObjectAttachment objectAttachment) {
		getObjectAttachments().add(objectAttachment);
		objectAttachment.setObjectInfo(this);

		return objectAttachment;
	}

	public ObjectAttachment removeObjectAttachment(ObjectAttachment objectAttachment) {
		getObjectAttachments().remove(objectAttachment);
		objectAttachment.setObjectInfo(null);

		return objectAttachment;
	}

	public Object getObject() {
		return this.object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}