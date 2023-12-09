package archivo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import modelo.PasarelaPago;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArchivoSire extends PasarelaPago {

    private String rutaArchivoJson;
    private List<Map<String, Object>> lista;

    public ArchivoSire() {
 
        this.rutaArchivoJson = "data/Sire.json";
    }

    public void cargarDatos() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File archivoJson = new File(rutaArchivoJson);
        lista = objectMapper.readValue(archivoJson, new TypeReference<List<Map<String, Object>>>() {});
    }

    public void agregarPagos(String numeroTarjeta, String nombre, String precio) throws IOException {
        List<Map<String, Object>> transacciones = lista;

        Map<String, Object> nuevaTransaccion = new HashMap<>();
        nuevaTransaccion.put("numero_tarjeta", numeroTarjeta);
        nuevaTransaccion.put("nombre", nombre);
        nuevaTransaccion.put("precio", precio);

        transacciones.add(nuevaTransaccion);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(rutaArchivoJson), transacciones);
    }
}
