package com.epidataconsulting.metrics.server.domain;

import java.util.List;

import javax.persistence.*;

import com.epidataconsulting.metrics.common.domain.AbstractDomain;

@Entity
@Table(name = "tabs")
public class Tab extends AbstractDomain{
	
	@Column(nullable = false)
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinTable(name="tab_pod",
			joinColumns = {@JoinColumn(name="tab_id", unique = true)},
			inverseJoinColumns = {@JoinColumn(name= "pod_id")}     
	)
	private List<Pod> pods;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Pod> getPods() {
		return pods;
	}
	public void setPods(List<Pod> pods) {
		this.pods = pods;
	}
	
	

}
