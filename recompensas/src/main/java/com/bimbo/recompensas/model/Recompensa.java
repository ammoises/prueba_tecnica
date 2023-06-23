package com.bimbo.recompensas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Recompensas")
public class Recompensa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRecompesa;
	private Integer id;
	private Integer idItem;
	public Integer getIdRecompesa() {
		return idRecompesa;
	}
	public void setIdRecompesa(Integer idRecompesa) {
		this.idRecompesa = idRecompesa;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdItem() {
		return idItem;
	}
	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}
	@Override
	public String toString() {
		return "Recompensa [idRecompesa=" + idRecompesa + ", id=" + id + ", idItem=" + idItem + "]";
	}
	
	
	
	
}
