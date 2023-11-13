package com.dmb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmb.entities.Cajero;
import com.dmb.repository.CajeroDAO;

@Service
public class CajeroService implements IServiceCajero {
	
	@Autowired
	private CajeroDAO dao;

	@Override
	public List<Cajero> getAllCajero() {
		return dao.findAll();
	}

	@Override
	public Optional<Cajero> getOneCajero(Long id) {
		return dao.findById(id);
	}

	@Override
	public Cajero createCajero(Cajero entity) {
		return dao.save(entity);
	}

	@Override
	public Cajero updateCajero(Cajero entity) {
		return dao.save(entity);
	}

	@Override
	public void deleteCajero(Long id) {
		dao.deleteById(id);
	}

}
