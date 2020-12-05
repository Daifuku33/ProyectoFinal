package com.dianaCerda.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dianaCerda.model.ResetToken;


public interface IResetTokenRepo extends JpaRepository<ResetToken, Integer>{

	ResetToken findByToken(String token);
}
