package com.dianaCerda.service;

import java.util.List;

import com.dianaCerda.dto.EnvioResumenDTO;
import com.dianaCerda.dto.FiltroVentaDTO;
import com.dianaCerda.dto.VentaListaEnvioDTO;
import com.dianaCerda.model.Venta;

public interface IVentaService extends ICRUD<Venta>{

	Venta registrarTransaccional(VentaListaEnvioDTO dto);
	
	List<Venta> buscar(FiltroVentaDTO filtro);
	
	List<Venta> buscarFecha(FiltroVentaDTO filtro);
	
	List<EnvioResumenDTO> listarResumen();
	
	byte[] generarReporte();
	
}
