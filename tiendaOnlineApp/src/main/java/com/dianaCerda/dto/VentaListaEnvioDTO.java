package com.dianaCerda.dto;

import java.util.List;

import com.dianaCerda.model.Envio;
import com.dianaCerda.model.Venta;

public class VentaListaEnvioDTO {

	private Venta venta;
	private List<Envio> lstEnvio;
	
	//getters y setters
	
	public Venta getVenta() {
		return venta;
	}
	
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	
	public List<Envio> getLstEnvio() {
		return lstEnvio;
	}
	
	public void setLstEnvio(List<Envio> lstEnvio) {
		this.lstEnvio = lstEnvio; 
	}
}
