package com.dianaCerda.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@Table(name = "consulta_envio")
@IdClass(ConsultaEnvioPK.class)
public class ConsultaEnvio {

	@Id
	private Envio envio;
	
	@Id
	private Venta venta;
	
	//Getters y Setters

	public Envio getEnvio() {
		return envio;
	}

	public void setEnvio(Envio envio) {
		this.envio = envio;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	
	
}
