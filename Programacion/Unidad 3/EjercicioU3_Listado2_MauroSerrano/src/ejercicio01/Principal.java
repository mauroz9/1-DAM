 package ejercicio01;

import utilidades.Leer;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		int id,tam=100, contadorProductos=2, opcion;
		double precioFab, ganancia;
		boolean fragil;
		char siNo;
		String nombre;
		int seccion;
		
		Producto p1=new Producto(1,1.20,"Fanta N",false, 1);
		Producto p2=new Producto(2,85.99,"Pantalla",true, 4);
		Producto []lista = new Producto [tam];
		Tienda t;
		
		lista[0]=p1;
		lista[1]=p2;
		
		t=new Tienda(lista);
		
		System.out.println("Bienvenido al sistema de gestión de la tienda");
		do {
			System.out.println("\n\n¿Qué le gustaria hacer?");
			System.out.println("0. Salir");
			System.out.println("1. Listar los productos");
			System.out.println("2. Comprobar fragilidad de un producto");
			System.out.println("3. Añadir un producto");
			System.out.println("4. Calcular la inversión");
			System.out.println("5. Calcular el PVP de un producto");
			System.out.println("6. Calcular las posibles ganancias");
			opcion=Leer.datoInt();
			
			switch(opcion) {
				case 0:
					System.out.println("Saliendo...");
					break;
					
				case 1:
					System.out.println("Aquí tiene la lista de los productos actuales");
					t.listarTodos(); 
					break;
					
				case 2:
					System.out.println("¿De qué producto desea ver su fragilidad?");
					id=Leer.datoInt();
					t.imprimirFragil(t.buscarProducto(id, contadorProductos));
					break;
					
				case 3:
					System.out.println("Introduzca el ID del producto");
					id=Leer.datoInt();
					System.out.println("Introduzca el precio de fábrica del producto");
					precioFab=Leer.datoDouble();
					System.out.println("Introduzca el nombre del producto");
					nombre=Leer.dato();
					System.out.println("¿Es frágil? (y/n)");
					siNo=Leer.datoChar();
					if(siNo!='y' && siNo!='n') {
						do {
							System.out.println("Introduce una respuesta válida");
							siNo=Leer.datoChar();
						}while(siNo !='y' && siNo!='n');
					}
					if(siNo=='y') {
						fragil=true;
					}else {
						fragil=false;
					}
					System.out.println("Introduzca la sección del producto");
					seccion=Leer.datoInt();
					
					t.agregarProducto(new Producto (id,precioFab,nombre,fragil,seccion), contadorProductos);
					contadorProductos++;
					System.out.println("Lista actualizada");
					t.listarTodos();
					break;
					
				case 4:
					System.out.printf("La inversión en comprar los producto es: %.2f€",t.calcularInversion(contadorProductos));
					break;
					
				case 5:
					System.out.println("¿De qué producto deseas calcular su PVP?");
					id=Leer.datoInt();
					
					if(!t.comprobarExistencia(t.buscarProducto(id, contadorProductos))) {
						System.out.println("Ese producto no existe");
					}else {
						System.out.println("Qué porcentaje le quieres ganar");
						ganancia=Leer.datoDouble();
						
						System.out.printf("Debes ponerle el precio: %.2f€",t.calcularPVP(ganancia,t.buscarProducto(id, contadorProductos)));
					}
					break;
			}
			
			
		}while(opcion!=0);
		
	}

}
