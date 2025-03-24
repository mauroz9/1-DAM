package ejemplo_polimorfismo;

public class OperacionesFiguras {
	
	
	public double calcularAreaFigura(Figura f) {
		return f.calcularArea();
	}
	
	public double calcularSumaAreas(Figura [] lista) {
		double suma=0;
		
		for(int i=0;i<lista.length;i++) {
			//Esta no deberiamos --> suma=+lista[i].calcularArea();
			if(lista[i] instanceof Circulo) {
				((Circulo)lista[i]).mostrarRadianes(); //Casteamos como circulo para poder llamar al metodo de radianes (metodo unicamente existente en esa clase hija)
			}
			
			suma=suma+calcularAreaFigura(lista[i]);
		}
		
		return suma;
	}

}
