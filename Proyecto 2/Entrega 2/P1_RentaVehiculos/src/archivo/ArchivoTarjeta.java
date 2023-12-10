package archivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import modelo.PasarelaPago;

public class ArchivoTarjeta extends PasarelaPago {

    private static final String NOMBRE_ARCHIVO = "data/Tarjeta.txt";

    @Override
    protected void agregarPagos(String numero, String nombre, String precio) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(NOMBRE_ARCHIVO, true))) {

            writer.println("Numero tarjeta: " + numero + ", Nombre: " + nombre + ", Precio: " + precio);
        }
    }

	@Override
	protected void cargarDatos() throws IOException {
		// TODO Auto-generated method stub
		
	}
}
