package com.dmb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmb.entities.Cajero;

@Repository
public interface CajeroDAO extends JpaRepository<Cajero, Long>{

}
