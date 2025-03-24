package ejercicio03;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Set <Alumno> listaAlumno = new HashSet <Alumno>();
		
		int numStudent = 3, option, option2, id;
		String name, surname;
		double grade;
		
		Alumno a;
		Alumno a1 = new Alumno(1, "Mauro", "Serrano", 9.7);
		Alumno a2 = new Alumno(2, "Miguel", "Ruiz", 5.2);
		Alumno a3 = new Alumno(3, "Sergio", "Martinez", 4.7);
		
		CRUDalumno ca = new CRUDalumno(listaAlumno);
		
		ca.addStudent(a1);
		ca.addStudent(a2);
		ca.addStudent(a3);
		
		System.out.println("Bienvenido al sistema gestor del instituto");
		
		do {	
			System.out.println("\n\n¿Qué desea hacer?");
			System.out.println("0. Salir");
			System.out.println("1. Añadir un alumno al sistema");
			System.out.println("2. Eliminar a un alumno del sistema");
			System.out.println("3. Buscar a un alumno");
			System.out.println("4. Modificar algun campo de un alumno");
			System.out.println("5. Listar a los alumnos");
			option = sc.nextInt();
			
			switch(option) {
				case 0:
					System.out.println("Saliendo...");
					break;
					
				case 1:
					name = sc.nextLine();
					System.out.println("Introduzca el nombre del alumno");
					surname = sc.nextLine();
					System.out.println("Introduzca el apellido del alumno");
					grade = sc.nextDouble();
					System.out.println("Introduzca la nota media del alumno");
					numStudent++;
					a = new Alumno(numStudent, name, surname, grade);
					ca.addStudent(a);
					break;
					
				case 2:
					System.out.println("Introduzca el id del alumno que desee eliminar");
					id = sc.nextInt();
					
					if(ca.deleteStudent(ca.findById(id))) {
						System.out.println("Alumno eliminado exitosamente");
					}else {
						System.out.println("No se ha podido eliminar al alumno");
					}
					break;
					
				case 3:
					id = sc.nextInt();
					System.out.println("Introduzca el id del alumno que desee buscar");
					
					if(ca.findById(id) != null) {
						System.out.println(ca.findById(id));
					}else {
						System.out.println("No se ha encotrado al alumno");
					}
					break;
					
				case 4:
					id = sc.nextInt();
					System.out.println("Introduzca el id del alumno que desee modificar");
					
					if(ca.findById(id) != null) {
						
						do {
							System.out.println("\n¿Qué desea modificar?");
							System.out.println("0. Salir");
							System.out.println("1. Nombre");
							System.out.println("2. Apellido");
							System.out.println("3. Nota media");
							option2 = sc.nextInt();
							
							switch(option2) {
								case 0:
									System.out.println("Saliendo del menú modificar...");
									break;
									
								case 1:
									 name = sc.nextLine();
									 System.out.println("Introduzca el nuevo nombre");
									 
									 if(ca.modifyName(ca.findById(id), name)) {
										 System.out.println("Cambio realizado con éxito");
									 }else {
										 System.out.println("No se ha podido realizar el cambio");
									 }
									 break;
									 
								case 2:
									 surname = sc.nextLine();
									 System.out.println("Introduzca el nuevo apellido");
									 
									 if(ca.modifySurname(ca.findById(id), surname)) {
										 System.out.println("Cambio realizado con éxito");
									 }else {
										 System.out.println("No se ha podido realizar el cambio");
									 }
									 break;
									 
								case 3:
									 grade = sc.nextDouble();
									 System.out.println("Introduzca la nueva nota media");
									 
									 if(ca.modifyGrade(ca.findById(id), grade)) {
										 System.out.println("Cambio realizado con éxito");
									 }else {
										 System.out.println("No se ha podido realizar el cambio");
									 }
									 break;
									 
								default:
									System.out.println("Opción inválida");
									break;
							}
						}while(option2 != 0);
						
					}else {
						System.out.println("No se ha encotrado al alumno");
					}
					break;
					
				case 5:
					ca.showList();
					break;
					
				default:
					System.out.println("Opción inválida");
					break;		
			}
		}while(option != 0);
	}
}
