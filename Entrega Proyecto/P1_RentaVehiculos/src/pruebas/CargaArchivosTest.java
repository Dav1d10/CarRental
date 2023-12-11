package pruebas;

import org.junit.jupiter.api.Test;
import com.itextpdf.io.IOException;
import modelo.RentaVehiculos;
import modelo.Sedes;
import modelo.Vehiculo;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class CargaArchivosTest {
	
	@Test
	public void testCargarInventario() throws FileNotFoundException, java.io.IOException {
        File archivoInventario = new File("data/testInventario.txt");
        RentaVehiculos rentaVehiculos = new RentaVehiculos();
        try {
            rentaVehiculos.cargarInventario(archivoInventario);
        } catch (IOException e) {
            fail("Error al cargar el inventario: " + e.getMessage());
        }
        List<Vehiculo> vehiculos = rentaVehiculos.getVehiculos();
        assertEquals(2, vehiculos.size());
        Vehiculo vehiculo = new Vehiculo("LMN345", "HONDA", 2020, "PLATA", "MANUAL", 4, "SUV", "AGUAS");
        Vehiculo vehiculo1 = new Vehiculo("TUV901", "BMW", 2018, "NEGRO", "AUTOMATICA", 5, "PEQUENO", "MAZUREN");
        assertTrue(vehiculos.contains(vehiculo), "El vehículo no está en la lista");
        assertTrue(vehiculos.contains(vehiculo1), "El vehículo 1 no está en la lista");
	}
	
	
	@Test 
	public void testCargarSedes() throws FileNotFoundException, java.io.IOException {
		File archivoSedes = new File("data/testSedes.txt");
		RentaVehiculos rentaVehiculos = new RentaVehiculos();
		try {
			rentaVehiculos.cargarSedes(archivoSedes);
		} catch (IOException e) {
			fail("Error al cargar las sedes: " + e.getMessage());
		}
		List<Sedes> sedes = rentaVehiculos.getSedes();
		assertEquals(2, sedes.size());
		Sedes sede = new Sedes("COLINA", "CLL134", "8:00-18:00");
		Sedes sede1 = new Sedes("PRADO", "CLL127", "8:00-18:00");
		assertTrue(sedes.contains(sede), "La sede no se encuentra en la lista");
		assertTrue(sedes.contains(sede1), "La sede 1 no se encuentra en la lista");
	}
	
	

}
