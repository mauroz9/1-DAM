package ejercicio03;

import utilidades.Leer;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tam=100, opcion, telefonos=3;
		double descuento, precio;
		String modelo, marca, modeloIntercambio;
		char respuestaSegundaMano;
		boolean segundaMano;
		
		Movil m1=new Movil("Samsung", "A51", false, false, 124.99);
		Movil m2=new Movil("Apple", "Iphone15", true ,true, 650);
		Movil m3=new Movil("Xiaomi", "Note8", false, false, 99.95);
		
		Movil lista[]=new Movil[tam];
		Vendedor v;
		
		lista[0]=m1;
		lista[1]=m2;
		lista[2]=m3;
		
		v=new Vendedor(0, lista);
		
		System.out.println("Bienvenido al sistema de gestión de la venta ambulante de teléfonos");
		
		do {
			System.out.println("\n\n¿Qué desea hacer?");
			System.out.println("0. Salir");
			System.out.println("1. Comprobar Stock");
			System.out.println("2. Calcular un descuento");
			System.out.println("3. Realizar un cambio");
			System.out.println("4. Posibles ganancias");
			opcion=Leer.datoInt();
			
			switch(opcion){
				case 0:
					System.out.println("Saliendo...");
					break;
					
				case 1:
					System.out.println("Comprobando stock...");
					v.imprimirStock(v.comprobarStock(telefonos));
					break;
					
				case 2:
					System.out.println("Actualmente se encuentran disponibles:");
					v.imprimirStock(v.comprobarStock(telefonos));
					System.out.println("Introduzca el modelo que desee");
					modelo=Leer.dato();
					if(v.buscarPorModelo(modelo, v.comprobarStock(telefonos))==null) {
						System.out.println("Ese teléfono no lo tenemos en stock");
					}else {
						System.out.println("Introduzca el porcentaje de descuento");
						descuento=Leer.datoDouble();
						System.out.printf("El precio con el descuento sería: %.2f€",v.calcularDescuento(descuento, v.buscarPorModelo(modelo, v.comprobarStock(telefonos))));
					}
					break;
					
				case 3:
					System.out.println("Cual es el modelo del teléfono por el que va a intercambiar el nuevo");
					modelo=Leer.dato();
					if(v.buscarPorModelo(modelo, v.comprobarStock(telefonos))==null) {
						System.out.println("Ese teléfono no lo tenemos en stock");
					}else {
						System.out.println("Introduzca la marca del teléfono");
						marca=Leer.dato();
						System.out.println("Introduzca el modelo");
						modeloIntercambio=Leer.dato();
						System.out.println("¿Es de segunda mano? (y/n)");
						respuestaSegundaMano=Leer.datoChar();
						if(respuestaSegundaMano!='y' && respuestaSegundaMano!='n') {
							do {
								System.out.println("Introduce una respuesta válida");
								respuestaSegundaMano=Leer.datoChar();
							}while(respuestaSegundaMano !='y' && respuestaSegundaMano!='n');
						}
						if(respuestaSegundaMano=='y') {
							segundaMano=true;
						}else {
							segundaMano=false;
						}
						System.out.println("¿A qué precio lo pondra en venta?");
						precio=Leer.datoDouble();
						v.cambiarTelefono(new Movil(marca, modeloIntercambio, false, segundaMano, precio), v.buscarPorModelo(modelo, v.comprobarStock(telefonos)));
						System.out.println("Intercambio realizado");
						
					}
					break;
					
				case 4:
					System.out.printf("Si vendes todo el stock, sumando lo ya vendidio, obtendras: %.2f€",v.calcularGanancias());
			}
			
		}while(opcion!=0);
		
		
	}

}
