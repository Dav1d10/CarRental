package pruebas;

import org.junit.jupiter.api.Test;

import modelo.AdministradorGeneral;
import modelo.Alquiler;
import modelo.Categoria;
import modelo.Cliente;
import modelo.DatosLicencia;
import modelo.DatosTarjetaCredito;
import modelo.Sedes;
import modelo.Persona;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class AlquilerTest {
	
	
	@Test
    public void testCobroSeguros() {
        AdministradorGeneral admin = new AdministradorGeneral();
        Map<String, Integer> seguros = new HashMap<>();
        seguros.put("Seguro1", 50);
        seguros.put("Seguro2", 75);
        admin.setSeguros(seguros);
        Alquiler alquiler = new Alquiler("Pequeno", new Sedes("Sede1", "Ubicacion1", "Horarios1"), null,
                new Cliente("Cliente1", "12345", "01/01/1990", "Nacionalidad1", new File("documento1.txt"),
                        new DatosLicencia("Licencia1", "Pais1", new File("imagen1.jpg"), "01/01/2025"),
                        new DatosTarjetaCredito("Tarjeta1", "01/25", "123", "Banco1")),
                new Sedes("Sede2", "Ubicacion2", "Horarios2"), 5, Arrays.asList("Seguro1", "Seguro2"), admin,
                new Categoria());
        int resultado = alquiler.cobroSeguros(Arrays.asList("Seguro1", "Seguro2"));
        assertEquals(125 * 5, resultado); 
    }
	
	
	@Test
    public void testCobroConductorAdicional() {
        Alquiler alquilerConConductor = new Alquiler("Pequeno", new Sedes("Sede1", "Ubicacion1", "Horarios1"),
        		new Persona("Conductor", "12345", "01/01/1990", "Nacionalidad1", new File("documento1.txt"),
                        new DatosLicencia("Licencia1", "Pais1", new File("imagen1.jpg"), "01/01/2025")),
                new Cliente("ConductorAdicional", "54321", "01/01/1990", "Nacionalidad2", new File("documento2.txt"),
                        new DatosLicencia("Licencia2", "Pais2", new File("imagen2.jpg"), "01/01/2025"),
                        new DatosTarjetaCredito("Tarjeta2", "01/25", "123", "Banco2")),
                
                new Sedes("Sede2", "Ubicacion2", "Horarios2"), 5, Arrays.asList("Seguro1", "Seguro2"),
                new AdministradorGeneral(), new Categoria());
        int resultadoConConductor = alquilerConConductor.cobroConductorAdicional();
        assertEquals(100, resultadoConConductor);
        Alquiler alquilerSinConductor = new Alquiler("Pequeño", new Sedes("Sede1", "Ubicacion1", "Horarios1"),
                null, new Cliente("Cliente1", "12345", "01/01/1990", "Nacionalidad1", new File("documento1.txt"),
                        new DatosLicencia("Licencia1", "Pais1", new File("imagen1.jpg"), "01/01/2025"),
                        new DatosTarjetaCredito("Tarjeta1", "01/25", "123", "Banco1")),
                new Sedes("Sede2", "Ubicacion2", "Horarios2"), 5, Arrays.asList("Seguro1", "Seguro2"),
                new AdministradorGeneral(), new Categoria());
        int resultadoSinConductor = alquilerSinConductor.cobroConductorAdicional();
        assertEquals(0, resultadoSinConductor);
    }
	
	
	@Test
    public void testTarifaTemporada() {
        AdministradorGeneral adminAlta = new AdministradorGeneral();
        adminAlta.setTemporada("ALTA");
        Alquiler alquilerAlta = new Alquiler("Pequeno", new Sedes("Sede1", "Ubicacion1", "Horarios1"),
        		new Persona("Conductor", "12345", "01/01/1990", "Nacionalidad1", new File("documento1.txt"),
                        new DatosLicencia("Licencia1", "Pais1", new File("imagen1.jpg"), "01/01/2025")),
                new Cliente("ConductorAdicional", "54321", "01/01/1990", "Nacionalidad2", new File("documento2.txt"),
                        new DatosLicencia("Licencia2", "Pais2", new File("imagen2.jpg"), "01/01/2025"),
                        new DatosTarjetaCredito("Tarjeta2", "01/25", "123", "Banco2")),
                new Sedes("Sede2", "Ubicacion2", "Horarios2"), 5, Arrays.asList("Seguro1", "Seguro2"),
                adminAlta, new Categoria());
        int resultadoAlta = alquilerAlta.tarifaTemporada();
        assertEquals(50, resultadoAlta);
        AdministradorGeneral adminBaja = new AdministradorGeneral();
        adminBaja.setTemporada("BAJA");
        Alquiler alquilerBaja = new Alquiler("Pequeno", new Sedes("Sede1", "Ubicacion1", "Horarios1"),
        		new Persona("Conductor", "12345", "01/01/1990", "Nacionalidad1", new File("documento1.txt"),
                        new DatosLicencia("Licencia1", "Pais1", new File("imagen1.jpg"), "01/01/2025")),
                new Cliente("ConductorAdicional", "54321", "01/01/1990", "Nacionalidad2", new File("documento2.txt"),
                        new DatosLicencia("Licencia2", "Pais2", new File("imagen2.jpg"), "01/01/2025"),
                        new DatosTarjetaCredito("Tarjeta2", "01/25", "123", "Banco2")),
                new Sedes("Sede2", "Ubicacion2", "Horarios2"), 5, Arrays.asList("Seguro1", "Seguro2"),
                adminBaja, new Categoria());
        int resultadoBaja = alquilerBaja.tarifaTemporada();
        assertEquals(0, resultadoBaja);
        AdministradorGeneral adminMedia = new AdministradorGeneral();
        adminMedia.setTemporada("MEDIA");
        Alquiler alquilerMedia = new Alquiler("Pequeno", new Sedes("Sede1", "Ubicacion1", "Horarios1"),
        		new Persona("Conductor", "12345", "01/01/1990", "Nacionalidad1", new File("documento1.txt"),
                        new DatosLicencia("Licencia1", "Pais1", new File("imagen1.jpg"), "01/01/2025")),
                new Cliente("ConductorAdicional", "54321", "01/01/1990", "Nacionalidad2", new File("documento2.txt"),
                        new DatosLicencia("Licencia2", "Pais2", new File("imagen2.jpg"), "01/01/2025"),
                        new DatosTarjetaCredito("Tarjeta2", "01/25", "123", "Banco2")),
                new Sedes("Sede2", "Ubicacion2", "Horarios2"), 5, Arrays.asList("Seguro1", "Seguro2"),
                adminMedia, new Categoria());
        int resultadoMedia = alquilerMedia.tarifaTemporada();
        assertEquals(25, resultadoMedia);
    }
	
	
	@Test
	public void testcobroPorDias() {
		Alquiler alquiler = new Alquiler("PEQUENO", new Sedes("Sede1", "Ubicacion1", "Horarios1"),
        		new Persona("Conductor", "12345", "01/01/1990", "Nacionalidad1", new File("documento1.txt"),
                        new DatosLicencia("Licencia1", "Pais1", new File("imagen1.jpg"), "01/01/2025")),
                new Cliente("ConductorAdicional", "54321", "01/01/1990", "Nacionalidad2", new File("documento2.txt"),
                        new DatosLicencia("Licencia2", "Pais2", new File("imagen2.jpg"), "01/01/2025"),
                        new DatosTarjetaCredito("Tarjeta2", "01/25", "123", "Banco2")),
                new Sedes("Sede2", "Ubicacion2", "Horarios2"), 5, Arrays.asList("Seguro1", "Seguro2"),
                new AdministradorGeneral(), new Categoria());
		int cobro = alquiler.cobroPorDias();
		assertEquals(200 * 5, cobro);
		Alquiler alquiler1 = new Alquiler("SUV", new Sedes("Sede1", "Ubicacion1", "Horarios1"),
        		new Persona("Conductor", "12345", "01/01/1990", "Nacionalidad1", new File("documento1.txt"),
                        new DatosLicencia("Licencia1", "Pais1", new File("imagen1.jpg"), "01/01/2025")),
                new Cliente("ConductorAdicional", "54321", "01/01/1990", "Nacionalidad2", new File("documento2.txt"),
                        new DatosLicencia("Licencia2", "Pais2", new File("imagen2.jpg"), "01/01/2025"),
                        new DatosTarjetaCredito("Tarjeta2", "01/25", "123", "Banco2")),
                new Sedes("Sede2", "Ubicacion2", "Horarios2"), 5, Arrays.asList("Seguro1", "Seguro2"),
                new AdministradorGeneral(), new Categoria());
		int cobro1 = alquiler1.cobroPorDias();
		assertEquals(300 * 5, cobro1);
		Alquiler alquiler2 = new Alquiler("VAN", new Sedes("Sede1", "Ubicacion1", "Horarios1"),
        		new Persona("Conductor", "12345", "01/01/1990", "Nacionalidad1", new File("documento1.txt"),
                        new DatosLicencia("Licencia1", "Pais1", new File("imagen1.jpg"), "01/01/2025")),
                new Cliente("ConductorAdicional", "54321", "01/01/1990", "Nacionalidad2", new File("documento2.txt"),
                        new DatosLicencia("Licencia2", "Pais2", new File("imagen2.jpg"), "01/01/2025"),
                        new DatosTarjetaCredito("Tarjeta2", "01/25", "123", "Banco2")),
                new Sedes("Sede2", "Ubicacion2", "Horarios2"), 5, Arrays.asList("Seguro1", "Seguro2"),
                new AdministradorGeneral(), new Categoria());
		int cobro2 = alquiler2.cobroPorDias();
		assertEquals(350 * 5, cobro2);
		Alquiler alquiler3 = new Alquiler("LUJO", new Sedes("Sede1", "Ubicacion1", "Horarios1"),
        		new Persona("Conductor", "12345", "01/01/1990", "Nacionalidad1", new File("documento1.txt"),
                        new DatosLicencia("Licencia1", "Pais1", new File("imagen1.jpg"), "01/01/2025")),
                new Cliente("ConductorAdicional", "54321", "01/01/1990", "Nacionalidad2", new File("documento2.txt"),
                        new DatosLicencia("Licencia2", "Pais2", new File("imagen2.jpg"), "01/01/2025"),
                        new DatosTarjetaCredito("Tarjeta2", "01/25", "123", "Banco2")),
                new Sedes("Sede2", "Ubicacion2", "Horarios2"), 5, Arrays.asList("Seguro1", "Seguro2"),
                new AdministradorGeneral(), new Categoria());
		int cobro3 = alquiler3.cobroPorDias();
		assertEquals(400 * 5, cobro3);
		Alquiler alquiler4 = new Alquiler("ELECTRICO", new Sedes("Sede1", "Ubicacion1", "Horarios1"),
        		new Persona("Conductor", "12345", "01/01/1990", "Nacionalidad1", new File("documento1.txt"),
                        new DatosLicencia("Licencia1", "Pais1", new File("imagen1.jpg"), "01/01/2025")),
                new Cliente("ConductorAdicional", "54321", "01/01/1990", "Nacionalidad2", new File("documento2.txt"),
                        new DatosLicencia("Licencia2", "Pais2", new File("imagen2.jpg"), "01/01/2025"),
                        new DatosTarjetaCredito("Tarjeta2", "01/25", "123", "Banco2")),
                new Sedes("Sede2", "Ubicacion2", "Horarios2"), 5, Arrays.asList("Seguro1", "Seguro2"),
                new AdministradorGeneral(), new Categoria());
		int cobro4 = alquiler4.cobroPorDias();
		assertEquals(300 * 5, cobro4);
	}
	
	
	@Test
	public void testcobroFinal() {
		AdministradorGeneral admin = new AdministradorGeneral();
		admin.setTemporada("ALTA");
        Map<String, Integer> seguros = new HashMap<>();
        seguros.put("Seguro1", 50);
        seguros.put("Seguro2", 75);
        admin.setSeguros(seguros);
        Alquiler alquiler = new Alquiler("LUJO", new Sedes("Sede1", "Ubicacion1", "Horarios1"), null,
                new Cliente("Cliente1", "12345", "01/01/1990", "Nacionalidad1", new File("documento1.txt"),
                        new DatosLicencia("Licencia1", "Pais1", new File("imagen1.jpg"), "01/01/2025"),
                        new DatosTarjetaCredito("Tarjeta1", "01/25", "123", "Banco1")),
                new Sedes("Sede2", "Ubicacion2", "Horarios2"), 5, Arrays.asList("Seguro1", "Seguro2"), admin,
                new Categoria());
        int cobrofinal = alquiler.cobroFinal(Arrays.asList("Seguro1", "Seguro2"));
        assertEquals(2675, cobrofinal);
	}
	
	
	


}
