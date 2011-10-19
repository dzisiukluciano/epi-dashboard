package com.epidataconsulting.metrics.server.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.epidataconsulting.metrics.common.domain.AbstractDomain;

@Entity
@Table(name="metrics_usuario")
public class User extends AbstractDomain{
	
	private String name;
	
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
