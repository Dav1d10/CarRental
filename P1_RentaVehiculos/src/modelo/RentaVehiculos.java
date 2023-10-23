package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import archivo.ArchivoInventario;
import archivo.ArchivoPagos;
import archivo.ArchivoSedes;
import administradorLocal.IngresoUsuario;
import administradorLocal.RegistroUsuario;

public class RentaVehiculos {
	
	
	private List<Vehiculo> Vehiculos;
	private List<Sedes> Sedes;
	private Categoria categoria;
	private List<Alquiler> alquileres;
	private AdministradorGeneral admin;
	private Empleado empleado;
	private List<Reserva> reservas;
	private ArchivoInventario archivoInventario;
	private ArchivoSedes archivoSedes;
	private static RegistroUsuario registroUsuario = new RegistroUsuario();
	private static IngresoUsuario ingresoUsuario = new IngresoUsuario();
	
	
	
	public RentaVehiculos() {
		this.Vehiculos = new ArrayList<>();
		this.Sedes = new ArrayList<>();
		this.alquileres = new ArrayList<>();
		this.admin = null;
		this.empleado = new Empleado();
		this.reservas = new ArrayList<>();
		this.archivoInventario = new ArchivoInventario();
		this.archivoSedes = new ArchivoSedes();
		this.categoria = new Categoria();
	}

	public AdministradorGeneral setAdministradorGeneral() {
		String temporada = "polla";
		AdministradorGeneral administrador = new AdministradorGeneral(temporada);
        return this.admin = administrador;
        
	}
	
	public List<Vehiculo> getVehiculos() {
		return this.Vehiculos;
	}

	public List<Sedes> getSedes() {
		return this.Sedes;
	}
	
	
	public void cargarCatalogo(File archivoCatalogo) throws FileNotFoundException {
		Scanner scan = new Scanner(archivoCatalogo);
		while(scan.hasNextLine()) {
			String linea = scan.nextLine();
			System.out.println(linea);
		}
		scan.close();
	}
	
	
	public void elegirSede(int indice, String input) {
		if (input.equals("1")) {
			
		}
	}
	
	
	public List<String> mostrarSedes(File archivoSedes) throws FileNotFoundException {
		List<String> sedes = new ArrayList<>();
		Scanner scan = new Scanner(archivoSedes);
		while(scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			if (partes.length == 3) {
				String nombreSede = partes[0];
				String direccionSede = partes[1];
				String horarioSede = partes[2];
				String informacionSede = nombreSede + " - " + direccionSede + " - " + horarioSede;
				sedes.add(informacionSede);
			}
		}
		scan.close();
		//System.out.println(sedes);
		return sedes;
	}
	
	
	private void cargarInventario(File archivoInventario) throws FileNotFoundException, IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(archivoInventario))){
			String linea;
			while ((linea = reader.readLine()) != null) {
				String[] datos = linea.split(";");
				Vehiculo inventario =  new Vehiculo(datos[0], datos[1], Integer.parseInt(datos[2]), datos[3], datos[4], Integer.parseInt(datos[5]), datos[6], datos[7]);
				this.Vehiculos.add(inventario);
			}
		}
	}
	
	
	private void cargarSedes(File archivoSedes) throws FileNotFoundException, IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(archivoSedes))){
			String linea;
			while ((linea = reader.readLine()) != null) {
				String[] datos = linea.split(";");
				Sedes sede = new Sedes(datos[0], datos[1], datos[2]);
				this.Sedes.add(sede);
			}
		}
	}

	
	private void cargarCategoria() {
        for (Vehiculo vehiculo2 : Vehiculos) {
            String cate = vehiculo2.getTipoCategoria();
            Categoria.agregarVehiculoaCategoria(vehiculo2,cate);
            System.out.println(vehiculo2.getTipoCategoria());
        }
    }
	
	
	public void cargarInformacionInventario(File archivoInventario, File archivoSedes) throws FileNotFoundException, IOException {
		cargarInventario(archivoInventario);
		cargarSedes(archivoSedes);
		cargarCategoria();
		List<Vehiculo> SUV = categoria.getSUV();
		}
	
	
	public List<Alquiler> generarAlquiler(String tipodeCarro, Sedes sedeEntrega, Persona conductorAdicional, Cliente cliente,
			Sedes sedeDevolucion, int dias, String seguro) {
			Alquiler alquiler = new Alquiler(tipodeCarro, sedeEntrega, conductorAdicional, cliente, sedeDevolucion, dias, seguro, admin, categoria);
			alquileres.add(alquiler);
			int precio = alquiler.cobroFinal();
			System.out.println("El precio total del alquiler es " + precio);
			for (Alquiler info : alquileres) {
				System.out.println(info);
			}
			ArchivoPagos.agregarPrecio(precio);
			return alquileres;
		}
	
	public void cambiarPropiedadesCarro(String nombreSeguro, int precioSeguro, String temporada) {
		if (temporada == null) {
		admin.agregarElementoASeguros(nombreSeguro, precioSeguro);
		}
		if (nombreSeguro == null) {
			admin.setTemporada(temporada);
		}
		else {
			admin.agregarElementoASeguros(nombreSeguro, precioSeguro);
			admin.setTemporada(temporada);
		System.out.println(admin.getSeguros());
		}
	}
	
	
	public int generarReserva(String tipodeCarro, Sedes sedeEntrega, Persona conductorAdicional, Cliente cliente,
			Sedes sedeDevolucion, int dias, String seguro, String fechayhoraEntrega) {
		Reserva reserva = new Reserva(tipodeCarro, sedeEntrega, conductorAdicional, cliente, sedeDevolucion, dias, seguro, admin, 
				fechayhoraEntrega);
		reservas.add(reserva);
		int precio = reserva.cobroFinal();
		double cobroInicial = reserva.cobroInicial();
		System.out.println("Debe pagar " + cobroInicial + " para confirmar la reserva.");
		for (Reserva info : reservas) {
			System.out.println(info);
		}
		return precio;	
	}
	
	
	public void guardarAlquileres(List<Alquiler> alquileres) throws FileNotFoundException, IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/historialAlquileres.txt", true))){
            for (Alquiler alquiler : alquileres) {
                String alquilerString = alquiler.toString();
                writer.write(alquilerString);
                writer.newLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
	
	
	public Map<String, Integer> getSeguros() {
		
		return admin.getSeguros();
		}
	
	
	public Vehiculo asignarCarro(String tipodeCarro) {
		
		return empleado.asignarVehiculo(tipodeCarro);
	}
	
	public String lineaString(Vehiculo vehiculo) {
		return empleado.lineaDeCarro(vehiculo);
	}
	public void eliminarLinea(String linea) {
		archivoInventario.eliminarLinea(linea);
	}
	
	public void agregarArchivo(String placa, String marca, String modelo, String color, String transmision,
			String capacidad, String tipo, String sede) {
		archivoInventario.agregarArchivo(placa, marca, modelo, color, transmision, capacidad, tipo, sede);
	}
	
	
	public void agregarSede(String nombreSede, String ubicacion, String horarioAtencion) {
		archivoSedes.agregarArchivo(nombreSede, ubicacion, horarioAtencion);
	}
	
	public void guardarArchivoEnMapa() {
		admin.guardarArchivoEnMapa();
	}
	public void resetearMapa() {
		admin.resetearMapa();
	}
	
	public boolean autenticarUsuario(String nombreUsuario, String pass) {
	return ingresoUsuario.autenticarUsuario(nombreUsuario, pass);
}
	public boolean esAdmin(String pass) {
		return ingresoUsuario.esAdmin(pass);
	}
	public boolean esEmpleado(String pass) {
		return ingresoUsuario.esEmpleado(pass);
	}
	public boolean registrarUsuario(String user, String pass) {
		return registroUsuario.registrarUsuario(user, pass);
	}
}














