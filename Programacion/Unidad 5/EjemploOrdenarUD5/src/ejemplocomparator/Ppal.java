package ejemplocomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ppal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int opcionUser, pos=0;
		// Colección de corredores
		List<Corredor> corredores = new ArrayList<Corredor>();

		
		corredores.add(new Corredor(4, 1.43, "Jesse Owens"));
		corredores.add(new Corredor(8, 1.11, "Ángel Naranjo"));
		corredores.add(new Corredor(3, 2.23, "Abel Antón"));
		corredores.add(new Corredor(1, 1.12, "Luis Miguel López"));
		corredores.add(new Corredor(6, 1.14, "Miguel Campos"));
		corredores.add(new Corredor(5, 1.13, "Rafa Villar"));
		corredores.add(new Corredor(7, 2.11, "Emil Zatopek"));
		corredores.add(new Corredor(2, 2.35, "Carl Lewis"));

		// Imprimimos la lista sin ordenar usando for each, 
		// al ser ArrayList, se muestra en el orden en el que 
		//han sido insertados

		System.out.println("\tCORREDORES");
		System.out.println();

		for (Corredor con : corredores) {
			System.out.println(con);
		}

		do {
			System.out.println();
			System.out.println("ELIJA UNA OPCION");
			System.out.println("0.Salir");
			System.out.println("1.Ordenar por nombre");
			System.out.println("2.Ordenar por dorsal");
			System.out.println("3.Ordenar por marca y ganadores");
			opcionUser = Leer.datoInt();

			switch (opcionUser) {
				case 1:
					// ******************
					// Ordenamos todos los corredores por nombre, 
					//sentido inverso a orden alfabético
					System.out.println();
					System.out.println("\tCORREDORES (ordenados alfabéticamente, "
							+ "fíjate en la Á con tilde)");
					// Al método sort de Collections se le pueden pasar dos argumentos:
					// La lista a ordenar, en este caso corredores
					// De tipo List es hija de Colletions y
					// el criterio con el que ordenar, en este caso, 
					// un objeto de la clase que implemente 
					// el método que vamos a usar para ordenar, es decir, 
					// una instancia de la clase ComparaPorNombre
					
					Collections.sort(corredores, new ComparaPorNombre());
					System.out.println();
					for (Corredor con : corredores) {
						System.out.println(con);
					}
										
					break;
	
				case 2:
					// ******************
					// Ordenamos todos los corredores por número de dorsal 
					// de forma natural, según método compareTo de la 
					// clase Corredor, de menor a mayor
					System.out.println();
					System.out.println("\tCORREDORES (por número de dorsal "
							+ "de menor a mayor)");
					Collections.sort(corredores);
					System.out.println();
					for (Corredor con : corredores) {
						System.out.println(con);
					}
					break;
	
				case 3:
					// ******************
					// Imprimimos los 3 primeros con marca más baja, es decir, 
					// ordenamos por marca y en el segundo for
					// mostramos los tres primeros con su medalla
					// Solo a nivel académico, no es buena idea 
					// ordenar toda una lista para ver los 3 primeros, 
					// sería mejor buscar los 3 tiempos menores
					
					System.out.println();
					System.out.println("\tGANADORES");
					Collections.sort(corredores, new ComparaPorMarca());
					System.out.println();
	
					for (Corredor con : corredores) {
						System.out.println(con);
					}
					
					System.out.println();
					System.out.println();
					
					//Bucle para mostrar a los ganadores con su medalla
					
					for (Corredor con : corredores) {
						if (pos == 0) {
							System.out.println("ORO --> " + con);
						}
						if (pos == 1) {
							System.out.println("PLATA --> " + con);
						}
						if (pos == 2) {
							System.out.println("BRONCE --> " + con);
						}
						pos++;
					}

					break;
	
				default:
					System.out.println("Opción no válida");
					break;
			}
			
		} while (opcionUser != 0);
	}

}
