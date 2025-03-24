package ejercicio01;

import java.util.Arrays;

public class Tienda {
	
	private Producto lista [];//No se instancia aquí

	public Tienda(Producto[] lista) {
		this.lista = lista;
	}

	public Producto[] getLista() {
		return lista;
	}

	public void setLista(Producto[] lista) {
		this.lista = lista;
	}

	@Override
	public String toString() {
		return "Tienda [lista=" + Arrays.toString(lista) + "]";
	}
	
	public void listarTodos() {
		for(int i=0;i<lista.length;i++) {
			if(lista[i]==null) {
				
			}else {
				System.out.println(lista[i]);
			}
		}
	}
	
	public Producto buscarProducto(int id, int numeroProductos) { 
        Producto productoObjetivo = null;
        for (int i = 0; i < numeroProductos; i++) {
                if(lista[i].getId() == id) {
                        productoObjetivo = lista[i];
                }
        }
        return productoObjetivo;
	}
	
	public boolean comprobarExistencia(Producto productoBuscado) {
		boolean existencia;
		
		if(productoBuscado==null) {
			existencia=false;
		}else {
			existencia=true;
		}
		return existencia;
	}
		
	public boolean comprobrarFragil(Producto productoBuscado) {
		return productoBuscado.isFragil();
	}
	
	public void imprimirFragil (Producto productoBuscado) {
		if (!comprobarExistencia(productoBuscado)) {
			System.out.println("Ese producto no existe");
		}else if(comprobrarFragil(productoBuscado)) {
			System.out.println("Es fragil");
		}else {
			System.out.println("No es fragil");
		}
	}
	
	public void agregarProducto(Producto nuevoProducto, int posicion) {
		lista[posicion]=nuevoProducto;
	}
	
	public double calcularInversion(int numeroProductos) {
		double inversion=0;
		for(int i=0;i<numeroProductos;i++) {
			inversion+=lista[i].getPrecioFab();
		}
		return inversion;
	}
	
	public double calcularPVP(double ganancia,Producto productoBuscado) {
		double precioVenta=0, cien=100.0;
		precioVenta=(productoBuscado.getPrecioFab()*ganancia/cien)+productoBuscado.getPrecioFab();
		return precioVenta;
	}
	
	
	

	
	
	
}
