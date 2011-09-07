package com.epidataconsulting.metrics.server.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "tabs")
public class Tab {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name="tab_pod",
			joinColumns = {@JoinColumn(name="tab_id", unique = true)},
			inverseJoinColumns = {@JoinColumn(name= "pod_id")}     
	)
	private List<Pod> pods;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
