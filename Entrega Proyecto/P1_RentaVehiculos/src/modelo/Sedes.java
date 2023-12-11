package modelo;

import java.util.Objects;

public class Sedes {
	
	private String nombreSede;
	private String ubicacion;
	private String horariosAtencion;
	
	
	public Sedes(String nombreSede, String ubicacion, String horariosAtencion) {
		this.nombreSede = nombreSede;
		this.ubicacion = ubicacion;
		this.horariosAtencion = horariosAtencion;
	}
	
	
	public String toString() {
		return "Sede[" +
		           "nombreSede='" + nombreSede + '\'' +
		           ", ubicacion=" + ubicacion +
		           ", horariosAtencion=" + horariosAtencion +
		           "]";
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
	
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Sedes sede = (Sedes) obj;
        return Objects.equals(nombreSede, sede.nombreSede) &&
               Objects.equals(ubicacion, sede.ubicacion) &&
               Objects.equals(horariosAtencion, sede.horariosAtencion);
    }

	
    @Override
    public int hashCode() {
        return Objects.hash(nombreSede, ubicacion, horariosAtencion);
    }
	
	

}
