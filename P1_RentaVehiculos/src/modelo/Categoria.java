package modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	
	private List<Vehiculo> pequeños;
	private List<Vehiculo> SUV;
	private List<Vehiculo> Vans;
	private List<Vehiculo> Lujo;
	private List<Vehiculo> electricos;
	private int tarifaPequeños;
	private int tarifaSUV;
	private int tarifaVans;
	private int tarifaLujo;
	private int tarifaElectricos;
	
	
	public Categoria(int tarifaPequeños, int tarifaSUV, int tarifaVans, int tarifaLujo, int tarifaElectricos) {
		this.pequeños = new ArrayList<>();
		this.SUV = new ArrayList<>();
		this.Vans = new ArrayList<>();
		this.Lujo = new ArrayList<>();
		this.electricos =new ArrayList<>();
		this.tarifaPequeños = tarifaPequeños;
		this.tarifaSUV = tarifaSUV;
		this.tarifaVans = tarifaVans;
		this.tarifaLujo = tarifaLujo;
		this.tarifaElectricos = tarifaElectricos;
	}
	
	
	
	
	
	public int getTarifaPequeños() {
		return tarifaPequeños;
	}





	public int getTarifaSUV() {
		return tarifaSUV;
	}





	public int getTarifaVans() {
		return tarifaVans;
	}





	public int getTarifaLujo() {
		return tarifaLujo;
	}





	public int getTarifaElectricos() {
		return tarifaElectricos;
	}



	public void agregarVehiculoaCategoria(Vehiculo vehiculoPequeño, Vehiculo vehiculoSUV, Vehiculo vehiculoVans, Vehiculo vehiculoLujo, 
			Vehiculo vehiculoElectrico) {
		this.pequeños.add(vehiculoPequeño);
		this.SUV.add(vehiculoSUV);
		this.Vans.add(vehiculoVans);
		this.Lujo.add(vehiculoLujo);
		this.electricos.add(vehiculoElectrico);
	}
	

}
