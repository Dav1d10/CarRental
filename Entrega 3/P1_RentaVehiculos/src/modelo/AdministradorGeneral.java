package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdministradorGeneral {










	private String nombreArchivo = "data/adminGral.txt";
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
    
    public void eliminarContenidoArchivo() {
        try {
            FileWriter fileWriter = new FileWriter(nombreArchivo, false);
            fileWriter.write(""); 
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void guardarArchivoEnMapa() {
        try {
            FileWriter fileWriter = new FileWriter(nombreArchivo);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Map.Entry<String, Integer> entry : seguros.entrySet()) {
                String linea = entry.getKey() + ";" + entry.getValue();
                bufferedWriter.write(linea);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void cargarMapaDesdeArchivo() {
        try {
            FileReader fileReader = new FileReader(nombreArchivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    String nombreSeguro = partes[0];
                    int precio = Integer.parseInt(partes[1]);
                    seguros.put(nombreSeguro, precio);
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
	eliminarContenidoArchivo();
	}
	
	
          	
	
	
	
	
	
	
	
}
