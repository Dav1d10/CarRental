package modelo;

public class ReservaEspecial extends Reserva {
	

	private Sedes sedeOrigen;
	
	
	public ReservaEspecial(String tipodeCarro, Sedes sedeEntrega, Cliente conductorAdicional, Cliente cliente,
			Sedes sedeDevolucion, int dias, String seguro, String fechayhoraEntrega, Sedes sedeOrigen, AdministradorGeneral admin, Categoria categoria) {
		super(tipodeCarro, sedeEntrega, conductorAdicional, cliente, sedeDevolucion, dias, seguro, fechayhoraEntrega, admin, categoria);
		this.sedeOrigen = sedeOrigen;
	}
	
	
	
	public Sedes getSedeOrigen() {
		return sedeOrigen;
	}


	public void setSedeOrigen(Sedes sedeOrigen) {
		this.sedeOrigen = sedeOrigen;
	}
	
	

}
