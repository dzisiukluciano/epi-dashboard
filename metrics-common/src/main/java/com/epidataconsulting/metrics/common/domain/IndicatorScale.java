package com.epidataconsulting.metrics.common.domain;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.epidataconsulting.metrics.common.domain.AbstractDomain;
@Entity
@Table(name="indicador_escala")
public class IndicatorScale extends AbstractDomain {
	
	@Column(name="code")
	String code;
	@Column(name="minimo")
	double minimo;
	@Column(name="regular")
	double regular;
	@Column(name="bueno")
	double bueno;
	@Column(name="maximo")
	double maximo;
	@Transient
	Boolean reverse;
	@Transient
	double posicionminReg;
	@Transient
	double posicionregBuena;
	@Transient
	double posicionbuenaMax;
	
	public IndicatorScale(){
		
	}

	public void calcularValorPossionesIntermedias(){
		posicionminReg = (int)((regular-minimo)/2)+minimo;
		posicionregBuena = (int)((bueno-regular)/2)+regular;
		posicionbuenaMax = (int)((maximo-bueno)/2)+bueno;		
	}

	public void redondiarValores(){
		
		minimo = (int)(minimo);
		regular= (int)(regular);
		bueno = (int)(bueno);
		maximo = (int)(maximo);
	}
	
	public void setDefaultValues(){
		minimo=0;
		regular = 50 ;
		bueno=75;
		maximo=100;
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

	public void readExternal(ObjectInput in) throws IOException,ClassNotFoundException 
	{
		
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
