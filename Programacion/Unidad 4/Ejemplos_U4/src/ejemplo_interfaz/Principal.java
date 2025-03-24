package ejemplo_interfaz;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Anfibio a=new Anfibio();
		Rana r=new Rana();
		Anfibio r1=new Rana();
		IPresa ip=new Rana();
		Felino f=new Felino();
		Leon l=new Leon();
		Felino f1=new Leon();
		IDepredador id=new Leon();
		
		//Probar metodos
		
		ip.observar();
		r.huir();
		id.perseguir();
		l.cazar();
		
		
	
	}

}
