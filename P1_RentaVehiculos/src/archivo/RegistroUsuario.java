package archivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RegistroUsuario {

	
	private Map<String, String> usuariosRegistrados;
	private String archivoLogins = "data/logins.txt";
	
	 public RegistroUsuario() {
		    usuariosRegistrados = new HashMap<>();
	        cargarUsuariosDesdeArchivo();
	    }
	
	 
	 public boolean registrarUsuario(String nombreUsuario, String contrasena) {
	        if (usuariosRegistrados.containsKey(nombreUsuario)) {
	            System.out.println("El nombre de usuario ya está registrado.");
	            return false;
	        } else {
	            usuariosRegistrados.put(nombreUsuario, contrasena);
	            guardarUsuariosEnArchivo();
	            System.out.println("Registro exitoso para el usuario: " + nombreUsuario);
	            return true;
	        }
	    }
	 
	 private void guardarUsuariosEnArchivo() {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoLogins))) {
	        	//writer.newLine();
	            for (Map.Entry<String, String> entry : usuariosRegistrados.entrySet()) {
	                writer.write(entry.getKey() + ";" + entry.getValue());
	                writer.newLine();
	            }
	        } catch (IOException e) {
	            System.err.println("Error al guardar usuarios en el archivo: " + e.getMessage());
	        }
	    }
	
		
	 private void cargarUsuariosDesdeArchivo() {
	        try (BufferedReader reader = new BufferedReader(new FileReader(archivoLogins))) {
	            String linea;
	            while ((linea = reader.readLine()) != null) {
	                String[] partes = linea.split(";");
	                if (partes.length == 2) {
	                    usuariosRegistrados.put(partes[0], partes[1]);
	                }
	            }
	        } catch (IOException e) {
	            System.err.println("Error al cargar usuarios desde el archivo: " + e.getMessage());
	        }
	    }


	public Map<String, String> getUsuariosRegistrados() {
		return usuariosRegistrados;
	}


	public void setUsuariosRegistrados(Map<String, String> usuariosRegistrados) {
		this.usuariosRegistrados = usuariosRegistrados;
	}
	
}
