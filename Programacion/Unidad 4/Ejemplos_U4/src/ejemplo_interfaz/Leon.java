package ejemplo_interfaz;

public class Leon extends Felino implements IDepredador{
	public void cazar() {
		System.out.println("Caza a la presa");
	}
	
	public void perseguir() {
		System.out.println("Corre tras la presa");
	}
	
}
