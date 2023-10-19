package modelo;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AdministradorGeneral extends Persona {

	
	private Map<String, Integer> seguros;
	private Map<String, Integer> segurosAdicionales;
	
	
	public AdministradorGeneral(String nombre, String telefono, String fechadeNacimiento, String nacionalidad,
			File documentodeIdentidad) {
		super(nombre, telefono, fechadeNacimiento, nacionalidad, documentodeIdentidad);
		this.seguros = new HashMap<>();
		this.segurosAdicionales = new HashMap<>();
	}


	public Map<String, Integer> getSeguros() {
		return seguros;
	}


	public void setSeguros(Map<String, Integer> seguros) {
		this.seguros = seguros;
	}


	public Map<String, Integer> getSegurosAdicionales() {
		return segurosAdicionales;
	}


	public void setSegurosAdicionales(Map<String, Integer> segurosAdicionales) {
		this.segurosAdicionales = segurosAdicionales;
	}

}
