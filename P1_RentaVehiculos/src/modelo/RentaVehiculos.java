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
		this.categoria = new Categoria();
		
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
			String nombreSede = partes[0];
			String direccionSede = partes[1];
			String horarioSede = partes[2];
			sedes.add(nombreSede);
			sedes.add(direccionSede);
			sedes.add(horarioSede);
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
		List<Vehiculo> SUV = categoria.getSUV();
		Vehiculo v = SUV.get(0);
		System.out.println(v.getModelo());
		System.out.println(v.getMarca());
		}
	
	
	public void generarAlquiler(String tipodeCarro, Sedes sedeEntrega, Cliente conductorAdicional, Cliente cliente,
			Sedes sedeDevolucion, int dias, String seguro) {
			Alquiler alquiler = new Alquiler(tipodeCarro, sedeEntrega, conductorAdicional, cliente, sedeDevolucion, dias, seguro );
			alquileres.add(alquiler);
			//System.out.println(alquileres.add(alquiler));
	}		
	

}
