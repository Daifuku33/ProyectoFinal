package com.dianaCerda.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dianaCerda.model.Venta;


public interface IVentaRepo extends JpaRepository<Venta, Integer>{
	
	
	@Query("from Venta v where v.fechaVenta between :fechaVenta and :fechaSgte")
	List<Venta> buscarFecha(@Param("fechaVenta") LocalDateTime fechaVenta, @Param("fechaSgte") LocalDateTime fechaSgte);
	
	@Query(value = "select * from fn_listarResumen()", nativeQuery = true)
	List<Object[]> listarResumen();

	@Query("from Venta v where v.cliente.rut =:rut or LOWER(v.cliente.nombreCliente) like %:nombreCompleto% or LOWER(v.cliente.apellidoCliente) like %:nombreCompleto%")
	List<Venta> buscar(@Param("rut")String rut,@Param("nombreCompleto") String nombreCompleto);
	
}
