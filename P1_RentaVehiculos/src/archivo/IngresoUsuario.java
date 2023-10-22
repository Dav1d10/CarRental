package archivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class IngresoUsuario {
	
	private static Map<String, String> usuariosRegistrados;
    private String archivoUsuarios = "data/Logins.txt";

    public IngresoUsuario() {
        usuariosRegistrados = cargarUsuariosDesdeArchivo();
    }

    public static boolean autenticarUsuario(String nombreUsuario, String contrasena) {
        String contrasenaAlmacenada = usuariosRegistrados.get(nombreUsuario);
        return contrasenaAlmacenada != null && contrasenaAlmacenada.equals(contrasena);
    }

    private Map<String, String> cargarUsuariosDesdeArchivo() {
        Map<String, String> usuariosCargados = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoUsuarios))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length == 2) {
                    usuariosCargados.put(partes[0], partes[1]);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar usuarios desde el archivo: " + e.getMessage());
        }
        return usuariosCargados;
    }
}

