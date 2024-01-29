package com.ntt.infra.model;

import java.io.Serializable;


import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "user")
public class User implements Serializable {

	public static final long serialVersionUID = 1;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PASSWD")
	private String passwd;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Role_ID", referencedColumnName = "ID", nullable = false)
	private Role role;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	@JsonIgnore
	private List<SRDetails> sr_details;

	public User() {

	}

	public User(String name, String passwd, Role role, List<SRDetails> sr_details) {
		super();

		this.name = name;
		this.passwd = passwd;
		this.role = role;
		this.sr_details = sr_details;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the passwd
	 */
	public String getPasswd() {
		return passwd;
	}

	/**
	 * @param passwd the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the sr_details
	 */
	public List<SRDetails> getSr_details() {
		return sr_details;
	}

	/**
	 * @param sr_details the sr_details to set
	 */
	public void setSr_details(List<SRDetails> sr_details) {
		this.sr_details = sr_details;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", passwd=" + passwd + ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, passwd);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(passwd, other.passwd);
	}

}
