package modelo;

import java.io.File;

public class Empleado  {
	private Categoria categoria;
	
	
	public Empleado() {
		this.categoria = new Categoria();
	}
		
	
	public Vehiculo asignarVehiculo(String tipoDeCarro) {
        return categoria.vehiculoAlquilar(tipoDeCarro);
    }
	


    


}
