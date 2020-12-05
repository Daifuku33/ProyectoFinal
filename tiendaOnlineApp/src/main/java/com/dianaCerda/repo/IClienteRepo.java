package com.dianaCerda.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dianaCerda.model.Cliente;

public interface IClienteRepo extends JpaRepository<Cliente, Integer>{

}
