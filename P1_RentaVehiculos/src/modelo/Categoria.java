package modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	
	private static List<Vehiculo> pequeños;
	private static List<Vehiculo> SUV;
	private static List<Vehiculo> Vans;
	private static List<Vehiculo> Lujo;
	private static List<Vehiculo> electricos;
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



	public static void agregarVehiculoaCategoria(Vehiculo vehiculo, String categoriaNombre) {
        if (categoriaNombre.equals("PEQUEÑO")) {
            pequeños.add(vehiculo);
        } else if (categoriaNombre.equals("SUV")) {
            SUV.add(vehiculo);
        } else if (categoriaNombre.equals("VAN")) {
        	System.out.println("ENTRA");
            System.out.println(Vans);
        } else if (categoriaNombre.equals("LUJO")) {
            Lujo.add(vehiculo);
        } else if (categoriaNombre.equals("ELECTRICO")) {
            electricos.add(vehiculo);
        }
    }


	public Vehiculo vehiculoAlquilar(String tipoDeCarro) {
		int indiceAEliminar = 0;
		Vehiculo vehiculo = null;
		System.out.println(tipoDeCarro.equals("SUV"));
		System.out.println(getSUV());
		System.out.println(getLujo());
		System.out.println(getSUV());
		System.out.println(getSUV());
		if (tipoDeCarro.equals("PEQUEÑO")) {
			List<Vehiculo> vehiculos = getPequeños();
			
			if (!vehiculos.isEmpty()) {
	            vehiculo = vehiculos.get(indiceAEliminar);
	            vehiculos.remove(indiceAEliminar);
			}
			else {
				System.out.println("No quedan vehiculos de este tipo. ");
			}
        } else if (tipoDeCarro.equals("SUV")) {
        	List<Vehiculo> vehiculos = getSUV();
            if (!vehiculos.isEmpty()) {
	            vehiculo = vehiculos.get(indiceAEliminar);
	            vehiculos.remove(indiceAEliminar);
			}
			else {
				System.out.println("No quedan vehiculos de este tipo. ");
			}
        } else if (tipoDeCarro.equals("VAN")) {
        	List<Vehiculo> vehiculos = getVans();
            if (!vehiculos.isEmpty()) {
	            vehiculo = vehiculos.get(indiceAEliminar);
	            vehiculos.remove(indiceAEliminar);
			}
			else {
				System.out.println("No quedan vehiculos de este tipo. ");
			}
        } else if (tipoDeCarro.equals("LUJO")) {
        	List<Vehiculo> vehiculos = getLujo();
            if (!vehiculos.isEmpty()) {
	            vehiculo = vehiculos.get(indiceAEliminar);
	            vehiculos.remove(indiceAEliminar);
			}
			else {
				System.out.println("No quedan vehiculos de este tipo. ");
			}
        } else if (tipoDeCarro.equals("ELECTRICO")) {
        	List<Vehiculo> vehiculos = getElectricos();
            if (!vehiculos.isEmpty()) {
	            vehiculo = vehiculos.get(indiceAEliminar);
	            vehiculos.remove(indiceAEliminar);
			}
			else {
				System.out.println("No quedan vehiculos de este tipo. ");
			}
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
