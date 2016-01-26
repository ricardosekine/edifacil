package br.com.ichei.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the object_attachments database table.
 * 
 */
@Entity
@Table(name="object_attachments")
@NamedQuery(name="ObjectAttachment.findAll", query="SELECT o FROM ObjectAttachment o")
public class ObjectAttachment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Lob
	@Column(name="file_path")
	private String filePath;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="insert_date")
	private Date insertDate;

	//bi-directional many-to-one association to ObjectInfo
	@ManyToOne
	@JoinColumn(name="object_info_id")
	private ObjectInfo objectInfo;

	public ObjectAttachment() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public ObjectInfo getObjectInfo() {
		return this.objectInfo;
	}

	public void setObjectInfo(ObjectInfo objectInfo) {
		this.objectInfo = objectInfo;
	}

}