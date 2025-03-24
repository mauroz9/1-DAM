package ejemplo_figura;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Triangulo t=new Triangulo ("rojo", 2, 4);
		
		System.out.println(t.calcularArea());
		t.imprimirDetalles();
		
		System.out.println(t instanceof Figura);
	}

}
