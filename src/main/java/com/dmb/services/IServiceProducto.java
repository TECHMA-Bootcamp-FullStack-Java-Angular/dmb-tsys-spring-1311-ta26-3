package com.dmb.services;

import java.util.List;
import java.util.Optional;

import com.dmb.entities.Producto;

public interface IServiceProducto {
	//CRUD 

	//Read All
	public List<Producto> getAllProducto();

	//Read One
	public Optional<Producto> getOneProducto(Long id); 
	//Create

	public Producto createProducto(Producto entity);

	//Update
	public Producto updateProducto(Producto entity);

	//Delete
	public void deleteProducto(Long id); 
}
