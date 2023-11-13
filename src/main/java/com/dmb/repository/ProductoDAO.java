package com.dmb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmb.entities.Producto;

@Repository
public interface ProductoDAO  extends JpaRepository<Producto, Long>{

}
