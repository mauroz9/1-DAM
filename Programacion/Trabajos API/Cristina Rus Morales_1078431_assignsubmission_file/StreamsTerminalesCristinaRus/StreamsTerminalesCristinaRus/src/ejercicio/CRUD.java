package ejercicio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CRUD {

	private List<Animal> listado;

	public List<Animal> getListado() {
		return listado;
	}

	public void setListado(List<Animal> listado) {
		this.listado = listado;
	}

	@Override
	public String toString() {
		return "CRUD [listado=" + listado + "]";
	}

	public CRUD(List<Animal> listado) {
		super();
		this.listado = listado;
	}
	
	public void agregarAnimal(Animal a) {
		listado.add(a);
	}
	
	//AQUÍ USAMOS EL MÉTODO count()
    public long obtenerTotalAnimales() {
        return listado.stream()
        		.count();
    }
	
    //AQUÍ USAMOS EL MÉTODO collect​(Collector<? super T,​A,​R> collector)
    public List<Animal> buscarPorTipo(int numTipo) {
		return listado.stream()
					.filter(animal -> {
						switch (numTipo) {
							case 1:
								return animal instanceof Perro;
							case 2:
								return animal instanceof Gato;
							case 3:
								return animal instanceof Conejo;
							default:
								return false;
						}
					})
					.collect(Collectors.toList());
		/* En este método estamos utilizando una expresión lambda, en la hemos metido un switch
		 * para que devuelta el animal si está instanciado del tipo que deseamos. Y para terminar
		 * usamos .collect(Collectors.toList()) para transformarlo en una lista.
		 * */
    }
    
    //AQUÍ USAMOS EL MÉTODO collect​(Supplier<R> supplier, BiConsumer<R,​? super T> accumulator, BiConsumer<R,​R> combiner)
    public List<Animal> mostrarDisponibles() {
        return listado.stream()
                .collect(
                    ArrayList::new,
                    (lista, animal) -> {
                        if (animal.isDisponible()) {
                            lista.add(animal);
                        }
                    },
                    (lista1, lista2) -> lista1.addAll(lista2)
                );
    }
    /* En este método tenemos:
     * ArrayList::new como supplier
     * Expresión lambda que añade si está disponible como accumulator
     * Otra expresión lambda que une todo como combiner
     * */
    
    //AQUÍ USAMOS EL MÉTODO min()
    public Optional<Animal> buscarMasTiempo() {
        return listado.stream()
                .min(Comparator.comparing(Animal::getFechaIngreso));
    }
    
    //AQUÍ USAMOS EL MÉTODO reduce​(BinaryOperator<T> accumulator)
    public Optional<Animal> obtenerAnimalMasJoven() {
        return listado.stream()
            .reduce((animal1, animal2) -> animal1.getEdad() < animal2.getEdad() ? animal1 : animal2);
    }
    
    
    //AQUÍ USAMOS EL MÉTODO findFirst()
    public Optional<Animal> buscarPorChip(int num) {
        return listado.stream()
                .filter(animal -> animal.getNumChip()==num)
                .findFirst();
    }
    /*En este método estamos usando el método .findFirst() para encontrar el Animal que tenga ese chip.
	* En este caso se podría usar también el .findAny() ya que solo va a haber uno (al ser como un id)
	* Hemos usado también un método intermedio para filtrar la lista y así encontrar el que tenga el mismo chip.
	*/
    
    public void eliminarAnimal(int num) {
    	Optional<Animal> animEncontrado = buscarPorChip(num);
    	//Aquí, si existe un animal con ese chip, se elimina usando las funcionalidades de los Optionals.
    	if(animEncontrado.isPresent()) {
    		listado.remove(animEncontrado.get());
    	}
    }
	
    //AQUÍ USAMOS EL MÉTODO noneMatch()
    public boolean ningunGatoColor(String color) {
        return listado.stream()
            .filter(animal -> animal instanceof Gato)
            .map(animal -> (Gato) animal)
            .noneMatch(gato -> gato.getColor().toLowerCase().equals(color.toLowerCase()));
    }
    
  //AQUÍ USAMOS EL MÉTODO anyMatch()
    public boolean algunConejoPeloLargo() {
        return listado.stream()
            .filter(animal -> animal instanceof Conejo)
            .map(animal -> (Conejo) animal)
            .anyMatch(conejo -> !conejo.isPeloCorto());
    }
    
    //AQUÍ USAMOS EL MÉTODO allMatch()
    public boolean todosLosPerrosSuperanPeso(double pesoMinimo) {
        return listado.stream()
            .filter(animal -> animal instanceof Perro)
            .map(animal -> (Perro) animal)
            .allMatch(perro -> perro.getPeso() > pesoMinimo);
    }
    
    
    public Optional<Conejo> obtenerConejoMayorPrecio() {
        return listado.stream()
            .filter(animal -> animal instanceof Conejo)
            .map(animal -> (Conejo) animal)
            .max(Comparator.comparingDouble(Conejo::getPrecioAdopcion));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
	
}
