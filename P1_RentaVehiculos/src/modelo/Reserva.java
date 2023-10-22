package modelo;

public class Reserva extends Alquiler {
	

	private int cobroInicial;
	private String fechayhoraEntrega;
	
	
	public Reserva(String tipodeCarro, Sedes sedeEntrega, Cliente conductorAdicional, Cliente cliente,
			Sedes sedeDevolucion, int dias, String seguro, AdministradorGeneral admin, int cobroInicial, String fechayhoraEntrega) {
		super(tipodeCarro, sedeEntrega, conductorAdicional, cliente, sedeDevolucion, dias, seguro, admin);
		this.cobroInicial = cobroInicial;
		this.fechayhoraEntrega = fechayhoraEntrega;
		
	}
	

	public int getCobroInicial() {
		return cobroInicial;
	}


	public void setCobroInicial(int cobroInicial) {
		this.cobroInicial = cobroInicial;
	}


	public String getFechayhoraEntrega() {
		return fechayhoraEntrega;
	}


	public void setFechayhoraEntrega(String fechayhoraEntrega) {
		this.fechayhoraEntrega = fechayhoraEntrega;
	}



}
