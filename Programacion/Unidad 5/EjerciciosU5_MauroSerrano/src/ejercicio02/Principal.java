package ejercicio02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List <Socio> listaSocios = new ArrayList <Socio> ();
		Club c = new Club(listaSocios);
		
		int numSocios=3, opcion, numSocio;
		String nombre, apellido, telefono;
		Socio s;
		
		Socio s1 = new Socio("Mauro", "Serrano", "843563857", 2);
		Socio s2 = new Socio("Miguel", "Angel", "653463455", 3);
		Socio s3 = new Socio("Antonio", "García", "734875895", 1);
		
		c.guardarSocio(s1);
		c.guardarSocio(s2);
		c.guardarSocio(s3);
		
		System.out.println("Bienvenido al programa de gestión del club");
		do {
			System.out.println("\n\n¿Qué desea hacer?");
			System.out.println("0. Salir");
			System.out.println("1. Añadir un socio nuevo");
			System.out.println("2. Buscar un socio");
			System.out.println("3. Mostrar todos los socios");
			System.out.println("4. Modificar un socio");
			System.out.println("5. Eliminar un socio");
			System.out.println("6. Ordenar lista por número de socio");
			System.out.println("7. Ordenar por nombre");
			opcion = sc.nextInt();
			
			switch(opcion) {
				case 0:
					System.out.println("Saliendo...");
					break;
					
				case 1:
					System.out.println("Introduzca el nombre");
					nombre = sc.next();
					System.out.println("Introduzca el apellido");
					apellido = sc.next();
					System.out.println("Introduzca el número de teléfono");
					telefono = sc.next();
					
					s = new Socio(nombre, apellido, telefono, numSocios);
					c.guardarSocio(s);
					numSocios++;
					break;
					
				case 2:
					System.out.println("Introduzca el número de socio");
					numSocio = sc.nextInt();
					
					if(c.buscarSocio(numSocio) != null) {
						System.out.println(c.buscarSocio(numSocio));
					}else {
						System.out.println("Socio no encontrado");
					}
					break;
					
				case 3:
					System.out.println("Lista de socios:");
					c.mostrarSocios();
					break;
					
				case 4:
					System.out.println("Introduzca el número de socio");
					numSocio = sc.nextInt();
					
					if(c.buscarSocio(numSocio) != null) {
						s=c.buscarSocio(numSocio);
						
						System.out.println("Introduzca el nuevo nombre");
						nombre = sc.next();
						System.out.println("Introduzca el nuevo apellido");
						apellido = sc.next();
						System.out.println("Introduzca el nuevo número de teléfono");
						telefono = sc.next();
						
						c.modificarSocio(s, nombre, apellido, telefono);
					}else {
						System.out.println("Socio no encontrado");
					}
					break;
					
				case 5:
					System.out.println("Introduzca el número de socio");
					numSocio = sc.nextInt();
					
					if(c.borrarSocio(numSocio)) {
						System.out.println("Orden completada");
					}else {
						System.out.println("No se ha podido eliminar al socio");
					}
					break;
					
				case 6:
					System.out.println("Lista ordenada por número de socio:");
					Collections.sort(listaSocios);
					c.mostrarSocios();
					break;
					
				case 7:
					System.out.println("Lista ordenada por nombre");
					Collections.sort(listaSocios, new CompararPorNombre());
					c.mostrarSocios();
					break;
					
				default:
					System.out.println("Escoja una opción válida");
					break;
			}
			
		}while(opcion!=0);
		
		
		

	}

}
