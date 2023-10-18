package modelo;

import java.io.File;

public class AdministradorLocal extends Persona {
	
	private String administraSede;
	
	public AdministradorLocal(String nombre, String telefono, String fechadeNacimiento, String nacionalidad,
			File documentodeIdentidad, String administraSede) {
		super(nombre, telefono, fechadeNacimiento, nacionalidad, documentodeIdentidad);
		this.administraSede = administraSede; 
	}

}
