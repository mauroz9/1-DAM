package ejemplo_polimorfismo;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//NO podemos instanciar Figura f=new Figura(); pués es abstracta
		Cuadrado c=new Cuadrado("Cuadrado 1", "Rojo", 2);
		Figura f2=new Cuadrado("Cuadrado 2", "Azul", 3);
		Figura f3=new Circulo("Circulo 1", "Rojo", 4);
		OperacionesFiguras op=new OperacionesFiguras();
		Figura [] lista= {f2, f2, f3, f3};
		
		System.out.println(op.calcularAreaFigura(c));
		System.out.println("La suma es: "+op.calcularSumaAreas(lista));
		
		
	}

}
