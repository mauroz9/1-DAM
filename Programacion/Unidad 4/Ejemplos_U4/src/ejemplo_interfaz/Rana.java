package ejemplo_interfaz;

public class Rana extends Anfibio implements IPresa, IDepredador{
	public void observar() {
		System.out.println("Observa el entorno 360º");
	}
	
	public void huir() {
		System.out.println("Salto triple");
	}

	public void cazar() {
		
	}

	public void perseguir() {
		
	}
	
}
