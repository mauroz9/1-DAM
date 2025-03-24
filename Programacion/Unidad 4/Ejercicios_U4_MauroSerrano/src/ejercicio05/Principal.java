package ejercicio05;

import utilidades.Leer;

public class Principal {

	public static void main(String[] args) {
		int tam=100, contadorEmpleados=0, opcion, numeroEmpleado;
		double topeVentas=80;
		Empleado empleadoBuscado=null;
		
		Empleado e1=new Empleado("Mauro", "Serrano", 1345, 423);
		Empleado e2=new Vendedor("Alejando", "Martín", 1100, 134, 111, 2);
		Empleado e3=new Gerente("Matias", "Alonso", 1400, 543, 8);
		Empleado [] lista=new Empleado[tam];
		Oficina o=new Oficina(lista);
		
		lista[contadorEmpleados]=e1;
		contadorEmpleados++;
		lista[contadorEmpleados]=e2;
		contadorEmpleados++;
		lista[contadorEmpleados]=e3;
		contadorEmpleados++;
		
		System.out.println("Bienvenido a la base de datos de la empresa");
		do {
			System.out.println("\n¿Qué dese hacer?");
			System.out.println("0. Salir");
			System.out.println("1. Buscar a un empleado");
			System.out.println("2. Calcular sueldo");
			System.out.println("3. Listar a los empleados");
			System.out.println("4. Calcular gastos");
			opcion=Leer.datoInt();
			
			switch(opcion) {
				case 0:
					System.out.println("Saliendo...");
					break;
					
				case 1:
					do {
						System.out.println("Introduzca el número de empleado (para cancelar introduzca 0)");
						numeroEmpleado=Leer.datoInt();
						if(o.buscarEmpleado(numeroEmpleado)==null) {
							System.out.println("Empleado no encontrado");
						}else{
							empleadoBuscado=o.buscarEmpleado(numeroEmpleado);
							System.out.println(empleadoBuscado.toString());
							o.felicitarMejores(topeVentas);
						}
					}while(numeroEmpleado!=0 && empleadoBuscado==null);
					break;
					
				case 2:
					do {
						System.out.println("Introduzca el número de empleado (para cancelar introduzca 0)");
						numeroEmpleado=Leer.datoInt();
						if(o.buscarEmpleado(numeroEmpleado)==null) {
							System.out.println("Empleado no encontrado");
						}else{
							empleadoBuscado=o.buscarEmpleado(numeroEmpleado);
							System.out.printf("Su sueldo es de: %.2f€\n",o.calcularSueldoOficina(empleadoBuscado, topeVentas));
						}
					}while(numeroEmpleado!=0 && empleadoBuscado==null);
					break;
					
				case 3:
					System.out.println("Empleados actuales:");
					o.listarEmpleados(topeVentas);
					break;
					
				case 4:
					System.out.printf("La empresa cuenta con un gasto mensual de: %.2f",o.gastosTotales(topeVentas));
			}
		}while(opcion!=0);
	}

}
