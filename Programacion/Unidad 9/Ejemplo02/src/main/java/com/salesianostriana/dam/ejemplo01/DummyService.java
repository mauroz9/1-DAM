package com.salesianostriana.dam.ejemplo01;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DummyService {
	
	//NO SE HACE ASI, estamos simulando ir a la base de datos y obtener un producto
	
	public Producto getProducto() {
		return new Producto("Camiseta", "¡Wena de verdad!", 15.0f, 91.1f);
	}
	
	public List<Producto> getListaProducto(){
		List<Producto> ListaProductos = new ArrayList<Producto> ();
		
		ListaProductos.add(new Producto("Camiseta", "¡Wena de verdad!", 15.0f, 91.1f));
		ListaProductos.add(new Producto("Pantalon", "¡Wena de verdad!", 15.0f, 91.1f));
		ListaProductos.add(new Producto("Gorra", "¡Wena de verdad!", 15.0f, 91.1f));
		ListaProductos.add(new Producto("Sudadera", "¡Wena de verdad!", 15.0f, 91.1f));
		
		return ListaProductos;
	}
}
