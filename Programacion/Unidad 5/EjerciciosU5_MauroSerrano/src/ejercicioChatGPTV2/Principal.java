package ejercicioChatGPTV2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		Set <Book> bookList = new HashSet <Book> ();
		
		Book b1 = new Book("978-84-204-6455-1", "Cien años de soledad", "Carlos Ruiz Zafón", 1605, 22.50, true);
		Book b2 = new Book("978-84-376-0494-7", "1984", "George Orwell", 1967, 18.90, false);
		Book b3 = new Book("978-84-450-0123-6", "El Principito", "Antoine de Saint-Exupéry", 1943, 15.75, true);
		Book b4 = new Book("978-84-9838-141-1", "Don Quijote de la Mancha", "Miguel de Cervantes", 1605, 30.20, true);
		Book b5 = new Book("978-84-339-6668-9", "La sombra del viento", "Carlos Ruiz Zafón", 2001, 22.50, false);
		Book b6 = new Book("978-84-08-09426-5", "Harry Potter y la piedra filosofal", "J.K. Rowling", 1997, 20.00, true);
		
		bookList.add(b1);
		bookList.add(b2);
		bookList.add(b3);
		bookList.add(b4);
		bookList.add(b5);
		bookList.add(b6);
		
		Library l = new Library (bookList);
		
		int option, year, answer;
		String ISBN, title, author;
		double price;
		boolean available;
		
		System.out.println("Bienvenido a la biblioteca");
		
		do {
			System.out.println("\n¿Qué desea hacer?");
			System.out.println("0. Salir");
			System.out.println("1. Añadir un libro");
			System.out.println("2. Filtrar por autor");
			System.out.println("3. Buscar por ISBN");
			System.out.println("4. Encontrar el libro más antiguo");
			System.out.println("5. Eliminar un libro");
			System.out.println("6. Modificar un libro");
			System.out.println("7. Ordenar por ISBN");
			System.out.println("8. Ordenar por año de publicación");
			System.out.println("9. Mostrar libros disponibles");
			
			option = Integer.parseInt(sc.nextLine());
			
			switch(option) {
				case 0:
					System.out.println("Saliendo...");
					break;
					
				case 1:
					System.out.println("Introduzca el ISBN");
					ISBN = sc.nextLine();
					System.out.println("Introduzca el título");
					title = sc.nextLine();
					System.out.println("Introduzca el autor");
					author = sc.nextLine();
					System.out.println("Introduzca el año de publicaión");
					year = Integer.parseInt(sc.nextLine());
					System.out.println("Introduzca el precio");
					price = Double.parseDouble(sc.nextLine());
					do {
						System.out.println("¿Está disponible? (y=1 n=0)");
						answer = Integer.parseInt(sc.nextLine());
					}while(answer != 1 && answer != 0);
					if(answer == 1) {
						available = true;
					}else {
						available = false;
					}
					
					l.addBook(new Book(ISBN, title, author, year, price, available));
					System.out.println("Libro añadido");
					break;
					
				case 2:
					System.out.println("Introduzca un author");
					author = sc.nextLine();
					System.out.println(l.searchByAuthor(author));
					break;
					
				case 3:
					System.out.println("Introduzca el ISBN");
					ISBN = sc.nextLine();
					if(l.searchByISBN(ISBN) != null) {
						System.out.println(l.searchByISBN(ISBN));
					}else {
						System.out.println("Libro no encontrado");
					}
					break;
					
				case 4:
					System.out.println("Los/el libro más antiguo:");
					System.out.println(l.searchByYear(l.oldestPubYear()));
					break;
					
				case 5:
					System.out.println("Introduzca el ISBN");
					ISBN = sc.nextLine();
					if(l.removeBook(l.searchByISBN(ISBN))) {
						System.out.println("Libro eliminado");
					}else {
						System.out.println("No se ha podido eliminar");
					}
					break;
					
				case 6:
					System.out.println("Introduzca el ISBN");
					ISBN = sc.nextLine();
					System.out.println("Introduzca el precio");
					price = Double.parseDouble(sc.nextLine());
					if(l.modifyPrice(l.searchByISBN(ISBN), price)) {
						System.out.println("Libro modificado");
					}else {
						System.out.println("No se ha podido modificar");
					}
					break;
					
				case 7:
					System.out.println("Lista ordenada por ISBN:");
					System.out.println(l.orderByISBN());
					break;
					
				case 8:
					System.out.println("Lista ordenada por año y precio:");
					System.out.println(l.orderByPubYear());
					break;
					
				case 9:
					System.out.println("Libros disponibles:");
					System.out.println(l.searchAvailableBooks());
					break;
					
				default:
					System.out.println("Escoja una opción válida");
					break;
			}
			
		}while(option != 0);
		
	}

}
