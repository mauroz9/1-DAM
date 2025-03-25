package ejercicio04;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map <Integer, Contacto> listaContactos = new HashMap <Integer, Contacto>();
		
		Contacto c1 = new Contacto (1, "Ángel", "Naranjo", "983457834");
		Contacto c2 = new Contacto (2, "Mauro", "Serrano", "674236484");
		Contacto c3 = new Contacto (3, "Antonio", "Suarez", "873758244");
		Contacto c4 = new Contacto (34, "Antonio", "Sánchez", "873758244");
		
		listaContactos.put(20, c1);
		listaContactos.put(12, c2);
		listaContactos.put(34, c3);
		listaContactos.put(55, c4);
		
		Agenda a = new Agenda(listaContactos);
		
		System.out.println(listaContactos);
		
		System.out.println(a.getListaContactos().keySet());
		
		System.out.println(a.ordenadorClave());
		
		System.out.println(a.buscarContactoId(12));
		
		System.out.println(a.buscarContactoNombre("Antonio"));
		
		System.out.println("Lista ordenada por nombre:\n" );
		List<Contacto> lista = a.ordenarPorNombre();
		
		Collections.sort(lista, new CompararPorNombre());
		System.out.println(lista);
		
		System.out.println("Lista ordenada por nombre V2:\n" );
		a.ordenarPorNombreV2();

	}

}
