package com.dianaCerda.service.impl;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dianaCerda.dto.EnvioResumenDTO;
import com.dianaCerda.dto.FiltroVentaDTO;
import com.dianaCerda.dto.VentaListaEnvioDTO;
import com.dianaCerda.model.Venta;
import com.dianaCerda.repo.IConsultaEnvioRepo;
import com.dianaCerda.repo.IVentaRepo;
import com.dianaCerda.service.IVentaService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class VentaServiceImpl implements IVentaService{
	
	@Autowired
	private IVentaRepo repo;
	
	@Autowired
	private IConsultaEnvioRepo ceRepo;
	
	@Override
	public Venta registrar(Venta obj) {
		obj.getDetalleVenta().forEach(det -> {
			det.setVenta(obj);
		});
		return repo.save(obj);
	}
	

	@Transactional
	@Override
	public Venta registrarTransaccional(VentaListaEnvioDTO dto) {
		dto.getVenta().getDetalleVenta().forEach(det -> {
			det.setVenta(dto.getVenta());
		});
		repo.save(dto.getVenta());
		
		dto.getLstEnvio().forEach(ex -> ceRepo.registrar(dto.getVenta().getIdVenta() , ex.getIdEnvio()));
		return dto.getVenta();
	}

	@Override
	public List<EnvioResumenDTO> listarResumen() {
		List<EnvioResumenDTO> ventas = new ArrayList<>();
		
		repo.listarResumen().forEach(x -> {
			EnvioResumenDTO er = new EnvioResumenDTO();
			er.setCantidad(Integer.parseInt(String.valueOf(x[0])));
			er.setFecha(String.valueOf(x[1]));
			ventas.add(er);
		});
		return ventas;
	}

	@Override
	public byte[] generarReporte() {
		byte[] data = null;
		
		try {
			File file = new ClassPathResource("/reports/ventas.jasper").getFile();
			JasperPrint print = JasperFillManager.fillReport(file.getPath(), null, new JRBeanCollectionDataSource(this.listarResumen()));
			data = JasperExportManager.exportReportToPdf(print);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;	
	}


	@Override
	public Venta modificar(Venta obj) {
		return repo.save(obj);
	}


	@Override
	public List<Venta> listar() {
		return repo.findAll();
	}


	@Override
	public Venta leerPorId(Integer id) {
		Optional<Venta> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Venta();
	}


	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

	@Override
	public List<Venta> buscar(FiltroVentaDTO filtro) {
		return repo.buscar(filtro.getRut(), filtro.getNombreCompleto());
	}

	@Override
	public List<Venta> buscarFecha(FiltroVentaDTO filtro) {
		LocalDateTime fechaSgte = filtro.getFechaVenta().plusDays(1);
		return repo.buscarFecha(filtro.getFechaVenta(), fechaSgte);
	}

}
