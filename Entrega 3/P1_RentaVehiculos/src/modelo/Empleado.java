package modelo;

import java.io.File;
import archivo.ArchivoInventario;
public class Empleado  {
	private Categoria categoria;
	private static ArchivoInventario archivoInventario;
	
	
	public Empleado() {
		this.categoria = new Categoria();
	}
		
	
	public Vehiculo asignarVehiculo(String tipoDeCarro) {
        return categoria.vehiculoAlquilar(tipoDeCarro);
    }
	
	public String lineaDeCarro(Vehiculo vehiculo){
		String placa = vehiculo.getPlaca();
		String marca = vehiculo.getMarca();
		int modelo = vehiculo.getModelo();
		String color = vehiculo.getColor();
		String transmision = vehiculo.getTipodeTransmicion();
		int capacidad = vehiculo.getCapacidadPersonas();
		String tipo = vehiculo.getTipoCategoria();
		String sede = vehiculo.getUbicacion();
		return (placa + ";" + marca + ";" + modelo + ";" + color + ";" + transmision + ";" + capacidad + ";" + tipo + ";" + sede);
	}
	
}

