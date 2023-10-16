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
	
	

}
