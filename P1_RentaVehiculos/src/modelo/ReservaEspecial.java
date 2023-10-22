package modelo;

public class ReservaEspecial extends Reserva {
	

	private Sedes sedeOrigen;
	
	
	public ReservaEspecial(String tipodeCarro, Sedes sedeEntrega, Cliente conductorAdicional, Cliente cliente,
			Sedes sedeDevolucion, int dias, String seguro, AdministradorGeneral admin, String fechayhoraEntrega, Sedes sedeOrigen) {
		super(tipodeCarro, sedeEntrega, conductorAdicional, cliente, sedeDevolucion, dias, seguro, admin,
				fechayhoraEntrega);
		this.sedeOrigen = sedeOrigen;
	}
	
	
	
	public Sedes getSedeOrigen() {
		return sedeOrigen;
	}


	public void setSedeOrigen(Sedes sedeOrigen) {
		this.sedeOrigen = sedeOrigen;
	}
	
	

}
