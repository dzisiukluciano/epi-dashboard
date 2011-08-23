
package com.epidataconsulting.metrics.common.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="metricas")
public class Metric extends AbstractDomain {

	@Column(name="metrica_id")
	String metricaID;
	
	@Column(name="metrica_descripcion")
	String mtrdescription;
	
	@Column(name="valor")
	Double value;
	
	@Column(name="autocalculate")
	boolean autocalculate;
	
	@Column(name="proceso_id")
	String procesoid;
	
	@Column(name="metodo_de_calculo")
	String metodoCalculo;
	
	@Column(name="argumento")
	String argument;
	public String getArgument() {
		return argument;
	}

	public void setArgument(String argument) {
		this.argument = argument;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public void setPackID(Long packID) {
		this.packID = packID;
	}

	@Column(name="pack_id")
	Long packID;
	
	public Metric(String id){
		metricaID=id;
	}
	
	public Metric() {
		// TODO Auto-generated constructor stub
	}

	public String getMetodoCalculo() {
		return metodoCalculo;
	}
	
	public void setMetodoCalculo(String metodoCalculo) {
		this.metodoCalculo = metodoCalculo;
	}


	
	//getters y setters
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public boolean isAutocalculate() {
		return autocalculate;
	}

	public void setAutocalculate(boolean autocalculate) {
		this.autocalculate = autocalculate;
	}


	public String getMetrica_id() {
		return metricaID;
	}

	public void setMetrica_id(String mtrid) {
		this.metricaID = mtrid;
	}

	public String getMtrdescription() {
		return mtrdescription;
	}

	public void setMtrdescription(String mtrdescription) {
		this.mtrdescription = mtrdescription;
	}
	public String getProcesoid() {
		return procesoid;
	}
	public void setProcesoid(String procesoid) {
		this.procesoid = procesoid;
	}

	public String getMetricaID() {
		return metricaID;
	}

	public void setMetricaID(String metricaID) {
		this.metricaID = metricaID;
	}

	public long getPackID() {
		return packID;
	}

	public void setPackID(long packID) {
		this.packID = packID;
	}


	
}
