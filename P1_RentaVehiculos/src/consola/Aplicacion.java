package consola;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import modelo.RentaVehiculos;

public class Aplicacion {
	
	private static Scanner scanner = new Scanner(System.in);
	private static RentaVehiculos rentaVehiculos = new RentaVehiculos();
	
	
	
	private static void cargarCatalogo() throws FileNotFoundException {
		System.out.println("Cargando el catalogo...");
		File archivoCatalogo = new File("data/Catalogo.txt");
		rentaVehiculos.cargarCatalogo(archivoCatalogo);
	}
	
	
	
	private static void cargarDatos() throws FileNotFoundException, IOException {
		File archivoInventario = new File("data/inventario.txt");
		File archivoSedes = new File("data(sedes.txt");
		rentaVehiculos.cargarInformacionInventario(archivoInventario, archivoSedes);
	}
	

	
	private static void mostrarCatalogo() {
		System.out.println("------Opciones de la aplicacion------");
		System.out.println("1. Cargar el catalogo");
		System.out.println("2. Realizar Reserva");
		System.out.println("3. Realizar Alquiler");
		System.out.println("4. Mostrar informacion de las sedes de la empresa");
		System.out.println("0. Salir ");
		System.out.println("Seleccione una opcion: ");
	}
	
	
	
	private static void ejecutarOpcion(int opcion) throws FileNotFoundException {
		switch (opcion) {
		case 1:
			cargarCatalogo();
			break;
		case 0:
			System.out.println("Gracias por utilizar la aplicacion!");
			break;
		default:
			System.out.println("Opcion invalida, intentelo de nuevo.");
			break;
		}
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		try {
			cargarDatos();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int opcion;
		do {
			mostrarCatalogo();
			opcion = scanner.nextInt();
			ejecutarOpcion(opcion);
		} while (opcion != 0);
	}

}
