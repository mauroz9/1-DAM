package ejercicio;

public class Trastero implements Comparable <Trastero>{
	private double capacidad;
	private String direccion;
	private int numRas;
	private double precio;
	private boolean libre;
	
	public Trastero(double capacidad, String direccion, int numRas, double precio, boolean libre) {
		super();
		this.capacidad = capacidad;
		this.direccion = direccion;
		this.numRas = numRas;
		this.precio = precio;
		this.libre = libre;
	}

	public double getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getNumRas() {
		return numRas;
	}

	public void setNumRas(int numRas) {
		this.numRas = numRas;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isLibre() {
		return libre;
	}

	public void setLibre(boolean libre) {
		this.libre = libre;
	}

	@Override
	public String toString() {
		return "Trastero [capacidad=" + capacidad + ", direccion=" + direccion + ", numRas=" + numRas + ", precio="
				+ precio + ", libre=" + libre + "]";
	}

	@Override
	public int compareTo(Trastero t) {
	
//		Aquí se hace lo mismo pero con los compare de las variables
////		int comp = Integer.compare(this.numRas, t.numRas);
////		if( comp == 0) {
////			return Double.compare(this.precio, t.precio);
////		}
		
		if(this.numRas < t.numRas) {
			return -1;
		}else {
			if(this.numRas > t.numRas){
				return 1;
			} else {
				if(this.precio < t.precio) {
					return -1;
				}else {
					if(this.precio > t.precio) {
						return 1;
					}else {
						return 0;
					}
				}
			}
		}
	}
	
	
}
