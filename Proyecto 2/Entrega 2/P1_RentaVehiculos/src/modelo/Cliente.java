package modelo;

import java.io.File;

public class Cliente extends Persona {
	
	private DatosTarjetaCredito tarjetaCredito;
	
	
	public Cliente(String nombre, String telefono, String fechadeNacimiento, String nacionalidad,
			File documentodeIdentidad, DatosLicencia datosLicencia, DatosTarjetaCredito tarjetaCredito) {
		super(nombre, telefono, fechadeNacimiento, nacionalidad, documentodeIdentidad, datosLicencia);
		this.tarjetaCredito = tarjetaCredito;
	}
	
	
	public String toString() {
		return "Cliente[" +
		           "nombre='" + nombre + '\'' +
		           ", telefono=" + telefono +
		           ", fechadeNacimiento=" + fechadeNacimiento +
		           ", nacionalidad=" + nacionalidad +
		           ", documentodeIdentidad=" + documentodeIdentidad +
		           ", datosLicencia=" + datosLicencia + 
		           ", datosTarjetaCredito=" + tarjetaCredito +
		           "]";
		}


	
	public DatosTarjetaCredito getTarjetaCredito() {
		return tarjetaCredito;
	}
	
	
}
	
	
	
	
	






