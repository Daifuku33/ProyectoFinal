package com.dianaCerda.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dianaCerda.model.Producto;

public interface IProductoRepo extends JpaRepository<Producto, Integer>{

}
