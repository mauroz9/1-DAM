package ejemplo02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*List <String> listaNombres = new ArrayList <String> ();
		
		listaNombres.add("Luis");
		listaNombres.add("Miguel");
		listaNombres.add("Luis");
		
		System.out.println(listaNombres);*/
		
		int opcion;
		String dni, nombre;
		double notaMedia;
		
		Scanner sc = new Scanner(System.in);
		Alumno a1 = new Alumno("27529357L", "Miguel Angel", 8.9);
		Alumno a2 = new Alumno("78346568M", "Angel Martín", 3.6);
		Alumno a3 = new Alumno("08459723J", "Juan José", 9.2);
		Alumno a4;
		Secretaria s;
		
		List <Alumno> listaAlumnos = new ArrayList <Alumno> ();
		listaAlumnos.add(a1);
		listaAlumnos.add(a2);
		listaAlumnos.add(a3);
		
		s = new Secretaria(listaAlumnos);
		
		System.out.println("Bienvenido al programa de gestión de alumnos");
		do {
			System.out.println("\n\n¿Qué desea hacer?");
			System.out.println("0. Salir");
			System.out.println("1. Agragar un alumno");
			System.out.println("2. Imprimir lista de alumnos");
			System.out.println("3. Busca un alumno");
			System.out.println("4. Cambiar una nota");
			System.out.println("5. Borrar un alumno");
			System.out.println("6. Obtener nota media de entre todos los alumnos");
			
			opcion=sc.nextInt();
			
			switch(opcion) {
				case 0:
					System.out.println("Saliendo...");
					break;
					
				case 1:
					System.out.println("Introduzca el DNI del alumno");
					dni=sc.next();
					System.out.println("Introduzca el nombre del alumno");
					nombre=sc.next();
					System.out.println("Introudca la nota media del alumno");
					notaMedia=sc.nextDouble();
					a4 = new Alumno(dni, nombre, notaMedia);
					s.agregarAlumno(a4);
					break;
					
					
				case 2:
					s.imprimirLista();
					break;
					
				case 3:
					System.out.println("Introduzca el DNI del alumo");
					dni=sc.next();
					System.out.println(s.buscarAlumno(dni));
					break;
					
				case 4:
					System.out.println("Introduzca el DNI del alumno al que desee modificar su nota");
					dni=sc.next();
					System.out.println("Introduzca la nueva nota media");
					notaMedia=sc.nextDouble();
					s.cambiarNotaMedia(s.buscarAlumno(dni), notaMedia);
					break;
					
				case 5:
					System.out.println("Introduzca el DNI dle alumno que desee eliminar");
					dni=sc.next();
					s.borrarAlumno(s.buscarAlumno(dni));
					break;
					
				case 6:
					System.out.println("La media de las notas es: "+s.calcularMediaAlumnos());
					break;
					
				default:
					System.out.println("Opción inválida");
					break;
			}
		}while(opcion!=0);
		
		sc.close();
	}

}
