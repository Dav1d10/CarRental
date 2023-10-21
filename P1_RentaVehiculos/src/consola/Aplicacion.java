package consola;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import modelo.AdministradorGeneral;
import modelo.Categoria;
import modelo.Cliente;
import modelo.DatosLicencia;
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
	
	
	private static Sedes elegirSedeEntrega() {
	    File archivoSedes = new File("data/sedes.txt");
	    try {
	        List<String> sedesInfo = rentaVehiculos.mostrarSedes(archivoSedes);
	        System.out.print("Ingrese el nombre de la sede en la que desea recoger el vehiculo: ");
	        String nombreSedeBuscada = scanner.next();
	        if (sedesInfo.get(0).equals(nombreSedeBuscada)) {
	        	System.out.println("entra");
	        	System.out.println(sedesInfo.get(0) + " - " + sedesInfo.get(1) + " - " + sedesInfo.get(2));
	            String nombreSede = sedesInfo.get(0);
	        	String ubicacionSede = sedesInfo.get(1);
	            String horariosSede = sedesInfo.get(2);
	            return new Sedes(nombreSede, ubicacionSede, horariosSede);
	            } 
	        else {
	        	System.out.println("Error en el formato de la informacion de la sede.");
	            }
	        } catch (FileNotFoundException e) {
		        System.out.println("No se pudo abrir el archivo de sedes.");
	    } 
	    return null;
	    }
	 
	
	private static Sedes elegirSedeDevolucion() {
	    File archivoSedes = new File("data/sedes.txt");
	    try {
	        List<String> sedesInfo = rentaVehiculos.mostrarSedes(archivoSedes);
	        System.out.print("Ingrese el nombre de la sede en la que desea devolver el vehiculo: ");
	        String nombreSedeBuscada = scanner.next();
	        if (sedesInfo.get(0).equals(nombreSedeBuscada)) {
	        	System.out.println("entra");
	        	System.out.println(sedesInfo.get(0) + " - " + sedesInfo.get(1) + " - " + sedesInfo.get(2));
	            String nombreSede = sedesInfo.get(0);
	        	String ubicacionSede = sedesInfo.get(1);
	            String horariosSede = sedesInfo.get(2);
	            return new Sedes(nombreSede, ubicacionSede, horariosSede);
	            } 
	        else {
	        	System.out.println("Error en el formato de la informacion de la sede.");
	        	return null;
	            }
	        } catch (FileNotFoundException e) {
		        System.out.println("No se pudo abrir el archivo de sedes.");
		        return null;
	    } 
	    }
	
	
	private static Cliente quiereConductorAdicional() {
		System.out.println("Tiene un conductor adicional? ");
		String tieneConductorAdicional = scanner.next();
		if (tieneConductorAdicional.equals("Si")) {
			System.out.println("Ingrese el nombre del conductor: ");
			String nombreConductor = scanner.next();
			System.out.println("Ingrese el telefono del conductor: ");
			String telefonoConductor = scanner.next();
			System.out.println("Ingrese la fecha de nacimiento del conductor: ");
			String fechadeNacimientoConductor = scanner.next();
			System.out.println("Ingrese la nacionalidad del conductor: ");
			String nacionalidadConductor = scanner.next();
			System.out.println("Ingrese la direccion del documento de identidad del conductor: ");
			String documentodeIdentidadConductor = scanner.next();
			File documentoIdentidadConductor = new File(documentodeIdentidadConductor);
			System.out.println("Ingrese el numero de licencia del conductor: ");
			String numeroLicenciaConductor = scanner.next();
			System.out.println("Ingrese el pais de expedicion de la licencia del conductor: ");
			String paisExpConductor = scanner.next();
			System.out.println("Ingrese la direccion de la licencia del conductor: ");
			String licenciadeConductor = scanner.next();
			File licenciaConductor = new File(licenciadeConductor);
			System.out.println("Ingrese la fecha de vencimiento de la licencia del conductor: ");
			String fechadeVencimientoLicenciaConductor = scanner.next();
			return new Cliente(nombreConductor, telefonoConductor, fechadeNacimientoConductor, nacionalidadConductor, 
					documentoIdentidadConductor, new DatosLicencia(numeroLicenciaConductor, paisExpConductor, licenciaConductor, 
							fechadeVencimientoLicenciaConductor));
		} else {
			return null;
		}
	}
	
	
	private static Cliente nuevoCliente() {
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
		System.out.println("Ingrese el numero de su licencia: ");
		String numeroLicencia = scanner.next();
		System.out.println("Ingrese el pais de expedicion de la licencia: ");
		String paisExp = scanner.next();
		System.out.println("Ingrese la direccion de la licencia: ");
		String licencia = scanner.next();
		File licenciaCliente = new File(licencia);
		System.out.println("Ingrese la fecha de vencimiento de la licencia: ");
		String fechadeVencimientoLicencia = scanner.next();
		return new Cliente(nombre, telefono, fechadeNacimiento, nacionalidad, documentoIdentidad, 
				new DatosLicencia(numeroLicencia, paisExp, licenciaCliente, fechadeVencimientoLicencia));
	}

	private static void mostrarSeguros() {
        System.out.println("1. Responsabilidad Civil Suplementaria (SLI o LIS)");
        System.out.println("2. Protección de Responsabilidad del Arrendatario (TP/PLI)");
        System.out.println("3. Colisión/Daños (CDW o LDW)");
        System.out.println("4. Cobertura de Pérdida por Daños (LDW/CDW con Franquicia)");
        System.out.println("5. Seguro Personal de Accidentes (PAI/PEC)");
        System.out.println("Ingrese la opcion(es) de seguro(s) que desea");
    }
	
	
	private static void iniciarAlquiler() {
		System.out.println("Iniciando Alquiler...");
		Cliente cliente = nuevoCliente();
		System.out.println("Ingrese el tipo de carro que desea alquilar: ");
		String tipodeCarro = scanner.next();
		Sedes sedeEntrega = elegirSedeEntrega();
		Sedes sedeDevolucion = elegirSedeDevolucion();
		Cliente conductorAdicional = quiereConductorAdicional();
		String diasString = scanner.next();
        int dias = Integer.parseInt(diasString);
        mostrarSeguros();
        String seguro = scanner.next();
		rentaVehiculos.generarAlquiler(tipodeCarro, sedeEntrega, conductorAdicional, cliente, sedeDevolucion, dias, seguro);
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
			iniciarAlquiler();
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
