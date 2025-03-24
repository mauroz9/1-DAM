package ejemplo_scanner;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombre, aux;
		double notaMedia;
		int edad;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduzca su nombre");
		nombre=sc.nextLine();
		System.out.println("Su nombre es: "+nombre);
		
		System.out.println("Diga su edad");
		aux=sc.nextLine();
		edad=Integer.parseInt(aux);
		System.out.println("Su edad es: "+edad);
		
		System.out.println("Diga la nota media");
		aux=sc.nextLine();
		notaMedia=Double.parseDouble(aux);
		System.out.println("La nota media es: "+notaMedia);
		
		sc.close();
		
	}

}
