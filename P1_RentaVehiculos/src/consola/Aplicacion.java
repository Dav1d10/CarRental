package consola;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import modelo.AdministradorGeneral;
import modelo.Categoria;
import modelo.Cliente;
import modelo.RentaVehiculos;
import modelo.Sedes;
import java.io.Console;

public class Aplicacion {
	
	private static Scanner scanner = new Scanner(System.in);
	private static RentaVehiculos rentaVehiculos = new RentaVehiculos();
	
	
	
	private static void cargarCatalogo() throws FileNotFoundException {
		System.out.println("Cargando el catalogo...");
		File archivoCatalogo = new File("data/Catalogo.txt");
		rentaVehiculos.cargarCatalogo(archivoCatalogo);
	}
	
	
	
	private static void iniciarAlquiler(Cliente conductorAdicional, AdministradorGeneral admin, Sedes sedeDevolucion, int dias, String seguro) {
		System.out.println("Iniciando Alquiler...");
		System.out.println("Ingrese su nombre: ");
		String nombre = scanner.next();
		System.out.println("Ingrese su telefono: ");
		String telefono = scanner.next();
		System.out.println("Ingrese su fecha de nacimiento: ");
		String fechadeNacimiento = scanner.next();
		System.out.println("Ingrese su nacionalidad: ");
		String nacionalidad = scanner.next();
		System.out.println("Ingrese la direccion de su documento de identidad: ");
		String documentodeIdentidad = scanner.next();
		File documentoIdentidad = new File(documentodeIdentidad);
		Cliente cliente = new Cliente(nombre, telefono, fechadeNacimiento, nacionalidad, documentoIdentidad);
		System.out.println("Ingrese el tipo de carro que desea alquilar: ");
		String tipodeCarro = scanner.next();

		File archivoSedes = new File("data/sedes.txt");
		rentaVehiculos.mostrarSedes(archivoSedes);
		String sedeEntrega = scanner.next();
		System.out.println("Ingrese la cate");
		rentaVehiculos.generarAlquiler(cliente, tipodeCarro, sedeEntrega, conductorAdicional, admin, categoria, sedeDevolucion, dias, seguro);
	}
	
	private static void cargarDatos() throws FileNotFoundException, IOException {
		File archivoInventario = new File("data/inventario.txt");
		File archivoSedes = new File("data/sedes.txt");
		rentaVehiculos.cargarInformacionInventario(archivoInventario, archivoSedes);
	}
	

	
	private static void mostrarCatalogo() {
		System.out.println("------Opciones de la aplicacion------");
		System.out.println("1. Cargar el catalogo");
		System.out.println("2. Realizar Alquiler");
		System.out.println("3. Realizar Reserva");
		System.out.println("4. Mostrar informacion de las sedes de la empresa");
		System.out.println("0. Salir ");
		System.out.println("Seleccione una opcion: ");
	}
	
	
	
	private static void ejecutarOpcion(int opcion) throws FileNotFoundException {
		switch (opcion) {
		case 1:
			cargarCatalogo();
			break;
		case 2:
			String tipodeCarro = 
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
