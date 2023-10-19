package modelo;

public class Sedes {
	
	private String nombreSede;
	private String ubicacion;
	private String horariosAtencion;
	
	
	public Sedes(String nombreSede, String ubicacion, String horariosAtencion) {
		this.nombreSede = nombreSede;
		this.ubicacion = ubicacion;
		this.horariosAtencion = horariosAtencion;
	}


	public String getNombreSede() {
		return nombreSede;
	}


	public void setNombreSede(String nombreSede) {
		this.nombreSede = nombreSede;
	}


	public String getUbicacion() {
		return ubicacion;
	}


	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}


	public String getHorariosAtencion() {
		return horariosAtencion;
	}


	public void setHorariosAtencion(String horariosAtencion) {
		this.horariosAtencion = horariosAtencion;
	}
	
	

}
