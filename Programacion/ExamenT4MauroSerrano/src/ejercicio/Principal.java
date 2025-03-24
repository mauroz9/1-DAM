package ejercicio;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion, numeroEntrada, tam=100, limiteDescuento=10, contadorEntradas=0;
		double precio1=40.00, precio2=70.00, descuento=10.00, iva=21, suplemento=35.00;
		EntradaNormal entradaBuscada=null;
		
		
		EntradaNormal e1=new EntradaNormal(1, 423, 4);
		EntradaNormal e2=new EntradaNormal(2, 424, 5);
		EntradaNormal g1=new EntradaGrupos(1, 644, 7, 11);
		EntradaNormal g2=new EntradaGrupos(2,324, 8, 8);
		EntradaNormal f1=new EntradaFamosos(1, 788, 3, "David Gueta");
		EntradaNormal f2=new EntradaFamosos(2, 342, 5, "Ariana Grande");
		EntradaNormal [] lista=new EntradaNormal[tam];
		
		lista[contadorEntradas]=e1;
		contadorEntradas++;
		lista[contadorEntradas]=e2;
		contadorEntradas++;
		lista[contadorEntradas]=g1;
		contadorEntradas++;
		lista[contadorEntradas]=g2;
		contadorEntradas++;
		lista[contadorEntradas]=f1;
		contadorEntradas++;
		lista[contadorEntradas]=f2;
		contadorEntradas++;
		
		Taquilla t=new Taquilla(lista);
		
		
		System.out.println("Bienvenido al Circo del Sol");
		do {
			System.out.println("\n\nQué desea hacer?");
			System.out.println("0. Salir");
			System.out.println("1. Obtener precio por entrada");
			System.out.println("2. Calcular el total de ventas a grupos");
			System.out.println("3. Calcular el total de ventas para la zona 2");
			System.out.println("4. Calcular el total de iva");
			opcion=Leer.datoInt();
			
			switch(opcion) {
				case 0:
					System.out.println("Saliendo...");
					break;
					
				case 1:
					System.out.println("Lista de entradas adjudicadas:");
					t.listarEntradas();
					System.out.println("\nSeleccione la entrada sobre la que quiere conocer su precio");
					numeroEntrada=Leer.datoInt();
					if(numeroEntrada<0 && numeroEntrada>contadorEntradas) {
						System.out.println("No existe esa entrada");
					}else {
						entradaBuscada=t.buscarEntrada(numeroEntrada);
						System.out.printf("El precio pagado por la entrada es de: %.2f€\n",t.calcularPrecioTaquilla(entradaBuscada, precio1, precio2, limiteDescuento, descuento, suplemento));
						System.out.printf("De ese precio, el iva corresponde a: %.2f€\n",entradaBuscada.calcularIVA(iva, precio1, precio2, limiteDescuento, suplemento));
						if(entradaBuscada instanceof EntradaFamosos) {
							((EntradaFamosos)entradaBuscada).imprimirMensajeRegalo();
						}
					}
					break;
					
				case 2:
					System.out.printf("En total, se han recaudado %.2f€ con las entradas de grupo\n",t.calcularVentasGrupo(precio1, precio2, limiteDescuento, descuento, suplemento));
					break;
					
				case 3:
					System.out.printf("En total, se han recaudado %.2f€ con las entradas de la zona 2",t.calcularVentasZona2(precio1, precio2, limiteDescuento, descuento, suplemento));
					break;
					
				case 4:
					System.out.printf("En total, los gastos relacionados con el IVA asciende a: %.2f€",t.calcularTotalIVA(precio1, precio2, limiteDescuento, iva, suplemento));
					
			}
			
		}while(opcion!=0);

	}

}
