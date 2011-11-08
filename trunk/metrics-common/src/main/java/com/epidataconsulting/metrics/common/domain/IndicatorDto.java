package com.epidataconsulting.metrics.common.domain;


public class IndicatorDto {
	
	private Integer id;
	
	private String code;
	
	private Double valor;

	private IndicatorScale indicatorscale;
	
	
	public IndicatorDto() {}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public IndicatorScale getIndicatorscale() {
		return indicatorscale;
	}

	public void setIndicatorscale(IndicatorScale indicatorscale) {
		this.indicatorscale = indicatorscale;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}	
	
}
