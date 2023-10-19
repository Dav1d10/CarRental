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


	public String getNumeroLicencia() {
		return numeroLicencia;
	}


	public void setNumeroLicencia(String numeroLicencia) {
		this.numeroLicencia = numeroLicencia;
	}


	public String getPaisExp() {
		return paisExp;
	}


	public void setPaisExp(String paisExp) {
		this.paisExp = paisExp;
	}


	public File getImagenLicencia() {
		return imagenLicencia;
	}


	public void setImagenLicencia(File imagenLicencia) {
		this.imagenLicencia = imagenLicencia;
	}


	public String getFechadeVencimiento() {
		return fechadeVencimiento;
	}


	public void setFechadeVencimiento(String fechadeVencimiento) {
		this.fechadeVencimiento = fechadeVencimiento;
	}
	
	
	

}
