package com.dmb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmb.entities.Maquina_Registradora;

@Repository
public interface MaquinaRegDAO  extends JpaRepository<Maquina_Registradora,Long>{

}
