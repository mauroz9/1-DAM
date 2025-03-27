package ejercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List <Habitacion> listaHabitaciones = new ArrayList <Habitacion> ();
		
		Habitacion h1 = new Habitacion(1, "Sergio Sánchez", true, 45.6);
		Habitacion h2 = new Habitacion(2, "Ángel Naranjo", true, 118.9);
		Habitacion h3 = new Habitacion(3, "Pepe Hernandez", true, 23.7);
		Habitacion h4 = new Habitacion(4, "Mauro Serrano", false, 599.9);
		Habitacion h5 = new Habitacion(5, "Santiago Jiménez", false, 66.6);
		
		listaHabitaciones.add(h1);
		listaHabitaciones.add(h2);
		listaHabitaciones.add(h3);
		listaHabitaciones.add(h4);
		listaHabitaciones.add(h5);
		
		Hotel ht = new Hotel(listaHabitaciones);
		
		int opcion, habitaciones=5, disponible, numHab, habLibres;
		double precio;
		String cliente;
		boolean ocupada = false;
		
		System.out.println("Bienvenido al sistema gestor del hotel");
		System.out.println("¿Con cuántas habitaciones libres restantes quieres recibir un aviso?");
		habLibres = Integer.parseInt(sc.nextLine());
		
		do {
			
			System.out.println("\n\n¿Qué desea hacer?");
			System.out.println("0. Salir");
			System.out.println("1. Agregar una habitación");
			System.out.println("2. Borrar una habitación");
			System.out.println("3. Modificar el estado de una habitación");
			System.out.println("4. Ver la lista de habitaciones");
			System.out.println("5. Ver las habitaciones ocupadas");
			System.out.println("6. Buscar una habitación por el número de habitación");
			System.out.println("7. Obtener las ganancias actuales");
			System.out.println("8. Ordenar la lista por orden alfabético");
			System.out.println("9. Ordenar la lista por precio");
			
			opcion = Integer.parseInt(sc.nextLine());
			
			switch(opcion) {
				case 0:
					System.out.println("Saliendo...");
					break;
					
				case 1:
					habitaciones++;
					System.out.println("Introduzca el nombre del cliente");
					cliente = sc.nextLine();
					
					do {
						System.out.println("Esta disponible (y=0 n=1)");
						disponible = Integer.parseInt(sc.nextLine());
					}while(disponible != 0 && disponible != 1);
					
					if(disponible == 0) {
						ocupada = false;
					}else if(disponible == 1) {
						ocupada = true;
					}
					
					System.out.println("Introduzca el precio de la habitación");
					precio = Double.parseDouble(sc.nextLine());
					
					ht.agregarHabitacion(new Habitacion(habitaciones, cliente, ocupada, precio));
					System.out.println("Lista actualizada:");
					ht.imprimirLista();
					break;
					
				case 2:
					System.out.println("Introduzca el número de habitación");
					numHab = Integer.parseInt(sc.nextLine());
					
					if(ht.borrarHabitacion(ht.buscarHabitacion(numHab))) {
						System.out.println("¡Habitación eliminada!");
						System.out.println("\nLista actualizada:");
						ht.imprimirLista();
						
					}else {
						System.out.println("No se ha podido eliminar la lista (Posiblemente porque el número de habitación sea erroneo)");
					}
					break;
					
				case 3:
					System.out.println("Introduzca el número de la habitación la cual desee modificar su estado");
					numHab = Integer.parseInt(sc.nextLine());
					
					if(ht.modificarEstadoHab(ht.buscarHabitacion(numHab))) {
						System.out.println("¡Habitación actualizada!");
						System.out.println("\nNuevo estado:");
						System.out.println(ht.buscarHabitacion(numHab));
						
					}else {
						System.out.println("No se ha podido modificar el estado de la habitación (Posiblemente porque el número de habitación sea erroneo)");
					}
					break;
					
				case 4:
					System.out.println("Lista de habitaciones:");
					ht.imprimirLista();
					ht.mensajeAlerta(habLibres);
					break;
					
				case 5:
					System.out.println("Lista de habitaciones ocupadas:");
					ht.imprimirListaBonito(ht.habitacionesOcupadas());
					break;
					
				case 6:
					System.out.println("Introduzca el número de habitación");
					numHab = Integer.parseInt(sc.nextLine());
					if(ht.buscarHabitacion(numHab) != null) {
						System.out.println(ht.buscarHabitacion(numHab));
					}else {
						System.out.println("Habitación no encontrada (Posiblemente porque el número de habitación sea erroneo)");
					}
					break;
					
				case 7:
					System.out.printf("Ganancias actuales: %.2f€", ht.calcularGanancias());
					break;
					
				case 8:
					System.out.println("\nLista ordenada por orden alfabético:");
					ht.imprimirListaBonito(ht.ordenarNombre());
					ht.mensajeAlerta(habLibres);
					break;
					
				case 9:
					System.out.println("\nLista ordenada por precio:");
					ht.imprimirListaBonito(ht.ordenarPrecio());
					ht.mensajeAlerta(habLibres);
					break;
					
				default:
					System.out.println("Escoja una opción válida");
			}
			
		}while(opcion != 0);

	}

}
