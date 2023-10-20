package modelo;

public class Reserva extends Alquiler {
	

	private static AdministradorGeneral admin;
	private int cobroInicial;
	private String fechayhoraEntrega;
	private Sedes sedeEntrega;
	
	
	
	public Reserva(String tipodeCarro, Sedes sedeEntrega, Cliente conductorAdicional, AdministradorGeneral admin,
			Categoria categoria) {
		super(tipodeCarro, sedeEntrega, conductorAdicional, admin, categoria);
		// TODO Auto-generated constructor stub
	
		this.cobroInicial = cobroInicial;
		this.fechayhoraEntrega = fechayhoraEntrega;
		this.sedeEntrega = null;
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


	public Sedes getSedeEntrega() {
		return sedeEntrega;
	}


	public void setSedeEntrega(Sedes sedeEntrega) {
		this.sedeEntrega = sedeEntrega;
	}
	
	
	

}
