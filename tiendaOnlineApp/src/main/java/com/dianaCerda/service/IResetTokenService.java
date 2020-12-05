package com.dianaCerda.service;

import com.dianaCerda.model.ResetToken;

public interface IResetTokenService {

	ResetToken findByToken(String token);
	void guardar(ResetToken token);
	void eliminar(ResetToken token);
}
