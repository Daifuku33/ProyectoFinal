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

@ApiModel(description = "Información del Archivo")
@Entity
@Table(name = "archivo")
public class Archivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idArchivo;
	
	@ApiModelProperty(notes = "Nombre de archivo debe tener minimo 50 caracteres")
	@Size(min = 50, message = "Nombre de archivo debe tener minimo 50 caracteres")
	@Column(name = "filename", length = 50) 
	private String filename;
	
	@ApiModelProperty(notes = "Tipo debe tener minimo 15 caracteres")
	@Size(min = 15, message = "Tipo debe tener minimo 15 caracteres")
	@Column(name = "filetype", length = 15)
	private String filetype;
	
	@Column(name = "contenido")
	private byte[] value;
	
	//Getters y Setters

	public Integer getIdArchivo() {
		return idArchivo;
	}

	public void setIdArchivo(Integer idArchivo) {
		this.idArchivo = idArchivo;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public byte[] getValue() {
		return value;
	}

	public void setValue(byte[] value) {
		this.value = value;
	}
	
}
