package archivo;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ArchivoAdminGeneral {


private String tarifaTemporada;
private String Vehiculos;

public ArchivoAdminGeneral() {
    

}

public String getTarifaTemporada() {
    return this.tarifaTemporada;
}


public String getVehiculos() {
    return this.Vehiculos;
}

public void setTarifaTemporada(String tarifaTemporada) {
    this.tarifaTemporada = tarifaTemporada;
}


public void setVehiculos(String Vehiculos) {
    this.Vehiculos = Vehiculos;
}


public static void crearArchivoTexto() {
    String archivoNombre = "data/archivoAdminGral.txt";

    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(archivoNombre));

        // Escribe la primera línea con una cantidad variable de Strings
        String[] lineasPrimeras = {"Texto1", "Texto2", "Texto3"};
        for (String texto : lineasPrimeras) {
            writer.write(texto);
            writer.newLine(); // Agrega un salto de línea
        }

        // Escribe la segunda línea con un solo texto
        writer.write("Segunda línea");

        // Cierra el archivo
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public static void main(String[] args) {
    crearArchivoTexto();
}
}