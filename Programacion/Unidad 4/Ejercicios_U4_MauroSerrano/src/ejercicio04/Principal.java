package ejercicio04;

import utilidades.Leer;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tam=5, numProd=0, opcion, topeCaducidad=3;
		double iva=21.0, descuento=10.0;
		
		Producto p=new Producto(13.99, "Almohada", 1233);
		Producto a1=new Alimentacion(0.50, "Barra Pan", 0054, 2, false);
		Producto a2=new Alimentacion(3.50, "Pack Leche", 0373, 10, true);
		Producto e1=new Electronica(399.99, "PlayStation 5", 5723, true);
		Producto e2=new Electronica(23.99, "Aspiradora Mano", 2888, false);
		LineaDeVenta lista[]=new LineaDeVenta [tam];
		Venta v;
		
		lista[numProd]=new LineaDeVenta(p,2);
		numProd++;
		lista[numProd]=new LineaDeVenta(a1,4);
		numProd++;
		lista[numProd]=new LineaDeVenta(e1,1);
		numProd++;
		lista[numProd]=new LineaDeVenta(a2,1);
		numProd++;
		lista[numProd]=new LineaDeVenta(e2,1);
		numProd++;
		
		v=new Venta(lista);
		
		System.out.println("Bienvenido al programa de gestión del supermercado");
		do {
			System.out.println("\n¿Qué desea hacer?");
			System.out.println("0. Salir");
			System.out.println("1. Listar Productos");
			System.out.println("2. Imprimir Ticket");
			opcion=Leer.datoInt();
			
			switch(opcion) {
				case 0:
					System.out.println("Saliendo");
					break;
					
				case 1:
					v.listarProductos(topeCaducidad);
					break;
					
				case 2:
					v.imprimirTicket(iva, descuento, topeCaducidad);
					break;
					
				default:
					System.out.println("Seleccione una opción válida");
					break;
			}
			
			
		}while(opcion!=0);
		
	}

}
