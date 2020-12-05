package com.dianaCerda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información del cliente")
@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente; 
	
	@ApiModelProperty(notes = "Nombre debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Nombre debe tener minimo 3 caracteres")
	@Column(name = "nombre", nullable = false, length = 80)
	private String nombreCliente;
	
	@ApiModelProperty(notes = "Apellido debe tener minimo 3 caracteres")
	@Size(min = 3, message = "Apellido debe tener minimo 3 caracteres")
	@Column(name = "apellido", nullable = false, length = 80)
	private String apellidoCliente;
	
	@ApiModelProperty(notes = "Rut debe tener 8 caracteres")
	@Size(min = 8, max = 8, message = "Rut debe tener 8 caracteres")
	@Column(name = "rut", nullable = false, length = 8)
	private String rut;
	
	@ApiModelProperty(notes = "Dirección debe tener minimo 3 caracteres")
	@Size(min = 3, max = 150, message = "Dirección debe tener minimo 3 caracteres")
	@Column(name = "direccion", nullable = true, length = 150)
	private String direccion;
	
	@ApiModelProperty(notes = "Teléfono debe tener 9 caracteres")
	@Size(min = 9, max = 9, message = "Teléfono debe tener 9 caracteres")
	@Column(name = "teléfono", nullable = true, length = 9)
	private String telefono;
	
	@Email
	@Column(name = "email", nullable = true, length = 55)
	private String email;
	
	//Getters y Setters

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
