package modelo;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Alquiler {
	
	

	private String tipodeCarro;
	private Sedes sedeEntrega;
	private Cliente conductorAdicional;
	private AdministradorGeneral admin;
	private Categoria categoria;
	
	public Alquiler(String tipodeCarro, Sedes sedeEntrega, Cliente conductorAdicional, AdministradorGeneral admin,
			Categoria categoria) {
		super();
		this.tipodeCarro = tipodeCarro;
		this.sedeEntrega = sedeEntrega;
		this.conductorAdicional = conductorAdicional;
		this.admin = admin;
		this.categoria = categoria;
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


	public Cliente getConductorAdicional() {
		return conductorAdicional;
	}


	public void setConductorAdicional(Cliente conductorAdicional) {
		this.conductorAdicional = conductorAdicional;
	}
	
	public AdministradorGeneral getAdmin() {
		return admin;
	}


	public void setAdmin(AdministradorGeneral admin) {
		this.admin = admin;
	}



	
	private int cobroSeguros(String seguro) {
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
	
	
	private int cobroConductorAdicional(Persona conductorAdicional) {
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
	
	private int tarifaSedeDevolucion(Sedes sedeDevolucion) {
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
	public Vehiculo vehiculoAlquilar(String tipoDeCarro, Categoria categoria) {
		return categoria.vehiculoAlquilar(tipoDeCarro, categoria);
	}
	
	
	private int cobroPorDias(int dias, Categoria precioTipoDeCarro, String tipoDeCarro) {
		int precioCarro;
		if (tipoDeCarro.equals("PEQUEÑO")) {
            precioCarro = precioTipoDeCarro.getTarifaPequeños();
        } else if (tipoDeCarro.equals("SUV")) {
        	precioCarro = precioTipoDeCarro.getTarifaSUV();
        } else if (tipoDeCarro.equals("VAN")) {
        	precioCarro = precioTipoDeCarro.getTarifaVans();
        } else if (tipoDeCarro.equals("LUJO")) {
            precioCarro = precioTipoDeCarro.getTarifaLujo();
        } else {
        	precioCarro = precioTipoDeCarro.getTarifaElectricos();
        }
		int precioF = precioCarro * dias;
		return precioF ;
	}
	public int cobroFinal(String seguro, Persona conductorAdicional, Sedes sedeDevolucion, int dias, 
			Categoria precioTipoDeCarro, String tipoDeCarro) {
		int precioSeguros = cobroSeguros(seguro);
		int precioConductorAdicional = cobroConductorAdicional(conductorAdicional);
		int precioTemporada = tarifaTemporada();
		int precioSedeDevolucion = tarifaSedeDevolucion(sedeDevolucion);
		int precioPorDias = cobroPorDias(dias, precioTipoDeCarro, tipoDeCarro);
		return (precioSeguros + precioConductorAdicional + precioTemporada + precioSedeDevolucion);
		
		
		
		
		
		
		
		
		
		
	}


	


	
}
