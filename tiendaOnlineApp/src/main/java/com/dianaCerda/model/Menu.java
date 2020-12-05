package com.dianaCerda.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información del Menu")
@Entity
@Table(name = "menu")
public class Menu {
	
	@Id
	private Integer idMenu;
	
	@Column(name = "icono", length = 20)
	private String icono;
	
	@ApiModelProperty(notes = "Nombre debe tener minimo 20 caracteres")
	@Size(min = 20, message = "Nombre debe tener minimo 20 caracteres")
	@Column(name = "nombre", length = 20)
	private String nombre;
	
	@ApiModelProperty(notes = "Url debe tener minimo 50 caracteres")
	@Size(min = 50, message = "Url debe tener minimo 50 caracteres")
	@Column(name = "url", length = 50)
	private String url;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "menu_rol", joinColumns = @JoinColumn(name = "id_menu", referencedColumnName = "idMenu"), inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idRol"))
	private List<Rol> roles;
	
	//Getters y Setters

	public Integer getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	

}
