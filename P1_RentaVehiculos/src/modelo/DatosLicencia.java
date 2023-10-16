package modelo;

import java.io.File;

public class DatosLicencia {
	
	private String numeroLicencia;
	private String paisExp;
	private File imagenLicencia;
	private String fechadeVencimiento;
	
	
	public DatosLicencia(String numeroLicencia, String paisExp, File imagenLicencia, String fechadeVencimiento) {
		this.numeroLicencia = numeroLicencia;
		this.paisExp = paisExp;
		this.imagenLicencia = imagenLicencia;
		this.fechadeVencimiento = fechadeVencimiento;
	}
	
	
	

}
