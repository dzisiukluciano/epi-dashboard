package com.epidataconsulting.metrics.common.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="indicators")
public class Indicator extends AbstractDomain  {
	
	@Column(unique=true, length=32)
	private String code;
	
	private String nombre;
	
	private Double valor;

	private Date fecha;

	private Boolean actualizado;

	@OneToOne
	private IndicatorScale indicatorscale;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Regla regla;

	
	public Indicator() {}

	
	/*
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
	}*/

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Boolean getActualizado() {
		return actualizado;
	}

	public void setActualizado(Boolean actualizado) {
		this.actualizado = actualizado;
	}

	public IndicatorScale getIndicatorscale() {
		return indicatorscale;
	}

	public void setIndicatorscale(IndicatorScale indicatorscale) {
		this.indicatorscale = indicatorscale;
	}

	public Regla getRegla() {
		return regla;
	}

	public void setRegla(Regla regla) {
		this.regla = regla;
	}
	
}
