package modelo;

import java.io.File;

public class Persona {
	
	protected String nombre;
	protected String telefono;
	protected String fechadeNacimiento;
	protected String nacionalidad;
	protected File documentodeIdentidad;
	protected DatosLicencia datosLicencia;
	
	
	public Persona(String nombre, String telefono, String fechadeNacimiento, String nacionalidad,
			File documentodeIdentidad, DatosLicencia datosLicencia) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.fechadeNacimiento = fechadeNacimiento;
		this.nacionalidad = nacionalidad;
		this.documentodeIdentidad = documentodeIdentidad;
		this.datosLicencia = datosLicencia;
	}
	
	
	public String toString() {
		return "Persona[" +
		           "nombre='" + nombre + '\'' +
		           ", telefono=" + telefono +
		           ", fechadeNacimiento=" + fechadeNacimiento +
		           ", nacionalidad=" + nacionalidad +
		           ", documentodeIdentidad=" + documentodeIdentidad +
		           ", datosLicencia=" + datosLicencia + 
		           "]";
		}
	

	public String getNombre() {
		return this.nombre;
	}


	public String getTelefono() {
		return this.telefono;
	}


	public String getFechadeNacimiento() {
		return this.fechadeNacimiento;
	}


	public String getNacionalidad() {
		return this.nacionalidad;
	}


	public File getDocumentodeIdentidad() {
		return this.documentodeIdentidad;
	}
	
	
	
	

}


