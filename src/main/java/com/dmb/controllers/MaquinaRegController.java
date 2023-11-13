package com.dmb.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmb.entities.Maquina_Registradora;
import com.dmb.services.MaquinaRegService;

@RestController
@RequestMapping("/api/v1")
public class MaquinaRegController {
	
	@Autowired
	private MaquinaRegService serv;

	@GetMapping("/maquina-registradoras")
	public ResponseEntity<List<Maquina_Registradora>> getAllMaquina_Registradora() {
		return ResponseEntity.ok(serv.getAllMaquina_Registradora());
	}
	
	@GetMapping("/maquina-registradora/{codigo}")
	public ResponseEntity<Maquina_Registradora> getOneMaquina_Registradora(@PathVariable(name = "codigo") Long codigo) {
		Optional<Maquina_Registradora> entity = serv.getOneMaquina_Registradora(codigo);
		if (entity.isPresent()) {
			return ResponseEntity.ok(entity.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/maquina-registradora")
	public ResponseEntity<Maquina_Registradora> saveMaquina_Registradora(@RequestBody Maquina_Registradora entity) {
		return ResponseEntity.ok(serv.createMaquina_Registradora(entity));
	}

	@PutMapping("/maquina-registradora/{codigo}")
	public ResponseEntity<Maquina_Registradora> updateMaquina_Registradora(@PathVariable(name = "codigo") Long codigo, @RequestBody Maquina_Registradora entity) {
		Optional<Maquina_Registradora> entityOld = serv.getOneMaquina_Registradora(codigo);

		if (entityOld.isPresent()) {
			return ResponseEntity.ok(serv.updateMaquina_Registradora(entity));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	  
	@DeleteMapping("/maquina-registradora/{codigo}")
	public ResponseEntity<Void> deleteMaquina_Registradora(@PathVariable(name = "codigo") Long codigo ) { 
		Optional<Maquina_Registradora> entity = serv.getOneMaquina_Registradora(codigo);
		if (entity.isPresent()) {
			serv.deleteMaquina_Registradora(codigo);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
