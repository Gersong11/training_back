package com.hexa.entrenamiento.dominio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexa.entrenamiento.dominio.Ligas;

public interface LigasRepository extends JpaRepository<Ligas, Integer> {
	
	Ligas findFirstByCodigo(String codigo);
}
