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

import com.dmb.entities.Venta;
import com.dmb.services.VentaService;

@RestController
@RequestMapping("/api/v1")
public class VentaController {
	
	@Autowired
    private VentaService serv;
	
	@GetMapping("/ventas")
	public ResponseEntity<List<Venta>> getAllVenta() {
		return ResponseEntity.ok(serv.getAllVenta());
	}
	
	@GetMapping("/venta/{codigo}")
	public ResponseEntity<Venta> getOneVenta(@PathVariable(name = "codigo") Long codigo) {
		Optional<Venta> entity = serv.getOneVenta(codigo);

		if (entity.isPresent()) {
			return ResponseEntity.ok(entity.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	 @PostMapping("/venta")
	 public ResponseEntity<Venta> saveVenta(@RequestBody Venta entity) {
		return ResponseEntity.ok(serv.createVenta(entity));
	}
	 
	 @PutMapping("/venta/{codigo}")
	 public ResponseEntity<Venta> updateVenta(@PathVariable(name = "codigo") Long codigo, @RequestBody Venta entity) {
		Optional<Venta> entityOld = serv.getOneVenta(codigo);

		if (entityOld.isPresent()) {
			return ResponseEntity.ok(serv.updateVenta(entity));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	 
	 @DeleteMapping("/venta/{codigo}")
	 public ResponseEntity<Void> deleteVenta(@PathVariable(name = "codigo") Long codigo) { 
		Optional<Venta> entity = serv.getOneVenta(codigo);
		if (entity.isPresent()) {
			serv.deleteVenta(codigo);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
