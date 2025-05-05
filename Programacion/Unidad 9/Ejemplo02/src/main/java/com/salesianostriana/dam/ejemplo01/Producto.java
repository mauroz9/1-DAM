package com.salesianostriana.dam.ejemplo01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Producto {
	
	private String nombre;
	private String descripcion;
	private float precio;
	private float porcentajeSatisfaccion;
	
	public Producto(String nombre, String descripcion, float precio) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	
}
