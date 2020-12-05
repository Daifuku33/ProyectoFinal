package com.dianaCerda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dianaCerda.model.ConsultaEnvio;
import com.dianaCerda.service.IConsultaEnvioService;

@Service
public class ConsultaEnvioServiceImpl implements IConsultaEnvioService{
	
	@Autowired
	private IConsultaEnvioService repo;

	@Override
	public List<ConsultaEnvio> listarEnviosPorConsulta(Integer idEnvio) {
		return repo.listarEnviosPorConsulta(idEnvio);
	}

}
