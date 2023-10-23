package modelo;

public class Reserva extends Alquiler {
	
	
	private String fechayhoraEntrega;
	
	
	public Reserva(String tipodeCarro, Sedes sedeEntrega, Persona conductorAdicional, Cliente cliente,
			Sedes sedeDevolucion, int dias, String seguro, String fechayhoraEntrega, AdministradorGeneral admin, Categoria categoria) {
		super(tipodeCarro, sedeEntrega, conductorAdicional, cliente, sedeDevolucion, dias, seguro, admin, categoria);
	}

	
	public String toString() {
		return "Reserva[" +
		           "tipodeCarro='" + tipodeCarro + '\'' +
		           ", sedeEntrega=" + sedeEntrega +
		           ", cliente=" + cliente +
		           ", conductorAdicional=" + conductorAdicional +
		           ", sedeDevolucion=" + sedeDevolucion +
		           ", dias=" + dias +
		           ", seguro='" + seguro + '\'' +
		           ", fechayhoraEntrega=" + fechayhoraEntrega + '\'' +
		           "]";
	}
	

	
	public String getFechayhoraEntrega() {
		return fechayhoraEntrega;
	}


	public void setFechayhoraEntrega(String fechayhoraEntrega) {
		this.fechayhoraEntrega = fechayhoraEntrega;
	}
	
	
	public double cobroInicial() {
		double cobro = cobroFinal() * 0.30;
		return cobro;
	}



}
