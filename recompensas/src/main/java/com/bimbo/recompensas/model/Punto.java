package com.bimbo.recompensas.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Puntos")
public class Punto {

	@Id
	private Integer id;
	private Integer puntos;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPuntos() {
		return puntos;
	}
	
	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}
	
	public void addPuntos(Integer puntos) {
		this.puntos = this.puntos + puntos;
	}
	
	public Boolean restPuntos(Integer puntos) {
		if((this.puntos - puntos)<0) {
			return false;
		}
		
		this.puntos = this.puntos - puntos;
		
		return true;
	}
	
	@Override
	public String toString() {
		return "Punto [id=" + id + ", puntos=" + puntos + "]";
	}
	

}
