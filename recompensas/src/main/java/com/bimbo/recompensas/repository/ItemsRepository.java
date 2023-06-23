package com.bimbo.recompensas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bimbo.recompensas.model.Item;


public interface ItemsRepository extends JpaRepository<Item, Integer> {

	Item findByItem(String nombre);
}
