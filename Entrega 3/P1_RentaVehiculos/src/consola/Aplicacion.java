package consola;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import archivo.ArchivoLog;
import archivo.ArchivoPagos;
import modelo.AdministradorGeneral;
import modelo.Alquiler;
import modelo.Categoria;
import modelo.Cliente;
import modelo.DatosLicencia;
import modelo.DatosTarjetaCredito;
import modelo.Persona;
import modelo.RentaVehiculos;
import modelo.Reserva;
import modelo.Sedes;
import modelo.Vehiculo;

import java.io.Console;

public class Aplicacion {
	
	private static Scanner scanner = new Scanner(System.in);
	private static RentaVehiculos rentaVehiculos = new RentaVehiculos();
	
	
	
	private static Sedes elegirSedeEntrega() {
	    File archivoSedes = new File("data/sedes.txt");
	    try {
	        List<String> sedesInfo = rentaVehiculos.mostrarSedes(archivoSedes);
	        System.out.print("Ingrese el nombre de la sede en la que desea recoger el vehiculo: ");
	        String nombreSedeBuscada = scanner.nextLine().toUpperCase();
	        for (String info : sedesInfo) {
	            String[] partes = info.split(" - ");
	            if (partes.length == 3) {
	            	String nombreSede = partes[0];
	            	if (nombreSede.equals(nombreSedeBuscada)) {
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
	
	
	
	private static Sedes elegirSedeDevolucion() {
	    File archivoSedes = new File("data/sedes.txt");
	    try {
	        List<String> sedesInfo = rentaVehiculos.mostrarSedes(archivoSedes);
	        System.out.print("Ingrese el nombre de la sede en la que desea devolver el vehiculo: ");
	        String nombreSedeBuscada = scanner.nextLine().toUpperCase();
	        for (String info : sedesInfo) {
	            String[] partes = info.split(" - ");
	            if (partes.length == 3) {
	            	String nombreSede = partes[0];
	            	if (nombreSede.equals(nombreSedeBuscada)) {
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
		String tieneConductorAdicional = scanner.nextLine();
		if (tieneConductorAdicional.equals("Si")) {
			System.out.println("Ingrese el nombre del conductor: ");
			String nombreConductor = scanner.nextLine();
			System.out.println("Ingrese el telefono del conductor: ");
			String telefonoConductor = scanner.nextLine();
			System.out.println("Ingrese la fecha de nacimiento del conductor: ");
			String fechadeNacimientoConductor = scanner.nextLine();
			System.out.println("Ingrese la nacionalidad del conductor: ");
			String nacionalidadConductor = scanner.nextLine();
			System.out.println("Ingrese la direccion del documento de identidad del conductor: ");
			String documentodeIdentidadConductor = scanner.nextLine();
			File documentoIdentidadConductor = new File(documentodeIdentidadConductor);
			System.out.println("Ingrese el numero de licencia del conductor: ");
			String numeroLicenciaConductor = scanner.nextLine();
			System.out.println("Ingrese el pais de expedicion de la licencia del conductor: ");
			String paisExpConductor = scanner.nextLine();
			System.out.println("Ingrese la direccion de la licencia del conductor: ");
			String licenciadeConductor = scanner.nextLine();
			File licenciaConductor = new File(licenciadeConductor);
			System.out.println("Ingrese la fecha de vencimiento de la licencia del conductor: ");
			String fechadeVencimientoLicenciaConductor = scanner.nextLine();
			return new Persona(nombreConductor, telefonoConductor, fechadeNacimientoConductor, nacionalidadConductor, 
					documentoIdentidadConductor, new DatosLicencia(numeroLicenciaConductor, paisExpConductor, licenciaConductor, 
							fechadeVencimientoLicenciaConductor));
		} else {
			return null;
		}
	}
	
	
	private static Cliente nuevoCliente() {
        System.out.println("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese su telefono: ");
        String telefono = scanner.nextLine();
        System.out.println("Ingrese su fecha de nacimiento: ");
        String fechadeNacimiento = scanner.nextLine();
        System.out.println("Ingrese su nacionalidad: ");
        String nacionalidad = scanner.nextLine();
        System.out.println("Ingrese la direccion de su documento de identidad: ");
        String documentodeIdentidad = scanner.nextLine();
        File documentoIdentidad = new File(documentodeIdentidad);
        System.out.println("Ingrese el numero de su licencia: ");
        String numeroLicencia = scanner.nextLine();
        System.out.println("Ingrese el pais de expedicion de la licencia: ");
        String paisExp = scanner.nextLine();
        System.out.println("Ingrese la direccion de la licencia: ");
        String licencia = scanner.nextLine();
        File licenciaCliente = new File(licencia);
        System.out.println("Ingrese la fecha de vencimiento de la licencia: ");
        String fechadeVencimientoLicencia = scanner.nextLine();
        System.out.println("Ingrese el numero de su tarjeta de credito: ");
        String numeroTarjeta = scanner.nextLine();
        System.out.println("Ingrese la fecha de vencimiento de su tarjeta de credito: ");
        String fechaVencimiento = scanner.nextLine();
        System.out.println("Ingrese su cvv: ");
        String cvv = scanner.nextLine();
        System.out.println("Ingrese su banco: ");
        String banco = scanner.nextLine();
        DatosLicencia datosLicencia = new DatosLicencia(numeroLicencia, paisExp, licenciaCliente, fechadeVencimientoLicencia);
        DatosTarjetaCredito tarjetaCredito = new DatosTarjetaCredito(numeroTarjeta, fechaVencimiento, cvv, banco);
        Cliente cliente = new Cliente(nombre, telefono, fechadeNacimiento, nacionalidad, documentoIdentidad, datosLicencia, tarjetaCredito);
        ArchivoPagos.agregarArchivo(tarjetaCredito);
        return cliente;
    }
	
	

	private static String mostrarSeguros() {
		Map<String, Integer> mapa = rentaVehiculos.getSeguros();
		int numero = 1;
		for (Map.Entry<String, Integer> entrada : mapa.entrySet()) {
            String clave = entrada.getKey();
            Integer valor = entrada.getValue();
            System.out.println(numero + "." + " " + clave + " con un costo de: " + valor);
            numero ++;
		}
        System.out.println("Ingrese el numero del seguro que desee: ");
        String seguro = scanner.nextLine();
        
        return seguro;
    }
	
	
	private static String iniciarAlquiler() throws FileNotFoundException, IOException {
		System.out.println("Iniciando Alquiler...");
		Cliente cliente = nuevoCliente();
		System.out.println("Ingrese el tipo de carro que desea alquilar (PEQUENO, SUV, VAN, LUJO, ELECTRICO): ");
		String tipodeCarro = scanner.nextLine().toUpperCase();
		Sedes sedeEntrega = elegirSedeEntrega();
		Sedes sedeDevolucion = elegirSedeDevolucion();
		Persona conductorAdicional = quiereConductorAdicional();
		System.out.println("Ingrese la cantidad de dias por los que quiere alquilar el vehiculo: ");
		String diasString = scanner.nextLine();
        int dias = Integer.parseInt(diasString);
        String seguro = mostrarSeguros();
        List <Alquiler> alquileres = rentaVehiculos.generarAlquiler(tipodeCarro, sedeEntrega, conductorAdicional, cliente, sedeDevolucion, dias, seguro);
        rentaVehiculos.guardarAlquileres(alquileres);
        Vehiculo carroAsignado = rentaVehiculos.asignarCarro(tipodeCarro);
        String lineaAEliminar = rentaVehiculos.lineaString(carroAsignado);
        rentaVehiculos.eliminarLinea(lineaAEliminar);
        ArchivoLog.agregarLog(cliente, carroAsignado);
		return "La marca del carro asignado es " + carroAsignado.getMarca() + ", de color " + carroAsignado.getColor() + ", modelo " + carroAsignado.getModelo() +
		", con una capacidad de " + carroAsignado.getCapacidadPersonas() + " personas," +" de placa " + carroAsignado.getPlaca();
	}
	
	
	
	private static String iniciarReserva() throws FileNotFoundException, IOException {
		System.out.println("Iniciando Reserva...");
		Cliente cliente = nuevoCliente();
		System.out.println("Ingrese el tipo de carro que desea reservar (PEQUENO, SUV, VAN, LUJO, ELECTRICO): ");
		String tipodeCarro = scanner.nextLine().toUpperCase();
		Sedes sedeEntrega = elegirSedeEntrega();
		Sedes sedeDevolucion = elegirSedeDevolucion();
		Persona conductorAdicional = quiereConductorAdicional();
		System.out.println("Ingrese la cantidad de dias por los que quiere alquilar el vehiculo: ");
		String diasString = scanner.nextLine();
        int dias = Integer.parseInt(diasString);
        String seguro = mostrarSeguros();
        System.out.println("Ingrese la fecha y la hora a la que va a entregar el vehiculo: ");
        String fechayhoraEntrega = scanner.nextLine();
        System.out.println("Gracias por realizar la reserva con nosotros, a continuacion se muestra el carro que se le asigna y el precio: ");
        List <Reserva> reservas = rentaVehiculos.generarReserva(tipodeCarro, sedeEntrega, conductorAdicional, cliente, sedeDevolucion, dias, seguro, fechayhoraEntrega);
        rentaVehiculos.guardarReservas(reservas);
        Vehiculo carroAsignado = rentaVehiculos.asignarCarro(tipodeCarro);
        String lineaAEliminar = rentaVehiculos.lineaString(carroAsignado);
        rentaVehiculos.eliminarLinea(lineaAEliminar);
        ArchivoLog.agregarLog(cliente, carroAsignado);
		return "La marca del carro asignado es " + carroAsignado.getMarca() + ", de color " + carroAsignado.getColor() + ", modelo " + carroAsignado.getModelo() +
		", con una capacidad de " + carroAsignado.getCapacidadPersonas() + " personas," +" de placa " + carroAsignado.getPlaca();
	}
	
	
	private static void cargarDatos() throws FileNotFoundException, IOException {
		rentaVehiculos.setAdministradorGeneral();
		File archivoInventario = new File("data/inventario.txt");
		File archivoSedes = new File("data/sedes.txt");
		rentaVehiculos.cargarInformacionInventario(archivoInventario, archivoSedes);
	}
	
	
	/*
	private static void manejarSeguros() {
		System.out.println("Ingrese el numero de los seguros que va a agregar: ");
		short numIteraciones = scanner.nextShort();
		for (int i = 1; i <= numIteraciones; i++) {
			System.out.println("Ingrese el nombre del Seguro");
			String nombreSeguro = scanner.nextLine();
			System.out.println("Ingrese el valor de Seguro");
			String valorSeguroS = scanner.nextLine();
			int valorSeguro = Integer.parseInt(valorSeguroS);
		    rentaVehiculos.cambiarPropiedadesCarro(nombreSeguro, valorSeguro, null);
		    
		}
		rentaVehiculos.guardarArchivoEnMapa();
	}
	*/
	
	
	private static void manejarSeguros() {
		System.out.println("Ingrese el nombre del seguro: ");
		String nombreSeguro = scanner.nextLine();
		System.out.println("Ingrese el precio de seguro: ");
		String valorSeguro = scanner.nextLine();
		int valor = Integer.parseInt(valorSeguro);
	    rentaVehiculos.AgregarSeguro(nombreSeguro, valor);
	    rentaVehiculos.AgregarSeguroaMapa();
	    System.out.println("El seguro fue agregado exitosamente. ");
	}
	
	
	private static void resetearSeguros() {
		rentaVehiculos.resetearMapa();
	}
	
	
	private static void manejarTemporada() {
		System.out.println("Ingrese la temporada nueva");
		System.out.println("1. Alta");
		System.out.println("2. Media");
		System.out.println("3. Baja");
		String valor = scanner.nextLine();
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
	
	
	private static void agregarCarroNuevo(){
		System.out.println("Ingrese la placa ");
		String placa = scanner.nextLine();
		System.out.println("Ingrese la marca ");
		String marca = scanner.nextLine();
		System.out.println("Ingrese el modelo ");
		String modelo = scanner.nextLine();
		System.out.println("Ingrese el color ");
		String color = scanner.nextLine();
		System.out.println("Ingrese el tipo de transmicion ");
		String tipoTransmicion = scanner.nextLine();
		System.out.println("Ingrese la capacidad de personas ");
		String capacidad = scanner.nextLine();
		System.out.println("Ingrese el tipo de carro ");
		String tipoDeCarro = scanner.nextLine();
		System.out.println("Ingrese la sede ");
		String sede = scanner.nextLine();
		rentaVehiculos.agregarArchivo(placa, marca, modelo, color, tipoTransmicion, capacidad, tipoDeCarro, sede);
	}
	
	private static void devolverVehiculo() {
		System.out.println("Ingrese la placa ");
		String placa = scanner.nextLine();
		System.out.println("Ingrese la marca ");
		String marca = scanner.nextLine();
		System.out.println("Ingrese el modelo ");
		String modelo = scanner.nextLine();
		System.out.println("Ingrese el color ");
		String color = scanner.nextLine();
		System.out.println("Ingrese el tipo de transmicion ");
		String tipoTransmicion = scanner.nextLine();
		System.out.println("Ingrese la capacidad de personas ");
		String capacidad = scanner.nextLine();
		System.out.println("Ingrese el tipo de carro ");
		String tipoDeCarro = scanner.nextLine();
		System.out.println("Ingrese la sede ");
		String sede = scanner.nextLine();
		rentaVehiculos.agregarArchivo(placa, marca, modelo, color, tipoTransmicion, capacidad, tipoDeCarro, sede);
	}
	
	
	private static void agregarSedeNueva(){
		System.out.println("Ingrese el nombre: ");
		String nombreSede = scanner.nextLine();
		System.out.println("Ingrese la ubicacion: ");
		String ubicacion = scanner.nextLine();
		System.out.println("Ingrese los horarios de atencion: ");
		String horariosAtencion = scanner.nextLine();
		rentaVehiculos.agregarSede(nombreSede, ubicacion, horariosAtencion);
	}
	
	
	private static void mostrarCatalogo() {
		System.out.println("------Opciones de la aplicacion------");
		System.out.println("1. Realizar Alquiler");
		System.out.println("2. Realizar Reserva");
		System.out.println("0. Salir ");
		System.out.println("Seleccione una opcion: ");
	}
	
	
	
	private static void mostrarCatalogoAdmin() {
		System.out.println("------Opciones de administrador------");
		System.out.println("1. Manejar Seguros");
		System.out.println("2. Elegir temporada");
		System.out.println("3. Cambiar ambos");
		System.out.println("4. Agregar Carro Nuevo");
		System.out.println("5. Agregar Sede Nueva");
		System.out.println("0. Salir");
		System.out.println("Seleccione una opcion: ");
	}
	
	private static void mostrarCatalogoEmpleado() {
		System.out.println("------Opciones de Empleado------");
		System.out.println("1. Manejar Seguros");
	}
	
	private static void ejecutarOpcionAdmin(int opcion) throws FileNotFoundException {
		switch (opcion) {
		case 1:
			manejarSeguros();
			break;
		case 2:
			manejarTemporada();
			break;
		case 3:
			manejarSeguros();
			manejarTemporada();
			break;
		case 4:
			agregarCarroNuevo();
			break;
		case 5:
			agregarSedeNueva();
			break;
		case 0:
			System.out.println("Los cambios fueron realizados.");
			break;
		default:
			System.out.println("Opcion invalida, intentelo de nuevo.");
			break;
			
		}
	}
	
	private static void ejecutarOpcionEmpleado(int opcion) throws FileNotFoundException {
		switch (opcion) {
		case 1:
			devolverVehiculo();
			break;
		case 0:
			System.out.println("Los cambios fueron realizados.");
			break;
		default:
			System.out.println("Opcion invalida, intentelo de nuevo.");
			break;
			
		}
	}
	
	private static void ejecutarOpcion(int opcion) throws IOException {
		switch (opcion) {
		case 1:
			String msjF = iniciarAlquiler();
			System.out.println(msjF);
			break;
		case 2:
			String msj = iniciarReserva();
			System.out.println(msj);
			break;
		case 0:
			System.out.println("Gracias por utilizar la aplicacion!");
			break;
		default:
			System.out.println("Opcion invalida, intentelo de nuevo.");
			break;
		}
	}
	

	
	public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in); 

        try {
            cargarDatos();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int opcion = 1;
        do {
            System.out.println("Ya es usuario de DGA Rental? ");
            System.out.println("1. Si \n2. No");
            String r = scanner.nextLine();
            
            if (r.equals("1")) {
                System.out.println("-------------Ingreso De Usuarios-------------");
                System.out.println("Ingrese su usuario ");
                String user = scanner.nextLine();
                System.out.println("Ingrese su contraseña");
                String pass = scanner.nextLine();
                boolean s = rentaVehiculos.autenticarUsuario(user, pass);
                if (s == true) {
                    if (rentaVehiculos.esAdmin(pass)) {
                        mostrarCatalogoAdmin();
                        opcion = scanner.nextInt();
                        scanner.nextLine(); 
                        ejecutarOpcionAdmin(opcion);
                    } else if (rentaVehiculos.esEmpleado(pass)){
                    	mostrarCatalogoEmpleado();
                    	
                    
                    } else {
                        mostrarCatalogo();
                        opcion = scanner.nextInt();
                        scanner.nextLine(); 
                        ejecutarOpcion(opcion);
                    }
                }
            }else if (r.equals("2")) {
                System.out.println("-------------Registro De Usuarios-------------");
                System.out.println("Ingrese el usuario: ");
                String user = scanner.nextLine();
                System.out.println("Ingrese su contraseña");
                String pass = scanner.nextLine();
                rentaVehiculos.registrarUsuario(user, pass);
            } else {
                System.out.println("Opcion no valida");
            }
        } while (opcion != 0);
        
        scanner.close(); 
    }
}