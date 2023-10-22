package archivo;

import java.io.BufferedWriter;
import java.io.File;
import modelo.Vehiculo;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Properties;

public class ArchivoInventario {
	public ArchivoInventario() {
			
	}
	private String placa;
	private String marca;
	private String modelo;
	private String color;
	private String transmision;
	private String capacidad;
	private String tipo;
	private String sede;
	private String nombreArchivo = "data/inventario.txt"; 
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTransmision() {
		return transmision;
	}
	public void setTransmision(String transmision) {
		this.transmision = transmision;
	}
	public String getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public void agregarArchivo(String placa, String marca, String modelo, String color, String transmision,
			String capacidad, String tipo, String sede) {
		String datos = placa + ";" + marca + ";" + modelo + ";" + color + ";" + transmision + ";" + capacidad + ";" + tipo + ";" + sede;
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            writer.write(datos);
            writer.newLine(); 
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
	}
		
	
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}