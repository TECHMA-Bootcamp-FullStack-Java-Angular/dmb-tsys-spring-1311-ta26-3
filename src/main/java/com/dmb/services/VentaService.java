package com.dmb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmb.entities.Venta;
import com.dmb.repository.VentaDAO;

@Service
public class VentaService implements IServiceVenta{
	
	@Autowired
	private VentaDAO dao;

	@Override
	public List<Venta> getAllVenta() {
		return dao.findAll();
	}

	@Override
	public Optional<Venta> getOneVenta(Long id) {
		return dao.findById(id);
	}

	@Override
	public Venta createVenta(Venta entity) {
		return dao.save(entity);
	}

	@Override
	public Venta updateVenta(Venta entity) {
		return dao.save(entity);
	}

	@Override
	public void deleteVenta(Long id) {
		dao.deleteById(id);
	}

}
