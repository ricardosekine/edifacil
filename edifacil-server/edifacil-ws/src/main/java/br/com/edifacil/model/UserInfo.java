package br.com.edifacil.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the user_info database table.
 * 
 */
@Entity
@Table(name="user_info")
@NamedQuery(name="UserInfo.findAll", query="SELECT u FROM UserInfo u")
public class UserInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="insert_date")
	private Date insertDate;

	private String lastname;

	private String name;

	private String nationality;

	//bi-directional many-to-one association to ObjectInfo
	@OneToMany(mappedBy="userInfo")
	private Set<ObjectInfo> objectInfos;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="id")
	private User user;

	public UserInfo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Set<ObjectInfo> getObjectInfos() {
		return this.objectInfos;
	}

	public void setObjectInfos(Set<ObjectInfo> objectInfos) {
		this.objectInfos = objectInfos;
	}

	public ObjectInfo addObjectInfo(ObjectInfo objectInfo) {
		getObjectInfos().add(objectInfo);
		objectInfo.setUserInfo(this);

		return objectInfo;
	}

	public ObjectInfo removeObjectInfo(ObjectInfo objectInfo) {
		getObjectInfos().remove(objectInfo);
		objectInfo.setUserInfo(null);

		return objectInfo;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}