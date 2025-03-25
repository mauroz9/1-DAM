package ejercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List <Trastero> listaTrasteros = new ArrayList <Trastero>();
		
		Trastero t;
		Trastero t1 = new Trastero(23.5, "Calle España", 4, 120.99, true);
		Trastero t2 = new Trastero(78.9, "Calle Málaga", 9, 324.56, false);
		Trastero t3 = new Trastero(80.5, "Calle Piscina", 2, 324.56, true);
		Trastero t4 = new Trastero(57.2, "Calle Harana", 5, 256.44, false);
		
		listaTrasteros.add(t1);
		listaTrasteros.add(t2);
		listaTrasteros.add(t3);
		listaTrasteros.add(t4);
		
		Oficina o = new Oficina(listaTrasteros);
		
		int opcion, numTra;
		double espacio, precio;
		String calle;
		boolean libre;
		
		System.out.println("Bienvenido al sistema gestor de la venta de trasteros");
		
		do {
			System.out.println("\n¿Qué desea hacer?");
			System.out.println("0. Salir");
			System.out.println("1. Añadir un trastero");
			System.out.println("2. Filtrar trasteros por precio");
			System.out.println("3. Filtrar trasteros por número");
			System.out.println("4. Listar los trasteros más caros");
			System.out.println("5. Eliminar un trastero");
			System.out.println("6. Modificar un trastero");
			System.out.println("7. Ordenar la lista por número");
			System.out.println("8. Ordenar la lista por precio");
			System.out.println("9. Ver trasteros libres");
			
			opcion = sc.nextInt();
			
			switch(opcion) {
				case 0:
					System.out.println("Saliendo...");
					break;
					
				case 1:
					System.out.println("Introduzca los metros cuadrados");
					espacio = sc.nextDouble();
					System.out.println("Introduzcla la dirección");
					calle = sc.nextLine();
					System.out.println("Introduzca el número de trastero");
					numTra = sc.nextInt();
					System.out.println("Introduzca el precio");
					precio = sc.nextDouble();
					
					
					t = new Trastero (espacio, calle, numTra, precio, true);
					o.anadirTrastero(t);
					
					System.out.println("Trastero añadido");
					break;
					
				case 2:
					System.out.println("Indique un precio");
					precio = sc.nextDouble();
					System.out.println("Se han encontrado los siguientes resultados:");
					System.out.println(o.buscarTrasteroPrecio(precio));
					break;
					
				case 3:
					System.out.println("Indique el número de trastero");
					numTra = sc.nextInt();
					if(o.buscarTrasteroNumero(numTra) != null) {
						System.out.println(o.buscarTrasteroNumero(numTra));
					}else {
						System.out.println("Trastero no encontrado");
					}
					break;
					
				case 4:
					System.out.println("Los trasteros más caros son:");
					System.out.println(o.buscarTrasteroPrecio(o.buscarPrecioMayor()));
					break;
					
				case 5:
					System.out.println("Indique el número del trastero que desee eliminar");
					numTra = sc.nextInt();
					if(o.eliminarTrastero(o.buscarTrasteroNumero(numTra))) {
						System.out.println("Trastero eliminado");
					}else {
						System.out.println("No se ha podido eliminar el trastero");
					}
					break;
					
				case 6:
					System.out.println("Indique el número del trastero que desee modificar");
					numTra = sc.nextInt();
					System.out.println("Indique el nuevo precio del trastero");
					precio = sc.nextDouble();
					if(o.modificarPrecio(o.buscarTrasteroNumero(numTra), precio)) {
						System.out.println("Trastero modificado");
					}else {
						System.out.println("No se ha podido modificar el trastero");
					}
					break;
					
				case 7:
					System.out.println("Lista ordenada por número:");
					System.out.println(o.ordenarNumero());
					break;
					
				case 8:
					System.out.println("Lista ordenada por precio:");
					System.out.println(o.ordenarPrecio());
					break;
					
				case 9:
					System.out.println("Lista de trasteros libres:");
					System.out.println(o.listaLibres());
					break;
					
			}
			
		}while(opcion != 0);
		
		
	}

}
