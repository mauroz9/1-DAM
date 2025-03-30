package ejercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Tengo una empresa de desarrollo de software, pero el sistema de gestión de
		 * empleados es una pesadilla de errores. Cada ve que se quiere hacer alguna 
		 * tarea con un empleado que no existía... ¡Boom! NullPointerException. Si 
		 * intentaba acceder al departamento de un empleado que aún no se le habia 
		 * asignado... ¡Boom! Departamento: null.
		 * 
		 * Debes desarrollar una aplicación que te permita:
		 * 
		 * - Agregar, eliminar y modificar un empleado (sueldo).
		 * - Buscar a los empleados por departamento.
		 * - Buscar a los empleados por ID.
		 * - Listar a todos los empleados.
		 * - Listar a los empleados con el mejor salario.
		 * - Ordenar empleados por ID (Orden natural).
		 * - Ordenar empleados por antiguedad (Orden no natural).
		 */
		
		Scanner sc = new Scanner (System.in);
		List <Empleado> listaEmpleados = new ArrayList <Empleado>();
		
		Empleado e1 = new Empleado(101, "Ana López", "Ventas", 2500.0, 3);
		Empleado e2 = new Empleado(102, "Carlos Ruiz", "TI", 3200.0, 5);
		Empleado e3 = new Empleado(103, "Marta Díaz", null, 1800.0, 1);
		Empleado e4 = new Empleado(104, "Juan Pérez", "TI", 3200.0, 2);
		
		listaEmpleados.add(e1);
		listaEmpleados.add(e2);
		listaEmpleados.add(e3);
		listaEmpleados.add(e4);
		
		GestorEmpleados ge = new GestorEmpleados(listaEmpleados);
		
		int opcion, id, antiguedad;
		double salario;
		String nombre, departamento;
		
		System.out.println("Bienvenido al sistema gestor de empleados de la empresa");
		
		do {
			System.out.println("\n¿Qué desea hacer?");
			System.out.println("0. Salir");
			System.out.println("1. Agregar un empleado");
			System.out.println("2. Eliminar un empleado");
			System.out.println("3. Modificar un empleado");
			System.out.println("4. Buscar un empleado por su ID");
			System.out.println("5. Filtrar por departamento");
			System.out.println("6. LIstar a todos los empleados");
			System.out.println("7. Mostrar a los empleados mejor pagados");
			System.out.println("8. Ordenar por ID");
			System.out.println("9. Ordenar por Antigüedad");
			opcion = Integer.parseInt(sc.nextLine());
			
			switch(opcion) {
				case 0:
					System.out.println("Saliendo...");
					break;

				case 1:
					System.out.print("Introduzca el ID");
					id = Integer.parseInt(sc.nextLine());
					System.out.print("Introduzca el nombre completo");
					nombre = sc.nextLine();
					System.out.print("Departamento (opcional) ");
					departamento = sc.nextLine();
					//Comprueba que el departamento introducido no sea un campo en blanco,
					//y en ese caso guarda un null para manejarlo mejor con la clase Optional.
					if (departamento.isEmpty())
						departamento = null;
					System.out.print("Salario: ");
					salario = Double.parseDouble(sc.nextLine());
					System.out.print("Antigüedad: ");
					antiguedad = Integer.parseInt(sc.nextLine());
					
					//Instaciamos un optional para comprobar si se ha añadido el empleado o ha ocurrido
					// un error porque ya existe uno con ese ID asignado.
					Optional<Empleado> nuevoEmp = ge.agregarEmpleado(new Empleado(id, nombre, departamento, salario, antiguedad));
					
					if(nuevoEmp.isPresent()) {
			            System.out.println("Empleado agregado: " + nuevoEmp.get());
			        } else {
			            System.out.println("Error: Ya existe un empleado con ese ID");
			        }
					break;

				case 2:
					// Eliminar empleado
					System.out.print("ID del empleado a eliminar: ");
					id = Integer.parseInt(sc.nextLine());
					Optional<Empleado> eliminado = ge.eliminarEmpleado(id);

					if(eliminado.isPresent()) {
			            System.out.println("Empleado eliminado: " + eliminado.get());
			        } else {
			            System.out.println("No se encontró empleado con ID " + id);
			        }
					break;
					
				case 3:
					System.out.print("Introduzca el ID del empleado a modificar ");
                    id = Integer.parseInt(sc.nextLine());
                    System.out.print("Introduzca el nuevo salario:");
                    salario = Double.parseDouble(sc.nextLine());
                    Optional<Empleado> modificado = ge.modificarSueldo(id, salario);
                    
                    // Igual que anteriormente, instaciamos un optional para comprobar si se han realizado 
                    //los cambios en el empleado o ocurrido un error porque no existe uno con ese ID asignado.
                    if(modificado.isPresent()) {
                        System.out.println("Salario actualizado: " + modificado.get());
                    } else {
                        System.out.println("No se encontró empleado con ID " + id);
                    }
                    break;
                    
                    
				case 4:
					System.out.print("Introudzca el ID del empleado");
                    id = Integer.parseInt(sc.nextLine());
                    Optional<Empleado> encontrado = ge.buscarId(id);
                    
                    // Instaciamos un optional para comprobar si se ha encontrado al empleado o ha
					// ocurrido un error porque no existe uno con ese ID asignado.
                    if(encontrado.isPresent()) {
                        System.out.println("Empleado encontrado:\n" + encontrado.get());
                    } else {
                        System.out.println("No se encontró empleado con ID " + id);
                    }
                    break;
                    
				case 5:
					System.out.print("Introduzca el departamento del que desee ver sus empleados");
                    departamento = sc.nextLine();
                    List<Empleado> empleadosDepto = ge.buscarPorDepartamento(departamento);

                    if(empleadosDepto.isEmpty()) {
                        System.out.println("No hay empleados en el departamento " + departamento);
                    } else {
                        System.out.println("Empleados en " + departamento + ":");
                        System.out.println(empleadosDepto);
                    }
                    break;
					
				case 6:
					ge.imprimirLista();
					break;

				case 7:
					List<Empleado> mejores = ge.empleadosMejorSalario();
					if (mejores.isEmpty()) {
						System.out.println("No hay empleados registrados");
					} else {
						System.out.println("Empleado(s) mejor pagado(s) (Salario: " + ge.mejorSalario() + "):");
						System.out.println(mejores);;
					}
					break;

				case 8:
					List<Empleado> ordenadosId = ge.ordenarPorId();
					System.out.println("Empleados ordenados por ID:");
					System.out.println(ordenadosId);
					break;

				case 9:
					List<Empleado> ordenadosAntig = ge.ordenarPorAntigüedad();
					System.out.println("Empleados ordenados por antigüedad:");
					System.out.println(ordenadosAntig);
					break;

				default:
					System.out.println("Escoja una opción válida");
					break;
				}
			
		}while(opcion != 0);
		
	}

}
