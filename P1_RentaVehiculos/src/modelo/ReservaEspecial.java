package modelo;

public class ReservaEspecial extends Reserva {
	
	
	private Sedes sedeOrigen;
	
	
	public ReservaEspecial(String tipodeCarro, Sedes sedeDevolucion, Cliente conductorAdicional, int cobroInicial,
			String fechayhoraEntrega, Sedes sedeEntrega, Sedes sedeOrigen) {
		super(tipodeCarro, sedeDevolucion, conductorAdicional, cobroInicial, fechayhoraEntrega, sedeEntrega);
		this.sedeOrigen = null;
		
	}
	
	

}
