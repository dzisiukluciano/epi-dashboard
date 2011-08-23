package com.epidataconsulting.metrics.common.domain;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.epidataconsulting.metrics.common.domain.AbstractDomain;
@Entity
@Table(name="indicadores")
public class Indicator extends AbstractDomain  {
	
	@Column(unique=true)
	String code;
	
	@Column(name="descripcion")
	String name;
	
	@Column(name="valor")
	double valor;

	@Column(name="fecha")
	Date fecha;
	
	@Column(name = "actualizado")
	Boolean actualizado ;
	


	@OneToOne
	IndicatorScale indicatorscale;
	
	@OneToOne(fetch = FetchType.LAZY)
	Regla regla;

	@Transient
	String estado;
	
	public Indicator() {
	}
	
	public Indicator(String id){
		 code=id; 
		 name="name"+id;
		 valor = 5*(Integer.parseInt(id));
		 estado="Bueno";
	}
	
	
	public void evaluateQuality() {
		
		if(indicatorscale.getMinimo()<indicatorscale.getMaximo()){
			indicatorscale.setReverse(false);
			if(getValor()< indicatorscale.getMinimo()){
				setEstado("Malo");
			}
			if(getValor()< indicatorscale.getRegular()){
				setEstado("Regular");
			}
			else if(getValor()< indicatorscale.getBueno()){
				setEstado("Bueno");
			}	
			else {
				setEstado("Excelente");
			}
		}else{
			indicatorscale.setReverse(true);
			if(getValor()< indicatorscale.getMaximo()){
				setEstado("Excelente");
			}
			else if(getValor()< indicatorscale.getBueno()){
				setEstado("Bueno");
			}
			else if(getValor()<indicatorscale.getRegular()){
				setEstado("Regular");
			}else {
				setEstado("Malo");
			}
		}
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public IndicatorScale getIndicatorscale() {
		return indicatorscale;
	}

	public void setIndicatorscale(IndicatorScale indicatorscale) {
		this.indicatorscale = indicatorscale;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	public Regla getRegla() {
		return regla;
	}

	public void setRegla(Regla regla) {
		this.regla = regla;
	}
	public Boolean getActualizado() {
		return actualizado;
	}

	public void setActualizado(Boolean actualizado) {
		this.actualizado = actualizado;
	}
}
