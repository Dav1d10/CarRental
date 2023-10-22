package modelo;

public class DatosTarjetaCredito {
	
	private String numeroTarjeta;
	private String fechaVencimiento;
	private String cvv;
	private String banco;
	
	
	public DatosTarjetaCredito(String numeroTarjeta, String fechaVencimiento, String cvv, String banco) {
		this.numeroTarjeta = numeroTarjeta;
		this.fechaVencimiento = fechaVencimiento;
		this.cvv = cvv;
		this.banco = banco;
	}
	
	
	public String toString() {
		return "DatosTarjetaCredito[" +
		           "numeroTarjeta='" + numeroTarjeta + '\'' +
		           ", fechaVencimiento=" + fechaVencimiento +
		           ", cvv=" + cvv +
		           ", banco=" + banco +
		           "]";
		}


	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}


	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}


	public String getFechaVencimiento() {
		return fechaVencimiento;
	}


	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}


	public String getCvv() {
		return cvv;
	}


	public void setCvv(String cvv) {
		this.cvv = cvv;
	}


	public String getBanco() {
		return banco;
	}


	public void setBanco(String banco) {
		this.banco = banco;
	}
	
	
	
	

}
