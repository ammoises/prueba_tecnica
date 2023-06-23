package com.bimbo.recompensas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Compras")
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCompra;
	private Integer id;
	private Integer idArticulo;
	private Integer cantidad;
	
	public Integer getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdArticulo() {
		return idArticulo;
	}
	public void setIdArticulo(Integer idArticulo) {
		this.idArticulo = idArticulo;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "Compra [idCompra=" + idCompra + ", id=" + id + ", idArticulo=" + idArticulo + ", cantidad=" + cantidad
				+ "]";
	}
	
	
	
}
