package com.dianaCerda.service;

import java.util.List;

import com.dianaCerda.model.ConsultaEnvio;



public interface IConsultaEnvioService {
	
	List<ConsultaEnvio> listarEnviosPorConsulta(Integer idEnvio);

}
