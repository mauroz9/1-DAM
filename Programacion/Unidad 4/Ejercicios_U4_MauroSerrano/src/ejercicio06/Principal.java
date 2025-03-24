package ejercicio06;

import utilidades.Leer;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion, opcionOficina, numCuenta, tam=100, contador=0, numTransacciones;
		double dinero;
		boolean acceso=false;
		Cuenta cuentaBuscada=null;
		
		Cuenta c1=new CCorriente(783462, 111, 7273.53, 5, 54);
		Cuenta c2=new CJoven(663542, 561, 67273.54, 1);
		Cuenta c3=new CEmpresa(345662, 123, 95673.21, 1);
		Oficina o;
		
		Cuenta [] lista=new Cuenta[tam];
		lista[contador]=c1;
		contador++;
		lista[contador]=c2;
		contador++;
		lista[contador]=c3;
		contador++;
		
		o=new Oficina(lista);
		
		System.out.println("Bienvenido al cajero");
		do {
			System.out.println("\nIntroduzca su número de cuenta (0 para cancelar)");
			numCuenta=Leer.datoInt();
			if(o.buscarCuenta(numCuenta)!=null) {
				cuentaBuscada=o.buscarCuenta(numCuenta);
				acceso=true;
			}else if(numCuenta!=0){
				System.out.println("Número de cuenta no encontrado");
			}
			
			if(acceso) {
				do {
					System.out.println("\n\n¿Qué desea hacer?");
					System.out.println("0. Salir");
					System.out.println("1. Comprobar saldo");
					System.out.println("2. Ingresar dinero");
					System.out.println("3. Retirar saldo");
					System.out.println("4. Modo oficina");
					opcion=Leer.datoInt();
					
					switch(opcion) {
						case 0:
							System.out.println("Saliendo...");
							break;
							
						case 1:
							System.out.printf("Su saldo es: %.2f", cuentaBuscada.getSaldo());
							break;
							
						case 2:
							do {
								System.out.println("Introduzca la cantidad que desee ingresar (0 para cancelar)");
								dinero=Leer.datoDouble();
								if(dinero<0){
									System.out.println("Introduzca una cantidad válida");
								}else if(dinero>0){
									cuentaBuscada.ingresarDinero(dinero);
									System.out.printf("Saldo actualizado: %.2f€",cuentaBuscada.getSaldo());
								}
							}while(dinero<0);
							break;
							
						case 3:
							do {
								System.out.println("Introduzca la cantidad que desee retirar (0 para cancelar)");
								dinero=Leer.datoDouble();
								if(dinero<0 || dinero>cuentaBuscada.getSaldo()){
									System.out.println("Introduzca una cantidad válida");
								}else if(dinero>0){
									cuentaBuscada.retirarDinero(dinero);
									System.out.printf("Saldo actualizado: %.2f€",cuentaBuscada.getSaldo());
								}
							}while(dinero<0 || dinero>cuentaBuscada.getSaldo());
							break;
							
						case 4:
							System.out.println("Bienvenido a la gestión del banco");
							do {
								System.out.println("¿Qué desea hacer?");
								System.out.println("0. Salir");
								System.out.println("1. Dinero total");
								System.out.println("2. Ganancias");
								System.out.println("3. Gastos");
								opcionOficina=Leer.datoInt();
								
								switch(opcionOficina) {
									case 0:
										System.out.println("Saliendo...");
										break;
										
									case 1:
										System.out.printf("El banco cuenta con un total de: %.2f€",o.calcularTotal());
										break;
										
									case 2:
										System.out.println("Introduzca el número de transacciones por cuentas de Empresa");
										numTransacciones=Leer.datoInt();
										System.out.printf("El banco ha ganado un total de: %.2f",o.calcularImportes(cuentaBuscada, numTransacciones));
										break;
										
									case 3:
										System.out.println("Introduzca el número de transacciones por cuentas Jovenes");
										numTransacciones=Leer.datoInt();
										System.out.printf("El banco ha gastado un total de: %.2f",o.calcularImportes(cuentaBuscada, numTransacciones));
										break;
										
									default:
										System.out.println("Escoja una opción válida");
								}
								
							}while(opcionOficina!=0);
							break;
							
						default:
							System.out.println("Escoja una opción válida");
					}
				}while(opcion!=0);
			}
		}while(numCuenta!=0);
		
	}

}
