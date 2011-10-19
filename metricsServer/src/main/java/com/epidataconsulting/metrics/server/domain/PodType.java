package com.epidataconsulting.metrics.server.domain;

import javax.persistence.*;

import com.epidataconsulting.metrics.common.domain.AbstractDomain;

@Entity
@Table(name = "pod_type")
public class PodType extends AbstractDomain{
	
	@Column(nullable = false)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
