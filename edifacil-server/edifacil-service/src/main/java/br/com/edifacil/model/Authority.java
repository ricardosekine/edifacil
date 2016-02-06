package br.com.edifacil.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the authority database table.
 * 
 */
@Entity
@NamedQuery(name="Authority.findAll", query="SELECT a FROM Authority a")
public class Authority implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String role;

	@Column(name="user_id")
	private Long userId;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="id")
	private User user;

	public Authority() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}