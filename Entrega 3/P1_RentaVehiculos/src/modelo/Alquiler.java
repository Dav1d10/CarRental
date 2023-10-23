package modelo;
import java.util.regex.Pattern;
import java.util.Map;
import java.util.regex.Matcher;
public class Alquiler {
	
	

	
	protected String tipodeCarro;
	protected Sedes sedeEntrega;
	protected Cliente cliente;
	protected Persona conductorAdicional;
	private Categoria categoria;
	protected Sedes sedeDevolucion;
	protected int dias;
	protected String seguro;
	private AdministradorGeneral admin;
	
	
	
	public Alquiler(String tipodeCarro, Sedes sedeEntrega, Persona conductorAdicional, Cliente cliente,
			Sedes sedeDevolucion, int dias, String seguro, AdministradorGeneral admin, Categoria categoria) {
		super();
		this.tipodeCarro = tipodeCarro;
		this.sedeEntrega = sedeEntrega;
		this.cliente = cliente;
		this.conductorAdicional = conductorAdicional;
		this.sedeDevolucion = sedeDevolucion;
		this.dias = dias;
		this.seguro = seguro;
		this.admin = admin;
		this.categoria = categoria;
				}
	
	
	public String toString() {
		return "Alquiler[" +
		           "tipodeCarro='" + tipodeCarro + '\'' +
		           ", sedeEntrega=" + sedeEntrega +
		           ", cliente=" + cliente +
		           ", conductorAdicional=" + conductorAdicional +
		           ", sedeDevolucion=" + sedeDevolucion +
		           ", dias=" + dias +
		           ", seguro='" + seguro + '\'' +
		           "]";
	}
	
	
	public String getTipodeCarro() {
		return tipodeCarro;
	}


	public void setTipodeCarro(String tipodeCarro) {
		this.tipodeCarro = tipodeCarro;
	}


	public Sedes getSedeEntrega() {
		return sedeEntrega;
	}


	public void setSedeEntrega(Sedes sedeEntrega) {
		this.sedeEntrega = sedeEntrega;
	}


	public Persona getConductorAdicional() {
		return conductorAdicional;
	}


	public void setConductorAdicional(Cliente conductorAdicional) {
		this.conductorAdicional = conductorAdicional;
	}
	


	
	private int cobroSeguros() {
		Map<String, Integer> mapa = admin.getSeguros();
		int precioF = 0;
		for (Integer valor : mapa.values()) {
            precioF += valor;
	}	
	return precioF;
	}
	
	private int cobroConductorAdicional() {
		int precioF = 0;
		if (conductorAdicional != null) {
			precioF = 100;
		}
		else {
			precioF = 0;
		}
		return precioF;
	
	}
	
	private int tarifaTemporada() {
		String temporada = admin.getTemporada();
		int precioF = 0;
		if (temporada.equals("ALTA")) {
			precioF = 50;
					
		}
		else if (temporada.equals("BAJA")) {
			precioF = 0;
	}
		else {
			precioF = 25;
		}
	return precioF;
	}
	
	private int tarifaSedeDevolucion() {
		String nombreSedeDevolucion = sedeDevolucion.getNombreSede();
		String nombreSedeEntrega = sedeEntrega.getNombreSede();
		int precioF = 0;
		if (!nombreSedeDevolucion.equals(nombreSedeEntrega)) {
			String sedeDsinLetras = nombreSedeDevolucion.replaceAll("[^0-9-]", "");
			String sedeEsinLetras = nombreSedeEntrega.replaceAll("[^0-9-]", "");
			int sedeD = Integer.parseInt(sedeDsinLetras);
			int sedeE = Integer.parseInt(sedeEsinLetras);
				if (sedeD > sedeE) {
					precioF = sedeD-sedeE;
				}
				else {
					precioF = sedeE - sedeD;
				}
		}
		
		return precioF;
	}

	
	
	private int cobroPorDias() {
		int precioCarro;
		if (tipodeCarro.equals("PEQUEÑO")) {
            precioCarro = categoria.getTarifaPequeños();
        } else if (tipodeCarro.equals("SUV")) {
        	precioCarro = categoria.getTarifaSUV();
        } else if (tipodeCarro.equals("VAN")) {
        	precioCarro = categoria.getTarifaVans();
        } else if (tipodeCarro.equals("LUJO")) {
            precioCarro = categoria.getTarifaLujo();
        } else {
        	precioCarro = categoria.getTarifaElectricos();
        }
		int precioF = precioCarro * dias;
		return precioF ;
	}
	
	
	public int cobroFinal() {
		int precioSeguros = cobroSeguros();
		int precioConductorAdicional = cobroConductorAdicional();
		int precioTemporada = tarifaTemporada();
		int precioSedeDevolucion = tarifaSedeDevolucion();
		int precioPorDias = cobroPorDias();
		return (precioSeguros + precioConductorAdicional + precioTemporada + precioSedeDevolucion + precioPorDias);
		
		
		
		
		
		
		
		
		
		
	}


	


	
}
