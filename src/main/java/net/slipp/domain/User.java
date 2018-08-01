package net.slipp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User extends AbstractEntity {
	@Column(nullable = false, unique = true, length = 20)
	@JsonProperty
	private String userId;

	@JsonProperty
	private String name;

	@JsonIgnore
	private String password;

	@JsonProperty
	private String email;

	public boolean matchId(Long newId) {
		if (newId == null) {
			return false;
		}

		return newId.equals(getId());
	}

	public String getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean matchPassword(String newPassword) {
		if (newPassword == null) {
			return false;
		}

		return newPassword.equals(password);
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void update(User newUser) {
		this.password = newUser.password;
		this.name = newUser.name;
		this.email = newUser.email;
	}

	@Override
	public String toString() {
		return "User [" + super.toString() + ", name=" + name + ", password=" + password + ", email=" + email + "]";
	}
}
