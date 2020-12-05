package com.dianaCerda.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.dianaCerda.model.Envio;
import com.dianaCerda.repo.IEnvioRepo;
import com.dianaCerda.service.IEnvioService;

public class EnvioServiceImpl implements IEnvioService{

	@Autowired
	private IEnvioRepo repo;

	@Override
	public Envio registrar(Envio obj) {
		return repo.save(obj);
	}

	@Override
	public Envio modificar(Envio obj) {
		return repo.save(obj);
	}

	@Override
	public List<Envio> listar() {
		return repo.findAll();
	}

	@Override
	public Envio leerPorId(Integer id) {
		Optional<Envio> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Envio();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
}
