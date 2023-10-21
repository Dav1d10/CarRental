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
	
	
	
	public RentaVehiculos() {
		this.Vehiculos = new ArrayList<>();
		this.Sedes = new ArrayList<>();
		this.alquileres = new ArrayList<>();
		
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
	
	
	public Map<String, String> mostrarSedes(File archivoSedes) throws FileNotFoundException {
		Map<String, String> sedes = new HashMap<>();
		Scanner scan = new Scanner(archivoSedes);
		while(scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			if (partes.length >= 2) {
				String nombreSede = partes[0];
				String informacionSede = partes[1];
				sedes.put(nombreSede, informacionSede);
			}
		}
		scan.close();
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
	}
	
	
	public void generarAlquiler(String tipodeCarro, Sedes sedeEntrega, Cliente conductorAdicional, Cliente cliente,
			Sedes sedeDevolucion, int dias, String seguro) {
			Alquiler alquiler = new Alquiler(tipodeCarro, sedeEntrega, conductorAdicional, cliente, sedeDevolucion, dias, seguro );
			alquileres.add(alquiler);
	}
	

}
