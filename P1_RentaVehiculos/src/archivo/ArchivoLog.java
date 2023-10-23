package archivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import modelo.Cliente;
import modelo.Vehiculo;

public class ArchivoLog {

    private static String nombreArchivo = "data/log.txt";



    public ArchivoLog() {

    }


    public static void agregarLog(Cliente cliente, Vehiculo vehiculo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            String datos = "El cliente " + cliente.getNombre() + " alquilo el vehiculo con placa " + vehiculo.getPlaca();
            writer.write(datos);
            writer.newLine(); 
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

  }