package ejercicio03;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tam=10;
		double desde=0, hasta=10;
		double [] num=new double[tam];
		
		ArrayReales a=new ArrayReales(num);
		
		//Rellenar array
		
		a.rellenarArray(desde, hasta);
		
		a.mostrarArray();
		
		System.out.printf("\n\nMáximo: %.2f", a.calcularMaximo());
		System.out.printf("\nMínimo: %.2f", a.calcularMinimo());
		System.out.printf("\nSumatorio: %.2f", a.calcularSumatorio());
	}

}
