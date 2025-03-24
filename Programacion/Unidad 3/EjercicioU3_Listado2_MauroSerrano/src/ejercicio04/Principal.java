package ejercicio04;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		int tam=100, clientes=3;
		
		Cliente c1=new Cliente("53583450L", "Mauro", "Serrano", true, 61.5, 1.60);
		Cliente c2=new Cliente("63274332J", "David", "Mateos", false, 73.2, 1.78);
		Cliente c3=new Cliente("37264762H", "Raul", "Roman", false, 70.5, 1.70);
		
		Cliente[]lista=new Cliente[tam];
		Gimnasio g;
		
		lista[0]=c1;
		lista[1]=c2;
		lista[2]=c3;
		
		g=new Gimnasio(lista);
		
		System.out.println("Bienvenido a la gestión del gimnasio");
		
		
		
	}

}
