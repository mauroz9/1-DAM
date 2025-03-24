package ejercicio;

import java.util.Arrays;

public class Taquilla {
	private EntradaNormal [] lista;

	public Taquilla(EntradaNormal[] lista) {
		super();
		this.lista = lista;
	}

	public EntradaNormal[] getLista() {
		return lista;
	}

	public void setLista(EntradaNormal[] lista) {
		this.lista = lista;
	}

	@Override
	public String toString() {
		return "Taquilla [lista=" + Arrays.toString(lista) + "]";
	}

	public EntradaNormal buscarEntrada(int id) {
		return lista[id-1];
	}
	
	public double calcularPrecioTaquilla(EntradaNormal e, double precio1, double precio2, int limiteDescuento, double porcentaje, double suplemento) {
		return e.precioEntrada(precio1, precio2, limiteDescuento, porcentaje, suplemento);
	}
	
	public double calcularVentasGrupo(double precio1, double precio2, int limiteDescuento, double porcentaje, double suplemento) {
		double ventas=0;
		
		for(int i=0; i<lista.length && lista[i]!=null; i++) {
			if(lista[i] instanceof EntradaGrupos) {
				ventas+=calcularPrecioTaquilla(lista[i], precio1, precio2, limiteDescuento, porcentaje, suplemento);
			}
		}
		
		return ventas;
	}
	
	public double calcularVentasZona2(double precio1, double precio2, int limiteDescuento, double porcentaje, double suplemento) {
		double ventas=0;
		
		for(int i=0; i<lista.length && lista[i]!=null; i++) {
			if(lista[i].getZona()==2) {
				ventas+=calcularPrecioTaquilla(lista[i], precio1, precio2, limiteDescuento, porcentaje, suplemento);
			}
		}
		
		return ventas;
		
	}
	
	public void imprimirTicketBotella() {
		System.out.println("------------------TICKET ENTRADA FAMOSO------------------");
		System.out.println("\nTipo de entrada: ENTRADA FAMOSO ");
		System.out.println("Vale por una botella de champán GRATIS");
		System.out.println("\n---------------------------------------------------------");
	}
	
	public double calcularTotalIVA(double precio1, double precio2, int limiteDescuento, double porcentaje, double suplemento) {
		double ivaTotal=0;
		
		for(int i=0; i<lista.length && lista[i]!=null; i++) {
			ivaTotal+=lista[i].calcularIVA(porcentaje, precio1, precio2, limiteDescuento, suplemento);
		}
		
		return ivaTotal;
	}
	
	public void listarEntradas() {
		for(int i=0; i<lista.length && lista[i]!=null; i++) {
			System.out.println((i+1)+". "+lista[i]);
		}
	}
	
}
