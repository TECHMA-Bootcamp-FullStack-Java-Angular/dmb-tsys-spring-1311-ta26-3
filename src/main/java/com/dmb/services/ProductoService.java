package com.dmb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmb.entities.Producto;
import com.dmb.repository.ProductoDAO;

@Service
public class ProductoService implements IServiceProducto {

	@Autowired
	private ProductoDAO dao;

	@Override
	public List<Producto> getAllProducto() {
		return dao.findAll();
	}

	@Override
	public Optional<Producto> getOneProducto(Long id) {
		return dao.findById(id);
	}

	@Override
	public Producto createProducto(Producto entity) {
		return dao.save(entity);
	}

	@Override
	public Producto updateProducto(Producto entity) {
		return dao.save(entity);
	}

	@Override
	public void deleteProducto(Long id) {
		dao.deleteById(id);
	}

}
