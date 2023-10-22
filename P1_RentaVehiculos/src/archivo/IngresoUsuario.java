package archivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class IngresoUsuario {
	
	private  Map<String, String> usuariosRegistrados;
    private String archivoUsuarios = "data/Logins.txt";

    public IngresoUsuario() {
        usuariosRegistrados = cargarUsuariosDesdeArchivo();
    }
    
    public boolean autenticarUsuario(String nombreUsuario, String contrasena) {
        String contrasenaAlmacenada = usuariosRegistrados.get(nombreUsuario);
        return contrasenaAlmacenada != null && contrasenaAlmacenada.equals(contrasena);
    }
    public boolean esAdmin(String pass) {
        return pass.endsWith(":A");
    }
    
    
    private Map<String, String> cargarUsuariosDesdeArchivo() {
        Map<String, String> usuariosCargados = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoUsuarios))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 2) {
                    usuariosCargados.put(partes[0], partes[1]);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar usuarios desde el archivo: " + e.getMessage());
        }
        return usuariosCargados;
    }

	public Map<String, String> getUsuariosRegistrados() {
		return usuariosRegistrados;
	}

	public void setUsuariosRegistrados(Map<String, String> usuariosRegistrados) {
		this.usuariosRegistrados = usuariosRegistrados;
	}
}

