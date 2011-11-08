package com.epidataconsulting.metrics.server.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.epidataconsulting.metrics.common.domain.AbstractDomain;

@Entity
@Table(name = "pod_type")
public class PodType extends AbstractDomain{
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private PodTypeName name;

	public void setName(PodTypeName name) {
		this.name = name;
	}

	public PodTypeName getName() {
		return name;
	}



	
	
	
}
