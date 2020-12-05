package com.dianaCerda.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dianaCerda.model.ConsultaEnvio;

public interface IConsultaEnvioRepo extends JpaRepository<ConsultaEnvio, Integer> {
	
	@Modifying
	@Query(value = "INSERT INTO consulta_envio(id_consulta, id_envio) VALUES (:idConsulta, :idEnvio)", nativeQuery = true)
	Integer registrar(@Param("idConsulta") Integer idConsulta, @Param("idEnvio") Integer idEnvio);
	
	@Query("from ConsultaEnvio ce where ce.envio.idEnvio = :idEnvio")
	List<ConsultaEnvio> listarEnvioPorConsulta(@Param("idEnvio") Integer idEnvio);
	
}
