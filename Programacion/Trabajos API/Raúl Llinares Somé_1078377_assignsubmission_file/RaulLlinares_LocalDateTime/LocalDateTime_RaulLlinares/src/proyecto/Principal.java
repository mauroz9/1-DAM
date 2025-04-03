package proyecto;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Principal {
	public static void main(String[] args) {
		//Desde el aeropuerto de Sevilla hemos creado una aplicación que se encargará de mostrar, a los usuarios, todos los vuelos
		//que hay con destino a 5 ciudades del país (Madrid,Barcelona, Tenerife, Mallorca y Santiago). El usuario podrá realizar distintas 
		//operaciones tanto para la búsqueda de vuelos, según fecha y hora, como según el id de un vuelo en específico. Podrá imprimir su billete
		//una vez elegido su vuelo. Esta aplicación está compuesta por dos clases modelo, Destino y Vuelo. La clase Destino tiene como atributos
		//el nombre de la ciudad y el tiempo de vuelo que hay desde nuestro aeropuerto hasta el destino en concreto. La clase Vuelo contiene como 
		//atributos un id del vuelo, una variable de tipo Destino y por último, la fecha y hora de salida de tipo LocalDateTime. Desde la clase 
		//Aeropuerto gestionamos todos los vuelos. Realizamos operaciones como el cálculo de la hora de llegada, la duración de vuelo, el tiempo restante
		//hasta el despegue, la hora de embarque y la busqueda de distintos vuelos. En una clase Principal creamos el menú donde el usuario podrá utilizar
		//todas estas opciones.
		
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter form = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		LocalDateTime fechaHora;
		String fechaHoraString;
		Destino mall = new Destino ("Mallorca",Duration.ofMinutes(90));
		Destino bar = new Destino ("Barcelona", Duration.ofMinutes(95));
		Destino mad = new Destino ("Madrid",Duration.ofMinutes(60));
		Destino gal = new Destino ("Galicia (Santiago)", Duration.ofMinutes(85));
		Destino can = new Destino ("Canarias (Tenerife)", Duration.ofMinutes(150));
		
		// Creamos vuelos para cada destino
      List<Vuelo> vuelos = new ArrayList<>();
      // Vuelos a Mallorca
      vuelos.add(new Vuelo(1, mall, LocalDateTime.of(2025, Month.MARCH, 28, 10, 30)));
      vuelos.add(new Vuelo(2, mall, LocalDateTime.of(2025, Month.APRIL, 04, 12, 00)));
      vuelos.add(new Vuelo(3, mall, LocalDateTime.of(2025, Month.MAY, 13, 14, 15)));
      vuelos.add(new Vuelo(4, mall, LocalDateTime.of(2025, Month.MAY, 28, 16, 45)));
      // Vuelos a Barcelona
      vuelos.add(new Vuelo(5, bar, LocalDateTime.of(2025, Month.MARCH, 28, 11, 00)));
      vuelos.add(new Vuelo(6, bar, LocalDateTime.of(2025, Month.APRIL, 07, 13, 30)));
      vuelos.add(new Vuelo(7, bar, LocalDateTime.of(2025, Month.MAY, 23, 15, 45)));
      vuelos.add(new Vuelo(8, bar, LocalDateTime.of(2025, Month.AUGUST, 30, 18, 00)));
      // Vuelos a Madrid
      vuelos.add(new Vuelo(9, mad, LocalDateTime.of(2025, Month.MARCH, 28, 10, 15)));
      vuelos.add(new Vuelo(10, mad, LocalDateTime.of(2025, Month.APRIL, 03, 12, 30)));
      vuelos.add(new Vuelo(11, mad, LocalDateTime.of(2025, Month.MAY, 06, 14, 50)));
      vuelos.add(new Vuelo(12, mad, LocalDateTime.of(2025, Month.JUNE, 12, 17, 05)));
      // Vuelos a Galicia
      vuelos.add(new Vuelo(13, gal, LocalDateTime.of(2025, Month.MARCH, 28, 9, 30)));
      vuelos.add(new Vuelo(14, gal, LocalDateTime.of(2025, Month.APRIL, 10, 11, 45)));
      vuelos.add(new Vuelo(15, gal, LocalDateTime.of(2025, Month.MAY, 20, 13, 55)));
      vuelos.add(new Vuelo(16, gal, LocalDateTime.of(2025, Month.JULY, 27, 16, 15)));
      // Vuelos a Canarias
      vuelos.add(new Vuelo(17, can, LocalDateTime.of(2025, Month.MARCH, 28, 07, 30)));
      vuelos.add(new Vuelo(18, can, LocalDateTime.of(2025, Month.APRIL, 05, 10, 00)));
      vuelos.add(new Vuelo(19, can, LocalDateTime.of(2025, Month.MAY, 14, 12, 30)));
      vuelos.add(new Vuelo(20, can, LocalDateTime.of(2025, Month.JUNE, 19, 14, 45)));
    
      Aeropuerto a = new Aeropuerto (vuelos);
		
      int opc, auxId;
      String auxFecha;
      LocalDate auxFechaObj;
     
      System.out.println("Bienvenido a la torre de control");
      do {
   	   System.out.println("0. Salir");
   	   System.out.println("1. Esta opción muestra todos los vuelos disponibles que hay en el aeropuerto");
   	   System.out.println("2. Mostraremos todos vuelos que hay en una fecha en concreto que será introducida por el usuario");
   	   System.out.println("3. Mostraremos todos los vuelos a partir de una hora y fecha introducida por teclado");
   	   System.out.println("4. Mostraremos el tiempo restante hasta la salida del vuelo según ID");
   	   System.out.println("5. Imprime un billete según el ID del vuelo escogido");
   	   opc=Integer.parseInt(sc.nextLine());
   	  
   	   switch(opc) {
   	   		case 0:
   	   			break;
   	   		case 1:
   	   			a.mostrarVuelos(a.getListaVuelos());
   	   			break;
   	   		case 2:
   	   			// Buscar una fecha específica y devolver todos los vuelos que salgan ese día
   	   			System.out.println("Diga el año, mes y día del vuelo: (AAAA-MM-dd)");
   	   			auxFecha=sc.nextLine();
   	   			auxFechaObj=LocalDate.parse(auxFecha); // !!!! LA LLAMADA AL MÉTODO ES ESTÁTICA
   	   			a.mostrarVuelos(a.buscarPorDia(auxFechaObj));
   	   			break;
   	   		case 3:
   	   			System.out.println("Introduce una fecha y hora (dd-MM-yyyy HH:mm): ");
   	   			fechaHoraString = sc.nextLine();
   	   			fechaHora = LocalDateTime.parse(fechaHoraString, form);
   	   			
   	   			if(a.buscarPorHora(fechaHora).isEmpty()) {
   	   				System.out.println("No hay vuelos disponibles");
   	   			}else {
   	   				a.mostrarVuelos(a.buscarPorHora(fechaHora));
   	   			}
   	   			break;
   	   		case 4:
   	   			System.out.println("Diga el ID de vuelo: ");
	   			auxId=Integer.parseInt(sc.nextLine());
	  
	   			if(a.calcularTiempoRestante(auxId).isZero()) {
	   				System.out.println("Este avión ya salió del aeropuerto");
	   			}else {
	   				System.out.printf("Faltan %d días\n",a.calcularTiempoRestante(auxId).toDays());
	   			}
   	   			break;
   	   		case 5:
   	   			System.out.println("Diga el ID de vuelo: ");
   	   			auxId=Integer.parseInt(sc.nextLine());
   	   			a.imprimirBillete(auxId);
   	   			break;
   	    	default:
   	    		System.err.println("Error: Escoja una opción válida");
   	    		break;
   	   }
      }while(opc!=0);
      System.out.println("Hasta pronto, ¡buen vuelo!");
      sc.close();
	}
	
	
}
