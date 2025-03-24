package ejemplo_excepciones;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num=0;
		int den=0;
		double res=0;
		String aux;
		Scanner sc = new Scanner(System.in);
		
		do {
			try {
				System.out.println("Diga el numerador");
				aux=sc.nextLine();
				num=Integer.parseInt(aux);
				System.out.println("Diga el denominador");
				aux=sc.nextLine();
				den=Integer.parseInt(aux);
				res=num/den;
				System.out.printf("La división es: %.2f", res);
			}
			catch(ArithmeticException e) {
				System.out.println("El denominador debe ser distinto de 0");
			}
		}while(den==0);
	}

}
