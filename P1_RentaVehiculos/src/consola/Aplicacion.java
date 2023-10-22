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
import modelo.DatosTarjetaCredito;
import modelo.Persona;
import modelo.RentaVehiculos;
import modelo.Sedes;
import modelo.Vehiculo;
import archivo.IngresoUsuario;
import archivo.RegistroUsuario;
import archivo.IngresoUsuario;

import java.io.Console;

public class Aplicacion {
	
	private static Scanner scanner = new Scanner(System.in);
	private static RegistroUsuario registroUsuario = new RegistroUsuario();
	private static RentaVehiculos rentaVehiculos = new RentaVehiculos();
	private static IngresoUsuario ingresoUsuario = new IngresoUsuario();
	
	
	
	private static void cargarCatalogo() throws FileNotFoundException {
		System.out.println("Cargando el catalogo...");
		File archivoCatalogo = new File("data/Catalogo.txt");
		rentaVehiculos.cargarCatalogo(archivoCatalogo);
		rentaVehiculos.setAdministradorGeneral("BAJA");
	}
	
	
	private static Sedes elegirSedeEntrega() {
	    File archivoSedes = new File("data/sedes.txt");
	    try {
	        List<String> sedesInfo = rentaVehiculos.mostrarSedes(archivoSedes);
	        System.out.print("Ingrese el nombre de la sede en la que desea recoger el vehiculo: ");
	        String nombreSedeBuscada = scanner.next();
	        for (String info : sedesInfo) {
	            String[] partes = info.split(" - ");
	            if (partes.length == 3) {
	            	String nombreSede = partes[0];
	            	if (nombreSede.equals(nombreSedeBuscada)) {
	            		//System.out.println("entra");
	            		//System.out.println(nombreSede + " - " + partes[1] + " - " + partes[2]);
	            		String ubicacionSede = partes[1];
	            		String horariosSede = partes[2];
	            		return new Sedes(nombreSede, ubicacionSede, horariosSede);
	            }
	        }
	    }
	    System.out.println("No se encontro la sede con el nombre especificado.");
	    } catch (FileNotFoundException e) {
	        System.out.println("No se pudo abrir el archivo de sedes.");
	    }
	    return null; 
	}
	
	
	
	private static List<String> prueba() throws FileNotFoundException {
		File archivo = new File("data/sedes.txt");
		return rentaVehiculos.mostrarSedes(archivo);
	}
 
	  
	        
	private static Sedes elegirSedeDevolucion() {
	    File archivoSedes = new File("data/sedes.txt");
	    try {
	        List<String> sedesInfo = rentaVehiculos.mostrarSedes(archivoSedes);
	        System.out.print("Ingrese el nombre de la sede en la que desea devolver el vehiculo: ");
	        String nombreSedeBuscada = scanner.next();
	        for (String info : sedesInfo) {
	            String[] partes = info.split(" - ");
	            if (partes.length == 3) {
	            	String nombreSede = partes[0];
	            	if (nombreSede.equals(nombreSedeBuscada)) {
	            		//System.out.println("entra");
	            		//System.out.println(nombreSede + " - " + partes[1] + " - " + partes[2]);
	            		String ubicacionSede = partes[1];
	            		String horariosSede = partes[2];
	            		return new Sedes(nombreSede, ubicacionSede, horariosSede);
	            }
	        }
	    }
	    System.out.println("No se encontro la sede con el nombre especificado.");
	    } catch (FileNotFoundException e) {
	        System.out.println("No se pudo abrir el archivo de sedes.");
	    }
	    return null; 
	}
	
	
	private static Persona quiereConductorAdicional() {
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
			return new Persona(nombreConductor, telefonoConductor, fechadeNacimientoConductor, nacionalidadConductor, 
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
		System.out.println("Ingrese el numero de su tarjeta de credito: ");
		String numeroTarjeta = scanner.next();
		System.out.println("Ingrese la fecha de vencimiento de su tarjeta de credito: ");
		String fechaVencimiento = scanner.next();
		System.out.println("Ingrese su cvv: ");
		String cvv = scanner.next();
		System.out.println("Ingrese su banco: ");
		String banco = scanner.next();
		return new Cliente(nombre, telefono, fechadeNacimiento, nacionalidad, documentoIdentidad, 
				new DatosLicencia(numeroLicencia, paisExp, licenciaCliente, fechadeVencimientoLicencia), new DatosTarjetaCredito(numeroTarjeta, 
						fechaVencimiento, cvv, banco));
	}
	
	

	private static String mostrarSeguros() {
		Map<String, Integer> mapa = rentaVehiculos.getSeguros();
		int numero = 1;
		for (Map.Entry<String, Integer> entrada : mapa.entrySet()) {
            String clave = entrada.getKey();
            Integer valor = entrada.getValue();
            System.out.println(numero +" " + clave + " El precio es: " + valor);
		}
        System.out.println("Ingrese la(s) opcion(es) de seguro(s) que desea: ");
        String seguro = scanner.next();
        return seguro;
    }
	
	
	private static int iniciarAlquiler() {
		System.out.println("Iniciando Alquiler...");
		Cliente cliente = nuevoCliente();
		System.out.println("Ingrese el tipo de carro que desea alquilar: ");
		String tipodeCarro = scanner.next();
		Sedes sedeEntrega = elegirSedeEntrega();
		Sedes sedeDevolucion = elegirSedeDevolucion();
		Persona conductorAdicional = quiereConductorAdicional();
		System.out.println("Ingrese la cantidad de dias por los que quiere alquilar el vehiculo: ");
		String diasString = scanner.next();
        int dias = Integer.parseInt(diasString);
        String seguro = mostrarSeguros();
        System.out.println("Gracias por realizar el alquiler con nosotros, a continuacion se muestra el registro de su alquiler: ");
		return rentaVehiculos.generarAlquiler(tipodeCarro, sedeEntrega, conductorAdicional, cliente, sedeDevolucion, dias, seguro);
	}
	
	
	private static void cargarDatos() throws FileNotFoundException, IOException {
		File archivoInventario = new File("data/inventario.txt");
		File archivoSedes = new File("data/sedes.txt");
		rentaVehiculos.cargarInformacionInventario(archivoInventario, archivoSedes);
		rentaVehiculos.setAdministradorGeneral("BAJA");;
	}
	
	private static void manejarSeguros() {
		System.out.println("Ingrese el numero de los seguros que va a agregar: ");
		String numeroIteraciones = scanner.next();
		short numIteraciones = Short.parseShort(numeroIteraciones);
		for (int i = 1; i <= numIteraciones; i++) {
			System.out.println("Ingrese el nombre del Seguro");
			String nombreSeguro = scanner.next();
			System.out.println("Ingrese el valor de Seguro");
			String valorSeguroS = scanner.next();
			int valorSeguro = Integer.parseInt(valorSeguroS);
		    rentaVehiculos.cambiarPropiedadesCarro(nombreSeguro, valorSeguro, null);
		}
	}
	private static void resetearSeguros() {
		rentaVehiculos.resetearMapa();
	}
	
	private static void manejarTemporada() {
		System.out.println("Ingrese la temporada nueva");
		System.out.println("1. Alta");
		System.out.println("2. Media");
		System.out.println("3. Baja");
		String valor = scanner.next();
		short valorT = Short.parseShort(valor);
		if (valorT == 1) {
			rentaVehiculos.cambiarPropiedadesCarro(null, 0, "ALTA");
		
		}
		else if (valorT == 2) {
			rentaVehiculos.cambiarPropiedadesCarro(null, 0, "MEDIA");
		}
		else if (valorT == 3) {
			rentaVehiculos.cambiarPropiedadesCarro(null, 0, "BAJA");
		}
		else {
			System.out.println("Opcion no valida!");
		}
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
	
	
	
	private static void mostrarCatalogoAdmin() {
		System.out.println("------Opciones de administrador------");
		System.out.println("1. Manejar Seguros");
		System.out.println("2. Elegir temporada");
		System.out.println("3. Cambiar ambos");
		System.out.println("0. Salir");
		System.out.println("Seleccione una opcion: ");
	}
	
	
	
	private static void ejecutarOpcionAdmin(int opcion) throws FileNotFoundException {
		switch (opcion) {
		case 1:
			resetearSeguros();
			manejarSeguros();
			
			break;
		case 2:
			manejarTemporada();
			break;
		case 3:
			manejarSeguros();
			manejarTemporada();
		case 0:
			System.out.println("Los cambios fueron realizados.");
			break;
		default:
			System.out.println("Opcion invalida, intentelo de nuevo.");
			break;
		}
	}
	
	
	
	private static void ejecutarOpcion(int opcion) throws FileNotFoundException {
		switch (opcion) {
		case 1:
			cargarCatalogo();
			break;
		case 2:
			int precioF = iniciarAlquiler();
			System.out.println("El precio del alquiler es de: " + precioF);
			break;
		case 3:
			elegirSedeEntrega();
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
		int opcion = 1;
		do {
			System.out.println("Ya es usuario de DGA Rental? ");
			System.out.println("1. Si \n 2. No");
			String r = scanner.next();
			
			if (r.equals("1")) {
				System.out.println("-------------Ingreso De Usuarios-------------");
				System.out.println("Ingrese su usuario ");
				String user = scanner.next();
				System.out.println("Ingrese su contraseña");
				String pass = scanner.next();
				boolean s = ingresoUsuario.autenticarUsuario(user, pass);
				if (s==true){
					if (ingresoUsuario.esAdmin(pass)) {
						mostrarCatalogoAdmin();
						opcion = scanner.nextInt();
						ejecutarOpcionAdmin(opcion);
					}
					else {
						mostrarCatalogo();
						opcion = scanner.nextInt();
						ejecutarOpcion(opcion);
					}
				}
			} else if (r.equals("2")){
				System.out.println("-------------Registro De Usuarios-------------");
				System.out.println("Ingrese el usuario: ");
				String user = scanner.next();
				System.out.println("Ingrese su contraseña");
				String pass = scanner.next();
				registroUsuario.registrarUsuario(user, pass);
			}
			else {
				System.out.println("Opcion no valida");
			}
		} while (opcion != 0);
	}

}