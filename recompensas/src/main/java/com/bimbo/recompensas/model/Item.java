package com.bimbo.recompensas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Items")
public class Item {

	@Id
	private Integer idItem;
	private String item;
	private Integer puntos;
	public Integer getIdItem() {
		return idItem;
	}
	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Integer getPuntos() {
		return puntos;
	}
	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}
	@Override
	public String toString() {
		return "Recompensa [idItem=" + idItem + ", item=" + item + ", puntos=" + puntos + "]";
	}
	
	
	
}
