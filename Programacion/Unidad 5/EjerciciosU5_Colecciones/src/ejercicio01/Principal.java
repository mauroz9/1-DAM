package ejercicio01;

import java.util.List;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Alumno> listaAlumnos = List.of(new Alumno("Ana", "García Pérez", "1DAM", 9.5, 18),
				new Alumno("Luis", "Martínez López", "1DAM", 8.2, 19),
				new Alumno("Antonio", "Fernández Ruiz", "2DAM", 7.8, 20),
				new Alumno("Alberto", "Jiménez Sánchez", "1DAM", 9.8, 18),
				new Alumno("María", "Rodríguez Díaz", "2DAM", 9.1, 19),
				new Alumno("Alicia", "Navarro Torres", "1DAM", 9.9, 17),
				new Alumno("Alejandro", "Hernández Molina", "1DAM", 8.9, 20));

		Secretaria secretaria = new Secretaria(listaAlumnos);

		System.out.println("Todos los alumnos:");
		secretaria.imprimirLista();

		System.out.println("\nAlumnos cuyo nombre empieza por 'A':");
		secretaria.filtrarLetra('A');

		System.out.println("\nTotal de alumnos: " + secretaria.contarTamaño());

		System.out.println("\nAlumnos de 1DAM con nota > 9:");
		secretaria.filtrarNota1DAM(9).forEach(a -> System.out.println(a));

		System.out.println("\nPrimeros 3 alumnos:");
		secretaria.obtenerTresPrimerosAlumnos();

		System.out.println("\nAlumnos de menor edad: ");
		secretaria.menorEdad().forEach(a -> System.out.println(a));

		System.out.println("\nPrimer alumno de la lista: " + secretaria.primerAlumno());

		System.out.println("\nAlumnos con nombre largo (>10 letras):");
		secretaria.buscarNombre10Letras().forEach(a -> System.out.println(a));

		System.out.println("\nAlumnos que empiezan por A y nombre <=6 letras:");
		secretaria.buscarNombreA6Letras().forEach(a -> System.out.println(a));
	}

}
