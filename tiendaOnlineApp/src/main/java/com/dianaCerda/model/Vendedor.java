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

@ApiModel(description = "Información del Vendedor")
@Entity
@Table(name = "vendedor")
public class Vendedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVendedor;
	
	@ApiModelProperty(notes = "Nombre del vendedor debe tener minimo 5 caracteres")
	@Size(min = 5, message = "Nombre del vendedor debe tener minimo 5 caracteres")
	@Column(name = "nombre_vendedor", nullable = false, length = 70)
	private String nombreVendedor;
	
	@ApiModelProperty(notes = "Apellido del vendedor debe tener minimo 5 caracteres")
	@Size(min = 5, message = "Apellido del vendedor debe tener minimo 5 caracteres")
	@Column(name = "apellido_vendedor", nullable = false, length = 70)
	private String apellidoVendedor;
	
	//Getters y Setters
	
	public Integer getIdVendedor() {
		return idVendedor;
	}

	public void setIdMedico(Integer idVendedor) {
		this.idVendedor = idVendedor;
	}

	public String getNombreVendedor() {
		return nombreVendedor;
	}

	public void setNombreVendedor(String nombreVendedor) {
		this.nombreVendedor = nombreVendedor;
	}

	public String getApellidoVendedor() {
		return apellidoVendedor;
	}

	public void setApellidoVendedor(String apellidoVendedor) {
		this.apellidoVendedor = apellidoVendedor;
	}
}
