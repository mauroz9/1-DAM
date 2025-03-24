package ejemplo01;

import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Producto p1=new Producto ("Patatas", 2.50, false);
		Producto p2=new Producto ("Helado oscuro", 8, true);
		Producto p3=new Producto ("Yogurt", 3.23, true);
		Producto p4=new Producto ("Magdalena", 1.20, false);
		Producto p5=new Producto ("Pizza", 2.30, true);
		Producto p6=new Producto ("Ensalada", 4.50, true);
		
		List <Producto> listado=new ArrayList <Producto>();
		listado.add(p1);
		System.out.println(listado);
		
		//Tamaño actual
		System.out.println("Tamaño: "+listado.size());
		
		listado.add(p2);
		System.out.println(listado);
		
		//Tamaño actualizado
		System.out.println("Tamaño: "+listado.size());
		
		//Borrado por objeto
		listado.remove(p2);
		System.out.println(listado);
		System.out.println("Tamaño: "+listado.size());
		
		listado.add(p3);
		System.out.println(listado);
		System.out.println("Tamaño: "+listado.size());
		
		//Borrado por id
		listado.remove(0);
		System.out.println(listado);
		System.out.println("Tamaño: "+listado.size());
		
		listado.add(0, p4);
		System.out.println(listado);
		System.out.println("Tamaño: "+listado.size());
		
		//Añadiendo por en medio desplaza a los otros objetos
		listado.add(0, p5);
		System.out.println(listado);
		System.out.println("Tamaño: "+listado.size());
		
		/*Añadir en una posición mayor (NO LO PERMITE)
		listado.add(23, p6);
		System.out.println(listado);
		System.out.println("Tamaño: "+listado.size());
		*/
		
		//Obtener un objeto
		System.out.println(listado.get(2));
		
		
	}

}
