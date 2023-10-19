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
	
	
	public int precioSeguros(String seguro) {
		int total = 0;
		if (seguro.contains("1")) {
			total += 75;
		}
		else if (seguro.contains("2")) {
			total += 150;
		}
		else if (seguro.contains("3")) {
			total += 200;
		}
		else if (seguro.contains("4")) {
			total += 300;
		}
		else if (seguro.contains("5")) {
			total += 500;
		}
		return total;
	}
	
	
	public int cobroConductorAdicional(Persona conductorAdicional) {
		return 0;
	
	}
	
	
	public void cobroFinal() {
		
	}
	

}
