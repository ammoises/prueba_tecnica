package com.bimbo.recompensas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bimbo.recompensas.model.Recompensa;

public interface RecompensasRepository extends JpaRepository<Recompensa, Integer> {

}
