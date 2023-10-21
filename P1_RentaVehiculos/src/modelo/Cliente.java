package modelo;

import java.io.File;

public class Cliente extends Persona {
	
	private DatosLicencia datosLicencia;
	

	public Cliente(String nombre, String telefono, String fechadeNacimiento, String nacionalidad,
			File documentodeIdentidad, DatosLicencia datosLicencia) {
		super(nombre, telefono, fechadeNacimiento, nacionalidad, documentodeIdentidad);
		this.datosLicencia = datosLicencia;
	}
	
	
	public String toString() {
		return "Cliente[" +
		           "nombre='" + nombre + '\'' +
		           ", telefono=" + telefono +
		           ", fechadeNacimiento=" + fechadeNacimiento +
		           ", nacionalidad=" + nacionalidad +
		           ", documentodeIdentidad=" + documentodeIdentidad +
		           ", datosLicencia=" + datosLicencia + 
		           "]";
		}
}
	
	
	
	
	






