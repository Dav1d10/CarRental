package modelo;

import java.io.File;

public class Empleado extends Persona {
	
	private String idEmpleado;

	public Empleado(String nombre, String telefono, String fechadeNacimiento, String nacionalidad,
			File documentodeIdentidad, String idEmpleado) {
		super(nombre, telefono, fechadeNacimiento, nacionalidad, documentodeIdentidad);
		this.idEmpleado = idEmpleado;
	}

}
