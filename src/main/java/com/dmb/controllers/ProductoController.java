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

import com.dmb.entities.Producto;
import com.dmb.services.ProductoService;

@RestController
@RequestMapping("/api/v1")
public class ProductoController {
	
	@Autowired
	private ProductoService serv;
	
	@GetMapping("/productos")
	public ResponseEntity<List<Producto>> getAllProducto() {
		return ResponseEntity.ok(serv.getAllProducto());
	}
	
	@GetMapping("/producto/{codigo}")
	public ResponseEntity<Producto> getOneProducto(@PathVariable(name = "codigo") Long codigo) {
		Optional<Producto> entity = serv.getOneProducto(codigo);
		if (entity.isPresent()) {
			return ResponseEntity.ok(entity.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/producto")
	public ResponseEntity<Producto> saveProducto(@RequestBody Producto entity) {
		return ResponseEntity.ok(serv.createProducto(entity));
	}

	@PutMapping("/producto/{codigo}")
	public ResponseEntity<Producto> updateProducto(@PathVariable(name = "codigo") Long codigo, @RequestBody Producto entity) {
		Optional<Producto> entityOld = serv.getOneProducto(codigo);

		if (entityOld.isPresent()) {
			return ResponseEntity.ok(serv.updateProducto(entity));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	  
	@DeleteMapping("/producto/{codigo}")
	public ResponseEntity<Void> deleteProducto(@PathVariable(name = "codigo") Long codigo ) { 
		Optional<Producto> entity = serv.getOneProducto(codigo);
		if (entity.isPresent()) {
			serv.deleteProducto(codigo);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	

}
