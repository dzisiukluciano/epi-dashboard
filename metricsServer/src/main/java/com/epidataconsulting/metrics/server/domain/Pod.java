package com.epidataconsulting.metrics.server.domain;

import javax.persistence.*;

import com.epidataconsulting.metrics.common.domain.AbstractDomain;


@Entity
@Table(name = "pods")
public class Pod extends AbstractDomain{
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String dataSource;
	
	@Column(nullable = false)
	private String valueField;
	
	@Column(nullable = false)
	private String categoryField;
	
	@OneToOne
	@JoinColumn(name="type_id", nullable = false)
	private PodType type;


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getValueField() {
		return valueField;
	}

	public void setValueField(String valueField) {
		this.valueField = valueField;
	}

	public String getCategoryField() {
		return categoryField;
	}

	public void setCategoryField(String categoryField) {
		this.categoryField = categoryField;
	}

	public PodType getType() {
		return type;
	}

	public void setType(PodType type) {
		this.type = type;
	}
	
}
