package com.epidataconsulting.metrics.server.domain;

import javax.persistence.*;


@Entity
@Table(name = "pods")
public class Pod {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String dataSource;
	
	private Integer selectedViewIndex;
	
	@Column(nullable = false)
	private String valueField;
	
	@Column(nullable = false)
	private String categoryField;
	
	@OneToOne
	@JoinColumn(name="type_id", nullable = false)
	private PodType type;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public int getSelectedViewIndex() {
		return selectedViewIndex;
	}

	public void setSelectedViewIndex(int selectedViewIndex) {
		this.selectedViewIndex = selectedViewIndex;
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
