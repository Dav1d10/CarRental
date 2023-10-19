package consola;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import modelo.RentaVehiculos;

public class Aplicacion {
	
	private static RentaVehiculos rentaVehiculos = new RentaVehiculos();
	
	
	private static void cargarDatos() throws FileNotFoundException, IOException {
		File archivoInventario = new File("data/inventario.txt");
		File archivoSedes = new File("data(sedes.txt");
		rentaVehiculos.cargarInformacionInventario(archivoInventario, archivoSedes);
	}
	

	
	private static void mostrarCatalogo() {
		System.out.println("-----Catalogo de Vehiculos-----");
		System.out.println("1. Mostrar Inventario");
		System.out.println("2. Realizar Reserva");
		System.out.println("3. Realizar Alquiler");
		System.out.println("4. Mostrar información de las sedes de la empresa");
		System.out.println("0. Salir ");
		System.out.println("Seleccione una opción: ");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mostrarCatalogo();
	}

}
