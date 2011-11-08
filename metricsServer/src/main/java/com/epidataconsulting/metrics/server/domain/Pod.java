package com.epidataconsulting.metrics.server.domain;

import javax.persistence.*;

import com.epidataconsulting.metrics.common.domain.AbstractDomain;


@Entity
@Table(name = "pods")
public class Pod extends AbstractDomain{
	
	@Column(nullable = false)
	private String title;
	
	/** The table name*/
	@Column(nullable = false)
	private String dataSource;
	
	/**the column used as valueField*/
	@Column(nullable = false)
	private String valueField;
	
	/**used with charts and pieCharts
	<br>the column used as categoryField */
	private String categoryField;
	
	/**Chart, PieChart or Gauge*/
	@OneToOne
	@JoinColumn(name="type_id", nullable = false)
	private PodType type;
	
	/**used with gauges (indicator)
	<br>the name of the table where are the indicators scale */
	private String joinTable;
	
	/**used with gauges (indicator)
	<br>the value used in the 'where code=@code' sql sentence*/
	private String code;


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

	public void setJoinTable(String joinTable) {
		this.joinTable = joinTable;
	}

	public String getJoinTable() {
		return joinTable;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
	
}
