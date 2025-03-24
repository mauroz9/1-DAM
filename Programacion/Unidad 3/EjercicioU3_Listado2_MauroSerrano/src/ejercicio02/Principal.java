package ejercicio02;

import utilidades.Leer;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int tam=100, contadorHabitaciones=3, opcion, id, diasContratados;
		double precioHab, servicioExtra;
		String nombreCliente;
		
		Habitacion h1=new Habitacion(1, 20, 23.4, "Mauro Serrano", 3, true);
		Habitacion h2=new Habitacion(3, 17, 0, "", 0, false);
		Habitacion h3=new Habitacion(6, 24, 5, "Juan Hernández", 2, true);
		
		Habitacion lista[]=new Habitacion[tam];
		Hotel h;
		
		lista[0]=h1;
		lista[1]=h2;
		lista[2]=h3;
		
		h=new Hotel(lista);
		
		System.out.println("Bienvenido al programa de gestion del hotel");
		
		do {
			System.out.println("¿Qué desea?");
			System.out.println("0. Salir");
			System.out.println("1. Agregar una habitación a la lista");
			System.out.println("2. Hospedar a un cliente");
			System.out.println("3. Calcular precio final");
			System.out.println("4. Generar factura");
			opcion=Leer.datoInt();
			
			switch(opcion) {
				case 0:
					System.out.println("Saliendo...");
					break;
					
				case 1:
					System.out.println("Indique el número de habitación");
					id=Leer.datoInt();
					if(h.comprobarNumeroHab(id, contadorHabitaciones)) {
						do {
							System.out.println("Ya existe una habitación con ese identificador, introduzca otro distinto");
							id=Leer.datoInt();
						}while(h.comprobarNumeroHab(id, contadorHabitaciones));
					}
					
					System.out.println("Indique el precio por día");
					precioHab=Leer.datoDouble();
					h.agregarHabitacion(new Habitacion(id, precioHab, 0, "", 0, false), contadorHabitaciones);
					contadorHabitaciones++;
					break;
					
				case 2:
					System.out.println("-------HABITACIONES DE HOTEL-------\n");
					h.listarTodas();
					System.out.println("\n-----------------------------------");
					System.out.println("Qué habitación desea el cliente");
					id=Leer.datoInt();
					if(!h.comprobarNumeroHab(id, contadorHabitaciones)) {
						do {
							System.out.println("Esa habitación no existe, introduzca otra distinta");
							id=Leer.datoInt();
						}while(!h.comprobarNumeroHab(id, contadorHabitaciones));
					}
					if(h.comprobarDisponibilidad(id, contadorHabitaciones)) {
						System.out.println("Esa habitación ya esta ocupada");
					}else {
						System.out.println("¿Cuánto dinero desea consumir en el bar?");
						servicioExtra=Leer.datoDouble();
						if(servicioExtra<0) {
							do {
								System.out.println("Introduzca una cantidad real");
								servicioExtra=Leer.datoDouble();
							}while(servicioExtra>=0);
						}
						System.out.println("Introduzca el nombre y apellido del cliente");
						nombreCliente=Leer.dato();
						System.out.println("¿Cuántos dias va ha hospedarse?");
						diasContratados=Leer.datoInt();
						if(diasContratados<=0) {
							do {
								System.out.println("Introduzca una cantidad real");
								servicioExtra=Leer.datoDouble();
							}while(diasContratados>0);
						}
						h.hospedarCliente(id, servicioExtra, nombreCliente, diasContratados, diasContratados);
						System.out.println("La reserva ha sido completada");
					}
					break;
					
				case 3:
					System.out.println("Indíque el número de habitación");
					id=Leer.datoInt();
					if(!h.comprobarNumeroHab(id, contadorHabitaciones)) {
						do {
							System.out.println("Esa habitación no existe, introduzca otra distinta");
							id=Leer.datoInt();
						}while(!h.comprobarNumeroHab(id, contadorHabitaciones));
					}
					h.precioFinal(id, contadorHabitaciones);
					break;
					
				case 4:
					System.out.println("Indíque el número de habitación");
					id=Leer.datoInt();
					if(!h.comprobarNumeroHab(id, contadorHabitaciones)) {
						do {
							System.out.println("Esa habitación no existe, introduzca otra distinta");
							id=Leer.datoInt();
						}while(!h.comprobarNumeroHab(id, contadorHabitaciones));
					}
					if(!h.comprobarDisponibilidad(id, contadorHabitaciones)) {
						System.out.println("No se puede generar la factura, esa habitación no esta ocupada");
					}else {
						h.imprimirFactura(id, contadorHabitaciones);
					}
					break;
					
				default:
					System.out.println("Introduzca una opción válida");
					break;
			}
			
		}while(opcion!=0);
	}

}
