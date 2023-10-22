package modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	
	private List<Vehiculo> pequeños;
	private List<Vehiculo> SUV;
	private List<Vehiculo> Vans;
	private List<Vehiculo> Lujo;
	private List<Vehiculo> electricos;
	private int tarifaPequeños = 200;
	private int tarifaSUV = 300;
	private int tarifaVans = 350;
	private int tarifaLujo = 400;
	private int tarifaElectricos = 300;
	
	
	public Categoria() {
		this.pequeños = new ArrayList<>();
		this.SUV = new ArrayList<>();
		this.Vans = new ArrayList<>();
		this.Lujo = new ArrayList<>();
		this.electricos = new ArrayList<>();
		
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



	public static void agregarVehiculoaCategoria(Categoria categoria, Vehiculo vehiculo, String categoriaNombre) {
        if (categoriaNombre.equals("PEQUEÑO")) {
            categoria.pequeños.add(vehiculo);
        } else if (categoriaNombre.equals("SUV")) {
            categoria.SUV.add(vehiculo);
        } else if (categoriaNombre.equals("VAN")) {
            categoria.Vans.add(vehiculo);
        } else if (categoriaNombre.equals("LUJO")) {
            categoria.Lujo.add(vehiculo);
        } else if (categoriaNombre.equals("ELECTRICO")) {
            categoria.electricos.add(vehiculo);
        }
    }


	public Vehiculo vehiculoAlquilar(String tipoDeCarro) {
		int indiceAEliminar = 0;
		Vehiculo vehiculo = null;
		if (tipoDeCarro.equals("PEQUEÑO")) {
			List<Vehiculo> vehiculos = getPequeños();
            vehiculo = vehiculos.get(indiceAEliminar);
            vehiculos.remove(indiceAEliminar);
        } else if (tipoDeCarro.equals("SUV")) {
        	List<Vehiculo> vehiculos = getSUV();
        	vehiculo = vehiculos.get(indiceAEliminar);
            vehiculos.remove(indiceAEliminar);
        } else if (tipoDeCarro.equals("VAN")) {
        	List<Vehiculo> vehiculos = getVans();
        	vehiculo = vehiculos.get(indiceAEliminar);
            vehiculos.remove(indiceAEliminar);
        } else if (tipoDeCarro.equals("LUJO")) {
        	List<Vehiculo> vehiculos = getLujo();
        	vehiculo = vehiculos.get(indiceAEliminar);
            vehiculos.remove(indiceAEliminar);
        } else if (tipoDeCarro.equals("ELECTRICO")) {
        	List<Vehiculo> vehiculos = getElectricos();
        	vehiculo = vehiculos.get(indiceAEliminar);
            vehiculos.remove(indiceAEliminar);
     
        }
	return vehiculo;
    }
	


	public List<Vehiculo> getPequeños() {
		return pequeños;
	}





	public void setPequeños(List<Vehiculo> pequeños) {
		this.pequeños = pequeños;
	}





	public List<Vehiculo> getSUV() {
		return SUV;
	}





	public void setSUV(List<Vehiculo> sUV) {
		SUV = sUV;
	}





	public List<Vehiculo> getVans() {
		return Vans;
	}





	public void setVans(List<Vehiculo> vans) {
		Vans = vans;
	}





	public List<Vehiculo> getLujo() {
		return Lujo;
	}





	public void setLujo(List<Vehiculo> lujo) {
		Lujo = lujo;
	}





	public List<Vehiculo> getElectricos() {
		return electricos;
	}





	public void setElectricos(List<Vehiculo> electricos) {
		this.electricos = electricos;
	}





	public void setTarifaPequeños(int tarifaPequeños) {
		this.tarifaPequeños = tarifaPequeños;
	}





	public void setTarifaSUV(int tarifaSUV) {
		this.tarifaSUV = tarifaSUV;
	}





	public void setTarifaVans(int tarifaVans) {
		this.tarifaVans = tarifaVans;
	}





	public void setTarifaLujo(int tarifaLujo) {
		this.tarifaLujo = tarifaLujo;
	}





	public void setTarifaElectricos(int tarifaElectricos) {
		this.tarifaElectricos = tarifaElectricos;
	}
	

}
