package ejercicio04;

import java.util.Arrays;

public class Venta {
	private LineaDeVenta [] lista;

	public Venta(LineaDeVenta[] lista) {
		super();
		this.lista = lista;
	}

	public LineaDeVenta[] getLista() {
		return lista;
	}

	public void setLista(LineaDeVenta[] lista) {
		this.lista = lista;
	}

	@Override
	public String toString() {
		return "Venta [lista=" + Arrays.toString(lista) + "]";
	}
	
	public void agregarLineaVenta(LineaDeVenta lv, int contador) {
		lista[contador]=lv;
	}
	
	public double subtotalVenta(double iva, double descuento, int topeCaducidad) {
		double suma=0;
		for(int i=0; i<lista.length && lista[i]!=null; i++) {
			suma=suma+lista[i].calcularImporte(iva, descuento, topeCaducidad);
		}
		return suma;
	}
	
	
	public void listarProductos(int topeCaducidad) {
		for(int i=0; i<lista.length && lista[i]!=null; i++) {
			System.out.println(lista[i]);
			if(lista[i].getP() instanceof Alimentacion) {
				((Alimentacion)lista[i].getP()).avisarCaducidad(topeCaducidad);
			}
		}
	}
	
	public void imprimirTicket(double iva, double descuento, int topeCaducidad) {
		System.out.println("\n--------------------TICKET DE COMPRA--------------------");
		System.out.println("\nArticulo\t\tUd\tPVP\tIVA\tImporte\n");
		
		for(int i=0; i<lista.length; i++) {
			System.out.printf("\n%s\t\t%d\t%.2f€\t%.2f\t%.2f€",lista[i].getP().getNombre(), lista[i].getCantidad(), lista[i].getP().calcularPVP(iva, descuento, topeCaducidad), iva, lista[i].calcularImporte(iva, descuento, topeCaducidad));
		}
		System.out.println("\n\n--------------------------------------------------------");
		System.out.printf("\nSUBTOTAL\t\t\t\t\t%.2f€", subtotalVenta(iva, descuento, topeCaducidad));
		System.out.println("\n\n\t\t GRACIAS POR LA COMPRA");
		System.out.println("\n\n--------------------------------------------------------");
	}
	
	
}
