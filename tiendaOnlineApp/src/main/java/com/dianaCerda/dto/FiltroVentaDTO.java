package com.dianaCerda.dto;

import java.time.LocalDateTime;

public class FiltroVentaDTO {

	private String rut;
	private String nombreCompleto;
	private LocalDateTime fechaVenta;
	
	//Getters y Setters
	
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public LocalDateTime getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(LocalDateTime fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
}
