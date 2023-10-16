package modelo;

public class Reserva extends Alquiler {
	

	private int cobroInicial;
	private String fechayhoraEntrega;
	private Sedes sedeEntrega;
	
	
	public Reserva(String tipodeCarro, Sedes sedeDevolucion, Cliente conductorAdicional, int cobroInicial, String fechayhoraEntrega,
			Sedes sedeEntrega) {
		super(tipodeCarro, sedeDevolucion, conductorAdicional);
		this.cobroInicial = cobroInicial;
		this.fechayhoraEntrega = fechayhoraEntrega;
		this.sedeEntrega = null;
	}
	
	
	

}
