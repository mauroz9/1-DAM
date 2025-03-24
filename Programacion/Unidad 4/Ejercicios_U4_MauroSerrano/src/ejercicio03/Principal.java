package ejercicio03;

import java.nio.file.spi.FileSystemProvider;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcionCoche, opcionEmision;
		
		Motocicletas m;
		Coche c;
		Furgoneta f;
		
		System.out.println("Bienvenido al programa de gestión de impustos de circulación");
		System.out.println("Seleccione su tipo de vehículo");
		do {
			System.out.println("0. Salir");
			System.out.println("1. Motocicleta");
			System.out.println("2. Coche");
			System.out.println("3. Furgoneta");
			do {
				opcionCoche=Leer.datoInt();
			}while(opcionCoche<0 && opcionCoche>3);
			
			System.out.println("A continuación seleccione el tipo de etiqueta");
			do {
				System.out.println("0. Salir");
				System.out.println("1. Cero Emisiones");
				System.out.println("2. ECO");
				System.out.println("3. Tipo B");
				System.out.println("4. Tipo C");
				do {
					opcionEmision=Leer.datoInt();
				}while(opcionEmision<0 && opcionEmision>4);
				
			}while(opcionEmision!=0);
		}while(opcionCoche!=0);
	}

}
