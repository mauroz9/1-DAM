package ejercicio02;

import java.util.Arrays;

public class Hotel {
	
	private Habitacion lista[];

	public Hotel(Habitacion[] lista) {
		this.lista = lista;
	}

	public Habitacion[] getLista() {
		return lista;
	}

	public void setLista(Habitacion[] lista) {
		this.lista = lista;
	}

	@Override
	public String toString() {
		return "Hotel [lista=" + Arrays.toString(lista) + "]";
	}
	
	public void listarTodas() {
		for(int i=0;i<lista.length;i++) {
			if(lista[i]==null) {
			}else {
				System.out.println(lista[i]);
			}
		}
	}
	
	public boolean comprobarNumeroHab(int id, int numeroHabs) {
		boolean existe=false;
		
		for(int i=0; i<numeroHabs; i++) {
			if(lista[i].getId()==id) {
				existe=true;
			}
		}
		return existe;
	}
	
	public boolean comprobarDisponibilidad(int id, int numeroHabs) {
		boolean disponibilidad=false;
		for(int i=0; i<numeroHabs; i++) {
			if(lista[i].getId()==id) {
				disponibilidad=lista[i].isOcupada();
			}
		}
		return disponibilidad;
	}
	
	public void agregarHabitacion(Habitacion nuevaHabitacion,int posicion) {
		lista[posicion]=nuevaHabitacion;
	}
	
	public void hospedarCliente(int id, double servicioExtra, String nombreCliente, int dias, int numeroHabs) {
		boolean ocupada=true;
		for(int i=0; i<numeroHabs; i++) {
			if(lista[i].getId()==id) {
				lista[i].setServiciosExtra(servicioExtra);
				lista[i].setNombreCliente(nombreCliente);
				lista[i].setOcupada(ocupada);
				lista[i].setDiasContratados(dias);
			}
		}
	}
	
	public double precioFinal(int id, int numeroHabs) {
		double costoFinal=0;
		
		for(int i=0; i<numeroHabs; i++) {
			if(lista[i].getId()==id) {
				costoFinal=lista[i].getPrecio()*lista[i].getDiasContratados()+lista[i].getServiciosExtra();
			}
		}
		return costoFinal;
	}
	
	public void imprimirFactura(int id, int numeroHabs) {
		for(int i=0; i<numeroHabs; i++) {
			if(lista[i].getId()==id) {
				System.out.println("------------HOTEL ESTRELLA------------");
				System.out.printf("\nNúmero de habitación: %d",lista[i].getId());
				System.out.printf("\nNombre del cliente: %s",lista[i].getNombreCliente());
				System.out.printf("\nDías contratados: %d",lista[i].getDiasContratados());
				System.out.printf("\n\nPrecio de la habitación: \t%.2f€",lista[i].getPrecio());
				System.out.printf("\nCosto de servicios contratados: %.2f€",lista[i].getServiciosExtra());
				System.out.println("\n\n--------------------------------------");
				System.out.printf("\nSUBTOTAL: \t\t\t%.2f€",precioFinal(id,numeroHabs));
				System.out.println("\n\n\tGRACIAS POR SU VISITA");
				System.out.println("\n--------------------------------------");
			}
		}
	}
}
