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

import com.dmb.entities.Cajero;
import com.dmb.services.CajeroService;

@RestController
@RequestMapping("/api/v1")
public class CajeroController {
	
	@Autowired
    private CajeroService serv;
	
	@GetMapping("/cajeros")
	public ResponseEntity<List<Cajero>> getAllCajero() {
		return ResponseEntity.ok(serv.getAllCajero());
	}
	
	@GetMapping("/cajero/{codigo}")
	public ResponseEntity<Cajero> getOneCajero(@PathVariable(name = "codigo") Long codigo) {
		Optional<Cajero> entity = serv.getOneCajero(codigo);
		if (entity.isPresent()) {
			return ResponseEntity.ok(entity.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/cajero")
	public ResponseEntity<Cajero> saveCajero(@RequestBody Cajero entity) {
		return ResponseEntity.ok(serv.createCajero(entity));
	}

	@PutMapping("/cajero/{codigo}")
	public ResponseEntity<Cajero> updateCajero(@PathVariable(name = "codigo") Long codigo, @RequestBody Cajero entity) {
		Optional<Cajero> entityOld = serv.getOneCajero(codigo);

		if (entityOld.isPresent()) {
			return ResponseEntity.ok(serv.updateCajero(entity));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	  
	@DeleteMapping("/cajero/{codigo}")
	public ResponseEntity<Void> deleteCajero(@PathVariable(name = "codigo") Long codigo ) { 
		Optional<Cajero> entity = serv.getOneCajero(codigo);
		if (entity.isPresent()) {
			serv.deleteCajero(codigo);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
