package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RentaVehiculos {
	
	
	private List<Vehiculo> Vehiculos;
	private List<Sedes> Sedes;
	private Categoria categoria;
	private List<Alquiler> alquileres;
	private AdministradorGeneral admin;
	
	
	
	public RentaVehiculos() {
		this.Vehiculos = new ArrayList<>();
		this.Sedes = new ArrayList<>();
		this.alquileres = new ArrayList<>();
		this.categoria = new Categoria();
		this.admin = null;
		
	}

	public AdministradorGeneral setAdministradorGeneral(String temporada) {
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
            Categoria.agregarVehiculoaCategoria(categoria, vehiculo2,cate);
        }
    }
	
	
	public void cargarInformacionInventario(File archivoInventario, File archivoSedes) throws FileNotFoundException, IOException {
		cargarInventario(archivoInventario);
		cargarSedes(archivoSedes);
		cargarCategoria();
		List<Vehiculo> SUV = categoria.getSUV();
		}
	
	
	public void generarAlquiler(String tipodeCarro, Sedes sedeEntrega, Cliente conductorAdicional, Cliente cliente,
			Sedes sedeDevolucion, int dias, String seguro) {
			Alquiler alquiler = new Alquiler(tipodeCarro, sedeEntrega, conductorAdicional, cliente, sedeDevolucion, dias, seguro, admin);
			alquileres.add(alquiler);
			for (Alquiler info : alquileres) {
				System.out.println(info);
			}
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
	
	
	public Map<String, Integer> getSeguros() {
		return admin.getSeguros();
		}
	
	
	
	
	
	
	public void resetearMapa() {
		admin.resetearMapa();
	}
}















