package modelo;

import java.util.HashMap;
import java.util.Map;

public class Vehiculo {
	
	private String placa;
	private String marca;
	private String modelo;
	private String color;
	private String tipodeTransmicion;
	private String capacidadPersonas;
	private String ubicacion;
	private Map<String, String> alquilado;
	private Map<String, String> noAlquilado;
	
	
	public Vehiculo(String placa, String marca, String modelo, String color, String tipodeTransmicion, String capacidadPersonas, 
			String ubicacion) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.tipodeTransmicion = tipodeTransmicion;
		this.capacidadPersonas = capacidadPersonas;
		this.ubicacion = ubicacion;
		this.alquilado = new HashMap<>();
		this.noAlquilado = new HashMap<>();
	}
	
	
	
	

}
