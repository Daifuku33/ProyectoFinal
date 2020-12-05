package com.dianaCerda.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información de la venta")
@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalleVenta;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_venta", nullable = false, foreignKey = @ForeignKey(name = "FK_consulta_venta"))
	private Venta venta;
	
	@ApiModelProperty(notes = "Detalle de envío debe tener minimo 70 caracteres")
	@Size(min = 70, message = "Detalle de envío debe tener minimo 70 caracteres")
	@Column(name = "detalle", nullable = false, length = 70)
	private String detalle;
	
	@ApiModelProperty(notes = "Detalle de envío debe tener minimo 50 caracteres")
	@Size(min = 50, message = "Detalle de envío debe tener minimo 50 caracteres")
	@Column(name = "total", nullable = false, length = 50)
	private double total;
	
	//Getters y Setters

	public int getIdDetalleVenta() {
		return idDetalleVenta;
	}

	public void setIdDetalleVenta(int idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
