package ejemplo_1;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double base=1000.0;
		
		Trabajador t= new Trabajador("Angel", "Jefe de Estudios");
		Empleado e=new Empleado("Miguel", "Profesor", 1000.0, 15.0);
		Consultor c=new Consultor("Luismi", "Tutor", 26, 50);
		
		System.out.println(t);
		System.out.println(e);
		System.out.println(c);
		
		//Llamadas a métodos
		
		System.out.println(t.calcularPaga(base));
		System.out.println(e.calcularPaga(base));
		System.out.println(c.calcularPaga(base));
		System.out.println(c.calcularDias(8));
		
		
	}
}