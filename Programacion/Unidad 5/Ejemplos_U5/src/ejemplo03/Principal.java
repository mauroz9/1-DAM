package ejemplo03;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set <Alumno> listado = new HashSet <Alumno> ();
		
		listado.add(new Alumno ("2384732K", "kjdjf", 4.6));
		listado.add(new Alumno ("3534534J", "gasggds", 4.6));
			
		Secretaria sc = new Secretaria (listado);
		System.out.println(listado);
		sc.imprimirLista();
		
		 
	}

}
