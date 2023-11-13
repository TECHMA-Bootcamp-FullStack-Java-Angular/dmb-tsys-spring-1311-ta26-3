package com.dmb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmb.entities.Venta;

@Repository
public interface VentaDAO extends JpaRepository<Venta, Long>{

}
