package ejercicio01;

import java.util.Arrays;

public class GestionHabitaciones {
	private HabitacionEstandar [] lista;

	public GestionHabitaciones(HabitacionEstandar[] lista) {
		super();
		this.lista = lista;
	}

	public HabitacionEstandar[] getLista() {
		return lista;
	}

	public void setLista(HabitacionEstandar[] lista) {
		this.lista = lista;
	}

	@Override
	public String toString() {
		return "GestionHabitaciones [lista=" + Arrays.toString(lista) + "]";
	}
	
	public HabitacionEstandar buscarHabitacion(int id) {
		return lista[id-1];
	}
	
	public double calcularPrecio(HabitacionEstandar a) {
		return a.calcularEstancia();
	}
	
	public double calcularRecaudado() {
		double suma=0;
		
		for(int i=0; i<lista.length && lista[i]!=null; i++) {
			if(lista[i].isOcupada()) {
				suma=suma+calcularPrecio(lista[i]);
			}
		}
		
		return suma;
	}
	
	public void factura(HabitacionEstandar a) {
		if(a instanceof HabitacionEstandar) {
			System.out.println("------------------HOTEL MARBELLA------------------");
			System.out.println("\nTipo de Habitación: Habitación Estandar");
		}else if(a instanceof Suite) {
			System.out.println("------------------HOTEL MARBELLA------------------");
			System.out.println("Tipo de Habitación: Suite");
		}else if(a instanceof Apartamento) {
			System.out.println("------------------HOTEL MARBELLA------------------");
			System.out.println("Tipo de Habitación: Apartamento");
		}
		
		System.out.println("Cliente: "+a.getCliente());
		System.out.println("Ocupantes: "+a.getOcupantes());
		System.out.println("Diás contratados: "+a.getDias());
		System.out.println("\n-------------------------------------------------");
		System.out.printf("\nPrecio Base: \t\t\t%.2f€\n", a.getPrecioBase());
		
		if(a instanceof Suite) {
			System.out.printf("Servicio de Habitaciones: \t\t\t%.2f€\n", ((Suite)a).getServicioHab());
			System.out.printf("Descuento VIP: \t\t\t%.2f€\n", ((Suite)a).calcularDescuento());
		}else if(a instanceof Apartamento) {
			System.out.printf("Servicio de Limpieza: %.2f€\n", ((Apartamento)a).getServicioLimp());
		}
		
		System.out.printf("SUBTOTAL: \t\t\t%.2f€\n", calcularPrecio(a));
		System.out.println("\n-------------------------------------------------");
		System.out.println("\n\t\tGRACIAS POR LA ESTANCIA\t\t\n");
		System.out.println("\n-------------------------------------------------");
		
	}
	
	public void listarNoOcupadas() {
		for(int i=0; i<lista.length && lista[i]!=null; i++) {
			if(!lista[i].isOcupada()) {
				System.out.println(lista[i]);
			}
		}
	}
}
