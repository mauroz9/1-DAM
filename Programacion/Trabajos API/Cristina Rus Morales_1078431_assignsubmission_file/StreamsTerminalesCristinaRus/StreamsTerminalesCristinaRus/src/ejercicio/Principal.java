package ejercicio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import utilidades.Leer;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*La asociación StreamPets tiene un refugio de animales y nos ha pedido ayuda para gestionar el registro que 
		 * tienen de ellos; creen que con esto pueden lograr la adopción de más animales. Tendremos la clase Animal, 
		 * con la cual derivarán los tres tipos de animales que tienen en el refugio: perros, gatos y conejos.
		 * 
		 * Se puede utilizar el tipo de colección que se crea más adecuada.
		 * 
		 * Los atributos generales de una animal son: el nombre, la edad, el precio de la adopción 
		 * (este precio no es su precio de “venta” sino que es el precio de los costes que la asociación 
		 * ha tenido que gastar en el animal mientras estaba bajo su cuidado), si está disponible para adoptar o no, 
		 * la fecha desde que llevan en el refugio y el número de chip.
		 * 
		 * Los perros tienen como atributo el peso, los gatos tienen como atributo el color y 
		 * los conejos si tiene el pelo corto o no.
		 * 
		 * Tendremos una Clase CRUD en la que realizaremos operaciones crud con los animales y 
		 * una Clase Gestion en la que usaremos la clase anterior y tendrá que tener las siguientes funcionalidades:
		 * 
		 * - Añadir un nuevo animal al refugio.
		 * - Buscar un animal por tipo.
		 * - Buscar un animal por número de chip.
		 * - Eliminar del registro un animal.
		 * - Mostrar el número total de animales que hay en el refugio.
		 * - Buscar el animal que lleve más tiempo en el refugio.
		 * - Mostrar los animales que estén disponibles para adoptar.
		 * - Comprobar si los gatos de la lista no tienen un color pasado como parámetro.
		 * - Buscar el animal más joven.
		 * - Mostrar media de pesos de los perros.
		 * - Comprobar si algún conejo de la lista tiene el pelo largo. 
		 * - Comprobar si el peso de todos los perros superan uno pasado como parámetro.
		 * - Ordenar los animales según el que haya estado más tiempo al que menos.
		 * - Buscar el conejo que tiene el mayor precio de adopción.
		 * - Calcular la suma de todos los precios de adopción.
		 */
		
		
		Perro p1= new Perro("Rex", 10, 1001, 50.0, true, LocalDate.of(2020, 1, 1), 30.5);
		Perro p2= new Perro("Max", 11, 1002, 60.0, false, LocalDate.of(2018, 5, 20), 25.0);
		Perro p3= new Perro("Luna", 3, 1003, 55.0, true, LocalDate.of(2023, 8, 15), 28.3);
		
		Gato g1= new Gato("Whiskers", 5, 2001, 40.0, true, LocalDate.of(2021, 4, 10), "Blanco");
		Gato g2= new Gato("Michi", 17, 2002, 45.0, false, LocalDate.of(2015, 7, 22), "Negro");
		Gato g3= new Gato("Garfield", 7, 2003, 30.0, true, LocalDate.of(2019, 10, 5), "Naranja");
		
		Conejo c1= new Conejo("Bugs", 2, 3001, 20.0, false, LocalDate.of(2024, 9, 12), true);
		Conejo c2= new Conejo("Copito", 6, 3002, 25.0, true, LocalDate.of(2020, 2, 28), false);
		
		List<Animal> listado=new ArrayList<Animal>();
		
		listado.add(p1);
		listado.add(p2);
		listado.add(p3);
		listado.add(g1);
		listado.add(g2);
		listado.add(g3);
		listado.add(c1);
		listado.add(c2);
		
		LocalDate fecha;
		String paso,color,nombre,fechaStr;
		int num,opcion,opcion2,edad,disponibleNum,peloCortoInt;
		double peso,precio;
		boolean disponible,peloCorto;
		CRUD c= new CRUD(listado);
		Gestion g=new Gestion (c);
		
		System.out.println("Buenas, en este programa gestionaremos un refugio de animales.");
		do {
			System.out.println("Indique una de las siguientes opciones:");
			System.out.println("0. Salir");
			System.out.println("1. Añadir un animal al refugio.");
            System.out.println("2. Eliminar un animal de la lista.");
            System.out.println("3. Mostrar lista ordenada por fecha de ingreso.");
            System.out.println("4. Mostrar animales de un tipo.");
            System.out.println("5. Mostrar la suma total de precios de adopción.");
            System.out.println("6. Mostrar media del peso de los perros.");
            System.out.println("7. Mostrar el número total de animales que hay en el refugio.");
            System.out.println("8. Mostrar los animales que estén disponibles para adoptar.");
            System.out.println("9. Buscar el conejo con el mayor precio de adopción.");
            System.out.println("10. Buscar un animal por número de chip.");
            System.out.println("11. Buscar el animal que lleve más tiempo en el refugio.");
            System.out.println("12. Buscar el animal más joven.");
            System.out.println("13. Verificar si ningún gato tiene un color específico.");
            System.out.println("14. Verificar si algún conejo tiene pelo largo.");
            System.out.println("15. Verificar si todos los perros superan un peso.");

            opcion=Leer.datoInt();
            
            switch(opcion) {
            case 0:
            	System.out.println("Hasta luego.");
            	break;
            case 1:
            	System.out.println("Indique el tipo de animal que desea añadir.");
                System.out.println("1. Perro");
                System.out.println("2. Gato");
                System.out.println("3. Conejo");
                opcion2=Leer.datoInt();
                if(opcion2>=1&&opcion2<=3) {
                    System.out.println("Introduzca el nombre del animal.");
                    nombre = Leer.dato();
                    System.out.println("Introduzca la edad del animal.");
                    edad = Leer.datoInt();
                    System.out.println("Introduzca el número de chip.");
                    num=Leer.datoInt();
                    System.out.println("Introduzca el precio de adopción.");
                    precio=Leer.datoDouble();
                    System.out.println("Indique 1 si está disponible para adoptar y 0 si no");
                    disponibleNum=Leer.datoInt();
                    if(disponibleNum==1) {
                    	disponible=true;
                    }else {
                    	disponible=false;
                    }
                    System.out.println("Introduce la fecha de ingreso (formato YYYY-MM-DD): ");
                    fechaStr=Leer.dato();
                    fecha=LocalDate.parse(fechaStr);
                    
                    
                    
                    switch(opcion2) {
                    case 1:
                    	System.out.println("Diga el peso del perro.");
                    	peso=Leer.datoDouble();
                    	g.agregarAnimal(new Perro(nombre,edad,num,precio,disponible,fecha,peso));
                    	break;
                    case 2:
                    	System.out.println("Diga el color del gato.");
                    	color=Leer.dato();
                    	g.agregarAnimal(new Gato(nombre,edad,num,precio,disponible,fecha,color));
                    	break;
                    case 3:
                    	System.out.println("Diga 1 si el conejo tiene el pelo corto o 0 si no.");
                    	peloCortoInt=Leer.datoInt();
                    	if(peloCortoInt==1) {
                    		peloCorto=true;
                    	}else {
                    		peloCorto=false;
                    	}
                    	g.agregarAnimal(new Conejo(nombre,edad,num,precio,disponible,fecha,peloCorto));
                    	break;
                    default:
                    	System.out.println("No ha introducido una opción válida.");
                    }
                    
                }else {
                	System.out.println("No ha introducido una opción válida.");
                }
            	break;
            case 2:
            	System.out.println("Diga el número del chip del animal que haya sido adoptado para eliminarlo del registro.");
            	num=Leer.datoInt();
            	g.eliminarAnimal(num);
            	System.out.println("Pulse cualquier tecla para continuar.");
            	paso=Leer.dato();
            	break;
            	
            case 3:
            	g.ordenarPorTiempo();
            	System.out.println("Pulse cualquier tecla para continuar.");
            	paso=Leer.dato();
            	break;
            	
            case 4:
            	System.out.println("Diga el tipo del animal que desea buscar.\n"
            			+ "1. Perro\n"
            			+ "2. Gato\n"
            			+ "3. Conejo");
            	num=Leer.datoInt();
            	if(!g.buscarPorTipo(num).isEmpty()) {
            		System.out.println(g.buscarPorTipo(num));
            	}else {
            		System.out.println("No hay ningún animal de ese tipo.");
            	}
            	
            	System.out.println("Pulse cualquier tecla para continuar.");
            	paso=Leer.dato();
            	break;
            case 5:
            	System.out.printf("La suma total de todos los precios de adopción es de %.2f euros.\n",g.obtenerSumaTotalPreciosAdopcion());
            	System.out.println("Pulse cualquier tecla para continuar.");
            	paso=Leer.dato();
            	break;
            case 6:
            	if(g.mediaPesoPerros()!=0) {
            		System.out.printf("La media de peso de los perros es de %.2f kg\n",g.mediaPesoPerros());
            	}else {
            		System.out.println("No hay perros en el refugio.");
            	}
            	
            	System.out.println("Pulse cualquier tecla para continuar.");
            	paso=Leer.dato();
            	break;
            case 7:
            	System.out.println("En el refugio hay "+g.obtenerTotalAnimales()+" animales.");
            	System.out.println("Pulse cualquier tecla para continuar.");
            	paso=Leer.dato();
            	break;
            case 8:
            	
            	if(!g.mostrarDisponibles().isEmpty()) {
            		System.out.println("A continuación se muestran los animales que están listos para ser adoptados:");
            		System.out.println(g.mostrarDisponibles());
            	}else {
            		System.out.println("No hay ningún animal listo para ser adoptado.");
            	}
            	
            	System.out.println("Pulse cualquier tecla para continuar.");
            	paso=Leer.dato();
            	break;
            case 9:
            	System.out.println("El conejo con el mayor precio de adopción es el siguiente:");
            	if(g.obtenerConejoMayorPrecio().isPresent()) {
            		System.out.println("Este es el conejo con mayor precio.");
            		System.out.println(g.obtenerConejoMayorPrecio());
            	}else {
            		System.out.println("No hay ningún conejo en el refugio.");
            	}
            	
            	System.out.println("Pulse cualquier tecla para continuar.");
            	paso=Leer.dato();
            	break;
            case 10:
            	System.out.println("Diga el número del chip del animal que quiera buscar.");
            	num=Leer.datoInt();
            	if(g.buscarPorChip(num).isPresent()) {
            		System.out.println("Este es el animal con ese número de chip:");
            		System.out.println(g.buscarPorChip(num));
            	}else {
            		System.out.println("No hay ningún animal con ese número de chip en el refugio.");
            	}
            	
            	System.out.println("Pulse cualquier tecla para continuar.");
            	paso=Leer.dato();
            	break;
            case 11:
            	if(g.buscarMasTiempo().isPresent()) {
            		System.out.println("El animal que lleva más tiempo en el refugio es el siguiente:");
            	System.out.println(g.buscarMasTiempo());
            	}else {
            		System.out.println("No hay ningún animal en el refugio.");
            	}
            	
            	System.out.println("Pulse cualquier tecla para continuar.");
            	paso=Leer.dato();
            	break;
            case 12:
            	
            	if(g.obtenerAnimalMasJoven().isPresent()) {
            		System.out.println("El animal más joven del refugio es el siguiente:");
            		System.out.println(g.obtenerAnimalMasJoven());
            	}else {
            		System.out.println("No hay ningún animal en el refugio.");
            	}
            	
            	System.out.println("Pulse cualquier tecla para continuar.");
            	paso=Leer.dato();
            	break;
            case 13:
            	System.out.println("Para ver si hay gatos de un color en específico, es necesario que lo indique a continuación.");
            	color=Leer.dato();
            	if(g.ningunGatoColor(color)) {
            		System.out.println("No hay ningún gato con ese color.");
            	}else {
            		System.out.println("Hay al menos un gato con ese color.");
            	}
            	System.out.println("Pulse cualquier tecla para continuar.");
            	paso=Leer.dato();
            	break;
            case 14:
            	if(g.algunConejoPeloLargo()) {
            		System.out.println("Hay al menos un conejo con el pelo largo.");
            	}else {
            		System.out.println("No hay ningún conejo con el pelo largo.");
            	}
            	System.out.println("Pulse cualquier tecla para continuar.");
            	paso=Leer.dato();
            	break;
            case 15:
            	System.out.println("Diga el peso para ver si todos los perros lo superan.");
            	peso=Leer.datoDouble();
            	if(g.todosLosPerrosSuperanPeso(peso)) {
            		System.out.println("Todos los perros superan el peso especificado.");
            	}else {
            		System.out.println("Hay al menos un perro que no supera el peso.");
            	}
            	System.out.println("Pulse cualquier tecla para continuar.");
            	paso=Leer.dato();
            	break;
            default:
            	
            }

			
			
			
			
			
		}while(opcion!=0);
		
	}

}
