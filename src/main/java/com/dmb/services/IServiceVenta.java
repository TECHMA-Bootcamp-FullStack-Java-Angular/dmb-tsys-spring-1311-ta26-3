package com.dmb.services;

import java.util.List;
import java.util.Optional;

import com.dmb.entities.Venta;

public interface IServiceVenta {
	
	//CRUD 

	//Read All
	public List<Venta> getAllVenta();

	//Read One
	public Optional<Venta> getOneVenta(Long id); 
	//Create

	public Venta createVenta(Venta entity);

	//Update
	public Venta updateVenta(Venta entity);

	//Delete
	public void deleteVenta(Long id); 

}
