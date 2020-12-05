package com.dianaCerda.model;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ConsultaEnvioPK implements Serializable{
	
	@ManyToOne
	@JoinColumn(name = "id_envio", nullable = false)
	private Envio envio;
	
	@ManyToOne
	@JoinColumn(name = "id_venta", nullable = false)
	private Venta venta; 
	
	
}
