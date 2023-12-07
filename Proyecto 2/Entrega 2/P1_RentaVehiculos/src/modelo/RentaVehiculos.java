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

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;

import archivo.ArchivoInventario;
import archivo.ArchivoPagos;
import archivo.ArchivoSedes;
import interfaz.PanelInformacionAlquiler;
import interfaz.PanelInformacionReserva;
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
	

	
	public void setAdministradorGeneral() {
		AdministradorGeneral administrador = new AdministradorGeneral();
        this.admin = administrador;
        
	}
	
	
	
	public List<Vehiculo> getVehiculos() {
		return this.Vehiculos;
	}

	
	
	public List<Sedes> getSedes() {
		return this.Sedes;
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
        }
    }
	
	
	
	public void cargarInformacionInventario(File archivoInventario, File archivoSedes) throws FileNotFoundException, IOException {
		cargarInventario(archivoInventario);
		cargarSedes(archivoSedes);
		cargarCategoria();
		admin.cargarMapaDesdeArchivo();
		List<Vehiculo> SUV = categoria.getSUV();
		}
	
	
	
	public void cargarTemporada() {
		admin.cargarTemporada();
	}
	
	
	public static void generarFacturaAlquiler(String nombreArchivo, Alquiler alquiler, Vehiculo carro, int precio, AdministradorGeneral admin) {
		try {
			PdfWriter writer = new PdfWriter(nombreArchivo);
			PdfDocument pdf = new PdfDocument(writer);
			Document document = new Document(pdf);
			Paragraph titulo = new Paragraph("Factura de Alquiler");
			titulo.setTextAlignment(TextAlignment.CENTER);
			document.add(titulo);
			document.add(new Paragraph("DGA Rental"));
			document.add(new Paragraph("Informacion del cliente: "));
			document.add(new Paragraph("Nombre: " + alquiler.getCliente().getNombre()));
			document.add(new Paragraph("Telefono: " + alquiler.getCliente().getTelefono()));
			document.add(new Paragraph("Detalles del vehiculo: "));
			document.add(new Paragraph("Placa del vehiculo: " + carro.getPlaca()));
			document.add(new Paragraph("Capacidad del vehiculo: " + carro.getCapacidadPersonas()));
			document.add(new Paragraph("Color del vehiculo: " + carro.getColor()));
			document.add(new Paragraph("Marca del vehiculo: " + carro.getMarca()));
			document.add(new Paragraph("Tipo de vehiculo: " + carro.getTipoCategoria()));
			document.add(new Paragraph("Tipo de transmición: " + carro.getTipodeTransmicion()));
			document.add(new Paragraph("Modelo del vehiculo: " + carro.getModelo()));
			document.add(new Paragraph("Información del pago: "));
			document.add(new Paragraph("Número de la tarjeta de credito : " + alquiler.getCliente().getTarjetaCredito().getNumeroTarjeta()));
			document.add(new Paragraph("Valor del pago ($): " + precio));
			document.add(new Paragraph("Temporada actual: " + admin.getTemporada()));
			document.add(new Paragraph("Información de la entrega y devolución del vehiculo: "));
			document.add(new Paragraph("Sede de entrega del vehiculo: " + alquiler.getSedeEntrega()));
			document.add(new Paragraph("Sede de devolución del vehiculo: " + alquiler.getSedeDevolucion()));
			Image firmaAdmin = new Image(ImageDataFactory.create("data/firma.png"));
			document.add(firmaAdmin);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void generarFacturaReserva(String nombreArchivo, Reserva reserva, Vehiculo carro, int precio, double cobroInicial, AdministradorGeneral admin) {
		try {
			PdfWriter writer = new PdfWriter(nombreArchivo);
			PdfDocument pdf = new PdfDocument(writer);
			Document document = new Document(pdf);
			Paragraph titulo = new Paragraph("Factura de Reserva");
			titulo.setTextAlignment(TextAlignment.CENTER);
			document.add(titulo);
			document.add(new Paragraph("DGA Rental"));
			document.add(new Paragraph("Informacion del cliente: "));
			document.add(new Paragraph("Nombre: " + reserva.getCliente().getNombre()));
			document.add(new Paragraph("Telefono: " + reserva.getCliente().getTelefono()));
			document.add(new Paragraph("Detalles del vehiculo: "));
			document.add(new Paragraph("Placa del vehiculo: " + carro.getPlaca()));
			document.add(new Paragraph("Capacidad del vehiculo: " + carro.getCapacidadPersonas()));
			document.add(new Paragraph("Color del vehiculo: " + carro.getColor()));
			document.add(new Paragraph("Marca del vehiculo: " + carro.getMarca()));
			document.add(new Paragraph("Tipo de vehiculo: " + carro.getTipoCategoria()));
			document.add(new Paragraph("Tipo de transmición: " + carro.getTipodeTransmicion()));
			document.add(new Paragraph("Modelo del vehiculo: " + carro.getModelo()));
			document.add(new Paragraph("Información del pago: "));
			document.add(new Paragraph("Número de la tarjeta de credito : " + reserva.getCliente().getTarjetaCredito().getNumeroTarjeta()));
			document.add(new Paragraph("Cobro Inicial ($): " + cobroInicial));
			document.add(new Paragraph("Valor del pago ($): " + precio));
			document.add(new Paragraph("Temporada actual: " + admin.getTemporada()));
			document.add(new Paragraph("Información de la entrega y devolución del vehiculo: "));
			document.add(new Paragraph("Sede de entrega del vehiculo: " + reserva.getSedeEntrega()));
			document.add(new Paragraph("Sede de devolución del vehiculo: " + reserva.getSedeDevolucion()));
			Image firmaAdmin = new Image(ImageDataFactory.create("data/firma.png"));
			document.add(firmaAdmin);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Alquiler> generarAlquiler(String tipodeCarro, Sedes sedeEntrega, Persona conductorAdicional, Cliente cliente,
			Sedes sedeDevolucion, int dias, List<String> seguro) {
			Alquiler alquiler = new Alquiler(tipodeCarro, sedeEntrega, conductorAdicional, cliente, sedeDevolucion, dias, seguro, admin, categoria);
			alquileres.add(alquiler);
			for (Alquiler info : alquileres) {
				System.out.println(info);
			}
			System.out.println("La temporada actual es: " + admin.getTemporada());
			int precio = alquiler.cobroFinal(seguro);
			System.out.println("El precio total del alquiler es " + precio);
			
			ArchivoPagos.agregarPrecio(precio);
			Vehiculo carroAsignado = empleado.asignarVehiculo(tipodeCarro);
			String info =  "Sus datos han sido confirmados, gracias por realizar el alquiler con nosotros! - DGA Team" + "\n" +
			"La marca del carro asignado es " + carroAsignado.getMarca() + ", de color " + carroAsignado.getColor() + ", modelo " + carroAsignado.getModelo() +
            		", con una capacidad de " + carroAsignado.getCapacidadPersonas() + " personas," +" de placa " + carroAsignado.getPlaca() + "\n"
            		+ "La temporada actual es: " + admin.getTemporada() + "\n" +
            		"El precio total del alquiler es: " + precio;
			PanelInformacionAlquiler panelInformacionAlquiler = new PanelInformacionAlquiler();
			panelInformacionAlquiler.mostrarInformacionAlquiler(alquileres, info);
			String archivo = "data/factura.pdf";
			generarFacturaAlquiler(archivo, alquiler, carroAsignado, precio, admin);
			return alquileres;
		}
	
	
	
	public List<Reserva> generarReserva(String tipodeCarro, Sedes sedeEntrega, Persona conductorAdicional, Cliente cliente,
			Sedes sedeDevolucion, int dias, List<String> seguro, String fechayhoraEntrega) {
		Reserva reserva = new Reserva(tipodeCarro, sedeEntrega, conductorAdicional, cliente, sedeDevolucion, dias, seguro, fechayhoraEntrega, admin, categoria);
		reservas.add(reserva);
		for (Reserva info : reservas) {
			System.out.println(info);
		}
		int precio = reserva.cobroFinal(seguro);
		double cobroInicial = reserva.cobroInicial(seguro);
		System.out.println("La temporada actual es: " + admin.getTemporada());
		System.out.println("Debe pagar " + cobroInicial + " para confirmar la reserva.");
		System.out.println("El precio total de la reserva es " + precio);
		
		ArchivoPagos.agregarPrecio(precio);
		Vehiculo carroAsignado = empleado.asignarVehiculo(tipodeCarro);
		String info = "Sus datos han sido confirmados, gracias por realizar la reserva con nosotros! - DGA Team" + "\n" +
		"La marca del carro asignado es " + carroAsignado.getMarca() + ", de color " + carroAsignado.getColor() + ", modelo " + carroAsignado.getModelo() +
        		", con una capacidad de " + carroAsignado.getCapacidadPersonas() + " personas," +" de placa " + carroAsignado.getPlaca() + "\n"
        		+ "La temporada actual es: " + admin.getTemporada() + "\n" +
        		"Debe pagar " + cobroInicial + " para confirmar la reserva." + "\n" +
        		"El precio total de la reserva es: " + precio;
		PanelInformacionReserva panelInformacionReserva = new PanelInformacionReserva();
		panelInformacionReserva.mostrarInformacionReserva(reservas, info);
		String archivo = "data/factura.pdf";
		generarFacturaReserva(archivo, reserva, carroAsignado, precio, cobroInicial, admin);
		return reservas;	
	}
	
	
	
	public void guardarAlquileres(List<Alquiler> alquileres) throws FileNotFoundException, IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/historialAlquileres.txt", true))){
            for (Alquiler alquiler : alquileres) {
                String alquilerString = alquiler.toString();
                writer.newLine();
                writer.write(alquilerString);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
	
	
	
	public void guardarReservas(List<Reserva> reservas) throws FileNotFoundException, IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/historialReservas.txt", true))){
            for (Reserva reserva : reservas) {
                String reservaString = reserva.toString();
                writer.newLine();
                writer.write(reservaString);
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
	
	
	
	public void AgregarSeguro(String nombre, int precio) {
		admin.agregarSeguro(nombre, precio);
	}
	
	
	
	public void AgregarSeguroaMapa() {
		admin.cargarMapaDesdeArchivo();
	}
	
	
	
	public void cambiarTemporada(String temporada) {
		admin.cambiarTemporada(temporada);
	}
	
	
	
	public void resetearTemporada() {
		admin.eliminarContenidoArchivoTemp();
	}
	
	
	public String temporada() {
		return "La temporada actual es: " + admin.getTemporada();
	}
	
	
	
}














