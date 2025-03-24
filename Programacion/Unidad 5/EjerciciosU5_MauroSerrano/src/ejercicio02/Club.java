package ejercicio02;

import java.util.List;

public class Club {
	List <Socio> listaSocios;

	public Club(List<Socio> listaSocios) {
		super();
		this.listaSocios = listaSocios;
	}

	public List<Socio> getListaSocios() {
		return listaSocios;
	}

	public void setListaSocios(List<Socio> listaSocios) {
		this.listaSocios = listaSocios;
	}
	
	public void guardarSocio(Socio s) {
		listaSocios.add(s);
	}
	
	public Socio buscarSocio(int numSocio) {
		Socio socioBuscado=null;
		
		for(Socio socio : listaSocios) {
			if(socio.getNumsocio() == numSocio) {
				socioBuscado = socio;
			}
		}
		
		return socioBuscado;
	}
	
	public void mostrarSocios() {
        if (listaSocios.isEmpty()) {
            System.out.println("No hay socios registrados.");
        } else {
            for (Socio socio : listaSocios) {
                System.out.println(socio);
            }
        }
    }
	
	public boolean modificarSocio(Socio s, String nombre, String apellido, String telefono) {
		boolean conseguido = false;
		
		if(s != null) {
			conseguido = true;
			s.setNombre(nombre);
			s.setApellido(apellido);
			s.settelefono(telefono);
		}
		
		return conseguido;
	}
	
	public boolean borrarSocio(int numSocio) {
		boolean conseguido = false;
		
		Socio socioBuscado = buscarSocio(numSocio);
		
		if(socioBuscado != null) {
			conseguido = true;
			listaSocios.remove(socioBuscado);
		}
		
		return conseguido;
	}

	@Override
	public String toString() {
		return "Club [listaSocios=" + listaSocios + "]";
	}
	
}
