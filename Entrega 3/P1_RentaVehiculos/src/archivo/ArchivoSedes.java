package archivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ArchivoSedes {
   
	
    private String nombreSede;
    private String Ubicacion;
    private String horarioAtencion;
    private String nombreArchivo = "data/sedes.txt";
    
    
	public ArchivoSedes() {
		
	}


	public String getNombreSede() {
		return nombreSede;
	}


	public void setNombreSede(String nombreSede) {
		this.nombreSede = nombreSede;
	}


	public String getUbicacion() {
		return Ubicacion;
	}


	public void setUbicacion(String ubicacion) {
		Ubicacion = ubicacion;
	}


	public String getHorarioAtencion() {
		return horarioAtencion;
	}


	public void setHorarioAtencion(String horarioAtencion) {
		this.horarioAtencion = horarioAtencion;
	}


	public String getNombreArchivo() {
		return nombreArchivo;
	}


	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
	
	public void agregarArchivo(String nombreSede, String ubicacion, String horarioAtencion) {
		String datos = nombreSede + ";" + ubicacion + ";" + horarioAtencion;
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            writer.write(datos);
            writer.newLine(); 
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
	}
}