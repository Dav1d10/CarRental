package modelo;

public class Alquiler {
	
	private String tipodeCarro;
	private Sedes sedeDevolucion;
	private Cliente conductorAdicional;
	
	
	public Alquiler(String tipodeCarro, Sedes sedeDevolucion, Cliente conductorAdicional) {
		this.tipodeCarro = tipodeCarro;
		this.sedeDevolucion = sedeDevolucion;
		this.conductorAdicional = null;
	}


	public String getTipodeCarro() {
		return tipodeCarro;
	}


	public void setTipodeCarro(String tipodeCarro) {
		this.tipodeCarro = tipodeCarro;
	}


	public Sedes getSedeDevolucion() {
		return sedeDevolucion;
	}


	public void setSedeDevolucion(Sedes sedeDevolucion) {
		this.sedeDevolucion = sedeDevolucion;
	}


	public Cliente getConductorAdicional() {
		return conductorAdicional;
	}


	public void setConductorAdicional(Cliente conductorAdicional) {
		this.conductorAdicional = conductorAdicional;
	}
	
	

}
