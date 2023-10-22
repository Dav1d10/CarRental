package modelo;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdministradorGeneral {











    private String temporada;
    private Vehiculo vehiculo;
    private Sedes sede;
    private Map<String, Integer> seguros;




    public AdministradorGeneral(String temporada) {
        this.temporada = temporada;
        this.seguros = new HashMap<>();
    }

    public String getTemporada() {
        return temporada;
    }


    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }


    public Vehiculo getVehiculo() {
        return vehiculo;
    }


    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }


    public Sedes getSede() {
        return sede;
    }


    public void setSede(Sedes sede) {
        this.sede = sede;
    }

	public Map<String, Integer> getSeguros() {
		return seguros;
	}

	public void setSeguros(Map<String, Integer> seguros) {
		this.seguros = seguros;
	}
	
	public void agregarElementoASeguros(String nombreSeguro, int precioSeguro) {
	seguros.put(nombreSeguro, precioSeguro);
	}
	public void resetearMapa() {
	seguros.clear();
	}
	
	
	
	
	
	
	
	
	
	
}
