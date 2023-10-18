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

}
