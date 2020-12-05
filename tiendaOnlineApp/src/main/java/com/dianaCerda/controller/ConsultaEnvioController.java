package com.dianaCerda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dianaCerda.model.ConsultaEnvio;
import com.dianaCerda.service.IConsultaEnvioService;

@RestController
@RequestMapping("/consultaenvios")
public class ConsultaEnvioController {

	@Autowired
	private IConsultaEnvioService service;
	
	@GetMapping(value = "/{idConsulta}")
	public ResponseEntity<List<ConsultaEnvio>> listar(@PathVariable("idConsulta") Integer idenvio) {
		List<ConsultaEnvio> consultasenvio= new ArrayList<>();
		consultasenvio = service.listarEnviosPorConsulta(idenvio);
		return new ResponseEntity<List<ConsultaEnvio>>(consultasenvio, HttpStatus.OK);
	}
}
