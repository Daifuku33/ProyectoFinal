package com.dianaCerda.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dianaCerda.model.ResetToken;
import com.dianaCerda.repo.IResetTokenRepo;
import com.dianaCerda.service.IResetTokenService;

@Service
public class ResetTokenServiceImpl implements IResetTokenService{

	@Autowired
	private IResetTokenRepo repo;

	@Override
	public ResetToken findByToken(String token) {
		return repo.findByToken(token);
	}

	@Override
	public void guardar(ResetToken token) {
		repo.save(token);
	}

	@Override
	public void eliminar(ResetToken token) {
		repo.delete(token);		
	}
}
