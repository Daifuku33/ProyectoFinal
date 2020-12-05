package com.dianaCerda.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dianaCerda.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{

		Usuario findOneByUsername(String username);
}
