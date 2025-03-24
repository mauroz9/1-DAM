package ejercicio02;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TarjetaDeVisita tv=new TarjetaDeVisita("Apple Inc", "Tim Cook", "203-483-3428", "tim.cook@apple.com");
		Carta c=new Carta("Apple Inc", "10/01/2025");
		
		tv.imprimirCabecera();
		c.imprimirCabecera();
		
		
	}

}
