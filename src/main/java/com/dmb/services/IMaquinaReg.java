package com.dmb.services;

import java.util.List;
import java.util.Optional;

import com.dmb.entities.Maquina_Registradora;

public interface IMaquinaReg  {
	//CRUD 

	//Read All
	public List<Maquina_Registradora> getAllMaquina_Registradora();

	//Read One
	public Optional<Maquina_Registradora> getOneMaquina_Registradora(Long id); 
	//Create

	public Maquina_Registradora createMaquina_Registradora(Maquina_Registradora entity);

	//Update
	public Maquina_Registradora updateMaquina_Registradora(Maquina_Registradora entity);

	//Delete
	public void deleteMaquina_Registradora(Long id); 
}