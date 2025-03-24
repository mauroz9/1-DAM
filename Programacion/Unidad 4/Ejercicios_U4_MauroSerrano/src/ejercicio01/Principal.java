package ejercicio01;

public class Principal {

	public static void main(String[] args) {
		Ordenador o=new Ordenador(345, 3.5, 235, "DELL");
		Sobremesa s1=new Sobremesa(1000, 3.8, 998.99, "MSI",233);
		Portatil p1=new Portatil(512, 3.1, 477.99, "Asus", false, 99);
		Portatil p2=new Portatil(512, 3.1, 477.99, "Xiaomi", true, 99);
		
		System.out.println("Precio de ordenador "+o.precioVenta(13.0));
		System.out.println("Precio sobremesa "+s1.precioVenta(13.0));
		System.out.println("Precio portatil 1 "+p1.precioVenta(13.0));
		System.out.println("Precio portatil 2 "+p2.precioVenta(13.0));
		

	}

}
