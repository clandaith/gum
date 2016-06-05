package com.clandaith.gum.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String username;

	@Enumerated(EnumType.STRING)
	private ROLE role;

	public enum ROLE {
		USER("ROLE_USER"), ADMIN("ROLE_ADMIN"), COMPANY("ROLE_COMPANY");

		String roleName;

		ROLE(String role) {
			this.roleName = role;
		}

		public String getRoleName() {
			return roleName;
		}
	};

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ROLE getRole() {
		return role;
	}

	public void setRole(ROLE role) {
		this.role = role;
	}

}