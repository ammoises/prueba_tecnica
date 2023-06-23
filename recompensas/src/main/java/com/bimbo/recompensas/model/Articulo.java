package com.bimbo.recompensas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Articulos")
public class Articulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment MySQL
	private Integer idArticulo;
	private String nombre;
	private Float precio;
	private Integer puntos;
	public Integer getIdArticulo() {
		return idArticulo;
	}
	public void setIdArticulo(Integer idArticulo) {
		this.idArticulo = idArticulo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public Integer getPuntos() {
		return puntos;
	}
	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}
	
	@Override
	public String toString() {
		return "Articulo [idArticulo=" + idArticulo + ", nombre=" + nombre + ", precio=" + precio + ", puntos=" + puntos
				+ "]";
	}	
	
	
	
}

