package com.dmb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmb.entities.Maquina_Registradora;
import com.dmb.repository.MaquinaRegDAO;

@Service
public class MaquinaRegService  implements IMaquinaReg{

	@Autowired
	private MaquinaRegDAO dao;

	@Override
	public List<Maquina_Registradora> getAllMaquina_Registradora() {
		return dao.findAll();
	}

	@Override
	public Optional<Maquina_Registradora> getOneMaquina_Registradora(Long id) {
		return dao.findById(id);
	}

	@Override
	public Maquina_Registradora createMaquina_Registradora(Maquina_Registradora entity) {
		return dao.save(entity);
	}

	@Override
	public Maquina_Registradora updateMaquina_Registradora(Maquina_Registradora entity) {
		return dao.save(entity);
	}

	@Override
	public void deleteMaquina_Registradora(Long id) {
		dao.deleteById(id);
	}
}
