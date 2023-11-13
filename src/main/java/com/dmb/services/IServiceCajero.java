package com.dmb.services;

import java.util.List;
import java.util.Optional;

import com.dmb.entities.Cajero;

public interface IServiceCajero {
	
	//CRUD 

	//Read All
	public List<Cajero> getAllCajero();

	//Read One
	public Optional<Cajero> getOneCajero(Long id); 
	//Create

	public Cajero createCajero(Cajero entity);

	//Update
	public Cajero updateCajero(Cajero entity);

	//Delete
	public void deleteCajero(Long id); 

}
