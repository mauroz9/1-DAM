package ejemplo04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map <Integer, Alumno> listado = new HashMap <Integer, Alumno> ();
		
		/*listado.add(new Alumno ("2384732K", "kjdjf", 4.6));
		listado.add(new Alumno ("3534534J", "gasggds", 4.6));*/
			
		Secretaria sc = new Secretaria (listado);
		System.out.println(listado);
	
		
		 
	}

}
