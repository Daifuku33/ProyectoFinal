package com.dianaCerda.dto;

public class EnvioResumenDTO {
	
	private Integer cantidad;
	private String fecha;
	
	public EnvioResumenDTO() {
		
	}
	
	public EnvioResumenDTO(Integer cantidad, String fecha) {
		super();
		this.cantidad = cantidad;
		this.fecha = fecha;
	}
	
	//Getters y Setters

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
