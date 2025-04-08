package ejemplo;

import java.util.*;

public class Principal {

    public static void main(String[] args) {

        /* Desarrolla un sistema de gestión para una tienda online que maneje productos de diferentes categorías.
         * Para ello, se crearán las siguientes clases:
         * 
         * Clase Producto:
         * - Nombre (String)
         * - Precio (double)
         * - Categoría (String)
         * 
         * Clase CRUD: Con metodos que cumplan las siguientes funciones:
         * - Añadir un producto a la lista con los datos ingresados por teclado.
         * - Mostrar los productos con precio mayor a 50€.
         * - Mostrar únicamente los nombres de los productos.
         * - Redondear los precios de los productos a enteros.
         * - Mostrar todas las letras de los nombres de los productos.
         * - Mostrar los valores ASCII de los caracteres de los nombres de los productos.
         * - Mostrar productos únicos (sin duplicados).
         * - Ordenar los productos por precio de menor a mayor.
         * - Ordenar los productos por precio de mayor a menor.
         * - Mostrar los productos con todos sus detalles.
         * - Obtener los 3 productos más baratos de la lista.
         * - Omitir los 2 productos más baratos y mostrar el resto.
         * - Mostrar los productos hasta encontrar el primero que cuesta más de 100€.
         * - Omitir los productos baratos y mostrar la lista a partir del primero que cuesta más de 100€.
         * - Recoger y mostrar todos los productos disponibles en la tienda.
         * 
         * Clase Principal:
         * - Implementar un menú de opciones con un switch para el usuario.
         */

        Scanner sc = new Scanner(System.in);

        List<Producto> productos = new ArrayList<>();
        CRUD crud = new CRUD(productos);

        productos.add(new Producto("Ordenador", 1250.99, "Electrónica"));
        productos.add(new Producto("Ratón", 25, "Electrónica"));
        productos.add(new Producto("Teclado", 45.75, "Electrónica"));
        productos.add(new Producto("Camiseta", 19, "Ropa"));
        productos.add(new Producto("Zapatillas", 79.99, "Ropa"));
        productos.add(new Producto("Teléfono", 699.99, "Electrónica"));
        productos.add(new Producto("Libro", 12, "Librería"));
        productos.add(new Producto("Cascos", 12.99, "Electrónica"));

        int opcion;
        String nombre, categoria;
        double precio;

        System.out.println("Bienvenido a nuestra tienda online.");

        do {
            System.out.print("""
                    \n0. Salir
                    1. Añadir nuevo producto
                    2. Mostrar productos con precio mayor a 50€
                    3. Mostrar solo los nombres de los productos
                    4. Redondear precios de los productos
                    5. Mostrar todas las letras de los nombres de los productos
                    6. Mostrar los valores ASCII de los nombres de los productos
                    7. Mostrar productos únicos
                    8. Ordenar productos por precio de menor a mayor
                    9. Ordenar productos por precio de mayor a menor
                    10. Mostrar productos con detalles
                    11. Mostrar los 3 productos más baratos
                    12. Omitir los 2 productos más baratos
                    13. Mostrar productos de menos de 100€
                    14. Mostrar productos de mas de 100€
                    15. Recoger todos los productos
                    Seleccione una opción:\t""");
            
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
            	case 0:
	                System.out.println("Saliendo...");
	                break;
	            case 1:
	            	System.out.println("\nA continuación introduce los datos del producto: ");
	            	System.out.print("Nombre: ");
	            	nombre = sc.nextLine();
	            	System.out.print("Precio: ");
	            	precio = Double.parseDouble(sc.nextLine());
	            	System.out.print("Categoría: ");
	            	categoria = sc.nextLine();
	            	crud.addProducto(new Producto(nombre, precio,categoria));
	            	System.out.println("Producto añadido con exito.");
	            	break;
	            case 2:
	                System.out.println();
	                crud.mostrarProductosCaros().forEach(System.out::println);
	                break;
	            case 3:
	                System.out.println();
	                crud.mostrarNombresProductos().forEach(System.out::println);
	                break;
	            case 4:
	                System.out.println();
	                crud.redondearPrecios().forEach(System.out::println);
	                break;
	            case 5:
	                System.out.println();
	                crud.mostrarLetrasDeProductos().forEach(System.out::println);
	                break;
	            case 6:
	                System.out.println();
	                crud.mostrarValoresASCII().forEach(System.out::println);
	                break;
	            case 7:
	                System.out.println();
	                crud.mostrarProductosUnicos().forEach(System.out::println);
	                break;
	            case 8:
	                System.out.println();
	                crud.ordenarPorPrecioAscendente().forEach(System.out::println);
	                break;
	            case 9:
	                System.out.println();
	                crud.ordenarPorPrecioDescendente().forEach(System.out::println);
	                break;
	            case 10:
	                System.out.println();
	                crud.mostrarProductosConDetalles().forEach(System.out::println);
	                break;
	            case 11:
	                System.out.println();
	                crud.mostrarTresProductosMasEconomicos().forEach(System.out::println);
	                break;
	            case 12:
	                System.out.println();
	                crud.omitirProductosEconomicos().forEach(System.out::println);
	                break;
	            case 13:
	                System.out.println();
	                crud.mostrarProductosHasta100().forEach(System.out::println);
	                break;
	            case 14:
	                System.out.println();
	                crud.omitirHastaEncontrarProductoCaro().forEach(System.out::println);
	                break;
	            case 15:
	                System.out.println();
	                crud.recogerTodosLosProductos().forEach(System.out::println);
	                break;
                default:
                    System.out.println("Opción inexistente, intentelo de nuevo.");
                    break;
            }
        } while (opcion != 0);

        sc.close();
    }
}
