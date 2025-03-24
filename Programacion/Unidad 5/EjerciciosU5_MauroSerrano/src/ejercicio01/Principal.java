package ejercicio01;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int opcion, indice;
		String titulo, contenido, fecha;
		Nota n;
		Nota n1=new Nota("Compra", "Pan, Jamón, Leche", "27-02-2025");
		Nota n2=new Nota("Exámenes", "Base de Datos, Programación", "26-02-2025");
		Nota n3=new Nota("Rutina", "Levantarme y estudiar", "27-02-2025");
		GestionarNota gn;
		List <Nota> notas=new ArrayList <Nota> ();
		notas.add(n1);
		notas.add(n2);
		notas.add(n3);
		gn=new GestionarNota(notas);
		
		do {
            System.out.println("\nGestión de Notas");
            System.out.println("1. Añadir una nueva nota");
            System.out.println("2. Mostrar todas las notas");
            System.out.println("3. Mostrar una nota específica");
            System.out.println("4. Mostrar el número de notas guardadas");
            System.out.println("5. Eliminar una nota");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                	System.out.println("Diga el título de la nota");
                	titulo=sc.nextLine();
                	System.out.println("Diga el contenido de la nota");
                	contenido=sc.nextLine();
                	System.out.println("Introduzca la fecha de creación (dia-mes-año)");
                	fecha=sc.nextLine();
                	n=new Nota(titulo, contenido, fecha);
                    gn.crearNota(n);
                    break;
                case 2:
                    gn.mostrarNotas();;
                    break;
                case 3:
                    gn.mostrarNotas();
                    System.out.println("Introduzca el número indice de la nota que quiera ver");
                    indice=sc.nextInt();
                    gn.buscarNota(indice);
                    break;
                case 4:
                    gn.mostrarNumeroDeNotas();
                    break;
                case 5:
                	gn.mostrarNotas();
                    System.out.println("Introduzca el número indice de la nota que quiera eliminar");
                    indice=sc.nextInt();
                    gn.eliminarNota(indice);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 6);
		
		sc.close();
    }
		
}
