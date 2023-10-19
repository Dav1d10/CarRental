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


	public String getPlaca() {
		return this.placa;
	}


	public String getMarca() {
		return this.marca;
	}


	public String getModelo() {
		return this.modelo;
	}


	public String getColor() {
		return this.color;
	}


	public String getTipodeTransmicion() {
		return this.tipodeTransmicion;
	}


	public String getCapacidadPersonas() {
		return this.capacidadPersonas;
	}


	public String getUbicacion() {
		return this.ubicacion;
	}


	public Map<String, String> getAlquilado() {
		return alquilado;
	}


	public void setAlquilado(Map<String, String> alquilado) {
		this.alquilado = alquilado;
	}


	public Map<String, String> getNoAlquilado() {
		return noAlquilado;
	}


	public void setNoAlquilado(Map<String, String> noAlquilado) {
		this.noAlquilado = noAlquilado;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public void setTipodeTransmicion(String tipodeTransmicion) {
		this.tipodeTransmicion = tipodeTransmicion;
	}


	public void setCapacidadPersonas(String capacidadPersonas) {
		this.capacidadPersonas = capacidadPersonas;
	}


	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}


	
	
	
	
	
	

}
