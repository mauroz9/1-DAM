package ejercicio;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Gestion {

	CRUD c;
	
	
	
    public Gestion(CRUD c) {
		super();
		this.c = c;
	}


	@Override
	public String toString() {
		return "Gestion [c=" + c + "]";
	}


	public CRUD getC() {
		return c;
	}


	public void setC(CRUD c) {
		this.c = c;
	}


	//AQUÍ USAMOS EL MÉTODO forEach()
    public void ordenarPorTiempo() {
        c.getListado().stream()
            .sorted(Comparator.comparing(Animal::getFechaIngreso))
            .forEach(animal -> System.out.println(animal)); 
    }
	/*Aquí estamos utilizando el método forEach() para imprimir del que ha pasado más tiempo al que menos
	 */
    
    
    //AQUÍ USAMOS EL MÉTODO reduce​(T identity, BinaryOperator<T> accumulator)
    public double mediaPesoPerros() {
    	
    	List<Perro> perros = c.getListado().stream()
    		    .filter(animal -> animal instanceof Perro) 
    		    .map(animal -> (Perro) animal)
    		    .collect(Collectors.toList());
    	
        double suma = perros.stream()
                .map(perro -> perro.getPeso())  
                .reduce(0.0,Double::sum
                );

        return perros.size() > 0 ? suma / perros.size() : 0.0;
    }
    /*
     * Primero, hemos separado una lista con solo perros para que se vea más claro
     * A continuación, realizamos la suma de los pesos con el método reduce()
     * Por último, devolvemos la división si existen perros en la lista.
     * */
	
    
    //AQUÍ USAMOS EL MÉTODO <U> reduce​(U identity, BiFunction<U,​? super T,​U> accumulator, BinaryOperator<U> combiner)
    public double obtenerSumaTotalPreciosAdopcion() {
        return c.getListado().stream()
            .map(animal -> animal.getPrecioAdopcion())
            .reduce(0.0, 
            	(total, precio) -> total + precio,
            	Double::sum);
    }
    
    public void agregarAnimal(Animal a) {
    	c.agregarAnimal(a);
    }
    
    public long obtenerTotalAnimales() {
    	return c.obtenerTotalAnimales();
    }
    
    public List<Animal> buscarPorTipo(int numTipo) {
    	return c.buscarPorTipo(numTipo);
    }
    
    public List<Animal> mostrarDisponibles() {
    	return c.mostrarDisponibles();
    }
    
    public Optional<Animal> buscarMasTiempo() {
    	return c.buscarMasTiempo();
    }
    
    public Optional<Animal> obtenerAnimalMasJoven() {
    	return c.obtenerAnimalMasJoven();
    }
    
    public Optional<Animal> buscarPorChip(int num) {
    	return c.buscarPorChip(num);
    }
    
    public void eliminarAnimal(int num) {
    	c.eliminarAnimal(num);
    }
    
    public boolean ningunGatoColor(String color) {
    	return c.ningunGatoColor(color);
    }
    
    public boolean algunConejoPeloLargo() {
    	return c.algunConejoPeloLargo();
    }
    
    public boolean todosLosPerrosSuperanPeso(double pesoMinimo) {
    	return c.todosLosPerrosSuperanPeso(pesoMinimo);
    }
    
    public Optional<Conejo> obtenerConejoMayorPrecio() {
    	return c.obtenerConejoMayorPrecio();
    }
    
    
}
