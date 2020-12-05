package com.dianaCerda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información del Envio")
@Entity
@Table(name = "envio")
public class Envio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEnvio;
	
	@ApiModelProperty(notes = "Estado debe tener minimo 50 caracteres")
	@Size(min = 50, message = "Estado debe tener minimo 50 caracteres")
	@Column(name = "estado_envio", nullable = true, length = 50)
	private String estadoEnvio;
	
	//Getters y Setters

	public Integer getIdEnvio() {
		return idEnvio;
	}

	public void setIdEnvio(Integer idEnvio) {
		this.idEnvio = idEnvio;
	}

	public String getEstadoEnvio() {
		return estadoEnvio;
	}

	public void setEstadoEnvio(String estadoEnvio) {
		this.estadoEnvio = estadoEnvio;
	}

}
