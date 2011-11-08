package com.epidataconsulting.metrics.common.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="indicator_scale")
public class IndicatorScale extends AbstractDomain {
	

	private String code;

	private double minimo;

	private double regular;

	private double bueno;

	private double maximo;
	@Transient
	private Boolean reverse;
	@Transient
	private double posicionminReg;
	@Transient
	private double posicionregBuena;
	@Transient
	private double posicionbuenaMax;
	
	public IndicatorScale(){
		setDefaultValues();
	}

	public void calcularValores(){
		posicionminReg = (int)((regular-minimo)/2)+minimo;
		posicionregBuena = (int)((bueno-regular)/2)+regular;
		posicionbuenaMax = (int)((maximo-bueno)/2)+bueno;
		redondearValores();
		if(maximo < minimo)
			reverse = true;
	}

	private void redondearValores(){
		
		minimo = (int)(minimo);
		regular= (int)(regular);
		bueno = (int)(bueno);
		maximo = (int)(maximo);
	}
	
	private void setDefaultValues(){
		minimo = 0;
		regular = 50;
		bueno = 75;
		maximo = 100;
	}
	
	public double getPosicionminReg() {
		return posicionminReg;
	}
	
	public void setPosicionminReg(double posicionminReg) {
		this.posicionminReg = posicionminReg;
	}

	public double getPosicionregBuena() {
		return posicionregBuena;
	}

	public void setPosicionregBuena(double posicionregBuena) {
		this.posicionregBuena = posicionregBuena;
	}

	public double getPosicionbuenaMax() {
		return posicionbuenaMax;
	}

	public void setPosicionbuenaMax(double posicionbuenaMax) {
		this.posicionbuenaMax = posicionbuenaMax;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getMinimo() {
		return minimo;
	}

	public void setMinimo(double minimo) {
		this.minimo = minimo;
	}

	public double getRegular() {
		return regular;
	}

	public void setRegular(double regular) {
		this.regular = regular;
	}

	public double getBueno() {
		return bueno;
	}

	public void setBueno(double bueno) {
		this.bueno = bueno;
	}

	public double getMaximo() {
		return maximo;
	}

	public void setMaximo(double maximo) {
		this.maximo = maximo;
	}

	public Boolean getReverse() {
		return reverse;
	}

	public void setReverse(Boolean reverse) {
		this.reverse = reverse;
	}

}
