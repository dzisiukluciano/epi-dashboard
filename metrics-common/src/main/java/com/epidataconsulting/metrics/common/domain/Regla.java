package com.epidataconsulting.metrics.common.domain;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.springframework.context.annotation.Lazy;




@Entity
@Table(name="reglas")
public class Regla extends AbstractDomain {
	
	@Column(name="reglaid")
	String reglaid;
	
	@Column(name="descripcion")
	String descripcion;
	
	@Column(name="formula")
	String formula;
	
	@Column(name="valor")
	Double valor;
	//, fetch = FetchType.EAGER
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "reglas_metricas", joinColumns = { @JoinColumn(name = "reglaid") },
			inverseJoinColumns = { @JoinColumn(name = "metricaid") })
	
	List<Metric> metricas;
	
	@Transient
	private List<String> reglasid;
	
	public Regla (String id ){
		
		this.reglaid= id ;
	}
	public Regla() {
		// TODO Auto-generated constructor stub
	}
	public void createMetrics(){
		
		this.metricas = new ArrayList<Metric>();
	}
	public void setMetric(int pos , Metric metric){
		
		metricas.remove(pos);
		metricas.add(pos, metric);
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public String getReglaid() {
		return reglaid;
	}
	public void setReglaid(String reglaid) {
		this.reglaid = reglaid;
	}
	public String getFormula() {
		return formula;
	}
	public void setFormula(String formula) {
		this.formula = formula;
	}
	public List<String> getReglasid() {
		return reglasid;
	}
	public void setReglasid(List<String> reglasid) {
		this.reglasid = reglasid;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<Metric> getMetricas() {
		return metricas;
	}
	public void setMetricas(List<Metric> metricas) {
		this.metricas = metricas;
	}
	
}
