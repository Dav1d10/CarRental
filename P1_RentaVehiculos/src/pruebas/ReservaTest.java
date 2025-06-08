package pruebas;

import org.junit.jupiter.api.Test;

import modelo.AdministradorGeneral;
import modelo.Alquiler;
import modelo.Categoria;
import modelo.Cliente;
import modelo.DatosLicencia;
import modelo.DatosTarjetaCredito;
import modelo.Reserva;
import modelo.Sedes;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReservaTest {
	
	@Test
	public void testCobroInicial() {
		AdministradorGeneral admin = new AdministradorGeneral();
		admin.setTemporada("ALTA");
        Map<String, Integer> seguros = new HashMap<>();
        seguros.put("Seguro1", 50);
        seguros.put("Seguro2", 75);
        admin.setSeguros(seguros);
        Reserva reserva = new Reserva("LUJO", new Sedes("Sede1", "Ubicacion1", "Horarios1"), null,
                new Cliente("Cliente1", "12345", "01/01/1990", "Nacionalidad1", new File("documento1.txt"),
                        new DatosLicencia("Licencia1", "Pais1", new File("imagen1.jpg"), "01/01/2025"),
                        new DatosTarjetaCredito("Tarjeta1", "01/25", "123", "Banco1")),
                new Sedes("Sede2", "Ubicacion2", "Horarios2"), 5, Arrays.asList("Seguro1", "Seguro2"), "18:00:00" ,admin,
                new Categoria());
        double cobroInicial = reserva.cobroInicial(Arrays.asList("Seguro1", "Seguro2"));
        assertEquals(802.5, cobroInicial);
		
	}

}
