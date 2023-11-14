package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import archivo.ArchivoLog;
import archivo.ArchivoPagos;
import modelo.Alquiler;
import modelo.Cliente;
import modelo.DatosLicencia;
import modelo.DatosTarjetaCredito;
import modelo.Persona;
import modelo.RentaVehiculos;
import modelo.Reserva;
import modelo.Sedes;
import modelo.Vehiculo;

public class PanelReserva extends JPanel {
	
	private static RentaVehiculos rentaVehiculos;
	private JTextField nombreField;
    private JTextField telefonoField;
    private JTextField fechadeNacimientoField;
    private JTextField nacionalidadField;
    private JTextField documentodeIdentidadField;
    private JTextField numeroLicenciaField;
    private JTextField paisExpField;
    private JTextField licenciaField;
    private JTextField fechadeVencimientoLicenciaField;
    private JTextField numeroTarjetaField;
    private JTextField fechaVencimientoField;
    private JTextField cvvField;
    private JTextField bancoField;
    private JTextField tipoCarroField;
    private JTextField sedeEntregaField;
    private JTextField sedeDevolucionField;
    private JTextField diasAlquilerField;
    private JTextField fechayhoraEntregaField;
    private JButton siButton;
    private JButton noButton;
    private JButton VerSeguros;
    private PanelConductorAdicional panelConductorAdicional;
    
    
    
   

    public PanelReserva(RentaVehiculos rentaVehiculos) {
    	this.rentaVehiculos = rentaVehiculos;
    	panelConductorAdicional = new PanelConductorAdicional();
        setLayout(new BorderLayout());
        JPanel formPanel = new JPanel(new GridLayout(16, 2));

        
        formPanel.add(new JLabel("Nombre:"));
        formPanel.add(nombreField = new JTextField());
        

        formPanel.add(new JLabel("Teléfono:"));
        formPanel.add(telefonoField = new JTextField());
        

        formPanel.add(new JLabel("Fecha de Nacimiento:"));
        formPanel.add(fechadeNacimientoField = new JTextField());
        

        formPanel.add(new JLabel("Nacionalidad:"));
        formPanel.add(nacionalidadField = new JTextField());
       

        formPanel.add(new JLabel("Documento de Identidad:"));
        formPanel.add(documentodeIdentidadField = new JTextField());
       

        formPanel.add(new JLabel("Número de Licencia:"));
        formPanel.add(numeroLicenciaField = new JTextField());
        
        
        formPanel.add(new JLabel("País de Expedición:"));
        formPanel.add(paisExpField = new JTextField());
       

        formPanel.add(new JLabel("Dirección de la Licencia:"));
        formPanel.add(licenciaField = new JTextField());
       

        formPanel.add(new JLabel("Fecha de Vencimiento de la Licencia:"));
        formPanel.add(fechadeVencimientoLicenciaField = new JTextField());
       

        formPanel.add(new JLabel("Número de Tarjeta:"));
        formPanel.add(numeroTarjetaField = new JTextField());
       

        formPanel.add(new JLabel("Fecha de Vencimiento de la Tarjeta:"));
        formPanel.add(fechaVencimientoField = new JTextField());
       

        formPanel.add(new JLabel("CVV:"));
        formPanel.add(cvvField = new JTextField());
        

        formPanel.add(new JLabel("Banco:"));
        formPanel.add(bancoField = new JTextField());
        

        formPanel.add(new JLabel("Tipo de Carro:"));
        formPanel.add(tipoCarroField = new JTextField());
        
        
        formPanel.add(new JLabel("Sede Entrega:"));
        formPanel.add(sedeEntregaField = new JTextField());
        
        
        formPanel.add(new JLabel("Sede Devolucion: "));
        formPanel.add(sedeDevolucionField = new JTextField());
        
        
        formPanel.add(new JLabel("Conductor Adicional: "));
        siButton = new JButton("Si");
        noButton = new JButton("No");
        formPanel.add(siButton);
        formPanel.add(noButton);
        
        formPanel.add(new JLabel("Dias Alquiler:"));
        formPanel.add(diasAlquilerField = new JTextField());
        
        
        formPanel.add(new JLabel("Seguros:"));
        VerSeguros = new JButton("Ver Seguros");
        formPanel.add(VerSeguros);
        
        formPanel.add(new JLabel("Fecha y hora de devolucion del vehiculo:"));
        formPanel.add(fechayhoraEntregaField = new JTextField());
        
        add(formPanel, BorderLayout.CENTER);
        
        
        siButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                abrirPanelConductorAdicional();
            }
        });

        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	panelConductorAdicional.noQuiereConductorAdicional = false;
            }
        });
        
        
        VerSeguros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirPanelSeguros(rentaVehiculos);
            }
        });

     
 
        JPanel buttonPanel = new JPanel();
        JButton reservaButton = new JButton("Guardar");
        buttonPanel.add(reservaButton);


        reservaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
         
                    Cliente cliente = nuevoCliente();
                    String tipodeCarro = tipoCarroField.getText().toUpperCase();
                    Sedes sedeEntrega = elegirSedeEntrega();
            		Sedes sedeDevolucion = elegirSedeDevolucion();
					Persona conductorAdicional = panelConductorAdicional.quiereConductorAdicional();
                    String diasString = diasAlquilerField.getText();
                    int dias = Integer.parseInt(diasString);
                    List<String> seguro = PanelElegirSeguros.getSegurosSeleccionados();    
                    String fechayhoraEntrega = fechayhoraEntregaField.getText();
                    List <Reserva> reservas = rentaVehiculos.generarReserva(tipodeCarro, sedeEntrega, conductorAdicional, cliente, sedeDevolucion, dias, seguro, fechayhoraEntrega);
                    rentaVehiculos.guardarReservas(reservas);
                    Vehiculo carroAsignado = rentaVehiculos.asignarCarro(tipodeCarro);
                    String lineaAEliminar = rentaVehiculos.lineaString(carroAsignado);
                    rentaVehiculos.eliminarLinea(lineaAEliminar);
                    ArchivoLog.agregarLog(cliente, carroAsignado);
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(PanelReserva.this);
                    frame.dispose();

                 
                } catch (Exception ex) {
                    ex.printStackTrace();
                   
                }
            }
        });
        
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private Cliente nuevoCliente() {
    	 String nombre = nombreField.getText();
         String telefono = telefonoField.getText();
         String fechadeNacimiento = fechadeNacimientoField.getText();
         String nacionalidad = nacionalidadField.getText();
         String documentodeIdentidad = documentodeIdentidadField.getText();
         File documentoIdentidad = new File(documentodeIdentidad);
         String numeroLicencia = numeroLicenciaField.getText();
         String paisExp = paisExpField.getText();
         String direccionLicencia = licenciaField.getText();
         File licencia = new File(direccionLicencia);
         String fechadeVencimientoLicencia = fechadeVencimientoLicenciaField.getText();
         String numeroTarjeta = numeroTarjetaField.getText();
         String fechaVencimientoTarjeta = fechaVencimientoField.getText();
         String cvv = cvvField.getText();
         String banco = bancoField.getText();
         DatosLicencia datosLicencia = new DatosLicencia(numeroLicencia, paisExp, licencia, fechadeVencimientoLicencia);
         DatosTarjetaCredito tarjetaCredito = new DatosTarjetaCredito(numeroTarjeta, fechaVencimientoTarjeta, cvv, banco);
         Cliente cliente = new Cliente(nombre, telefono, fechadeNacimiento, nacionalidad, documentoIdentidad, datosLicencia, tarjetaCredito);
         ArchivoPagos.agregarArchivo(tarjetaCredito);
         return cliente;
    }
    
    
    private Sedes elegirSedeEntrega() {
	    File archivoSedes = new File("data/sedes.txt");
	    try {
	        List<String> sedesInfo = rentaVehiculos.mostrarSedes(archivoSedes);
	        String nombreSedeBuscada = sedeEntregaField.getText().toUpperCase();
	        for (String info : sedesInfo) {
	            String[] partes = info.split(" - ");
	            if (partes.length == 3) {
	            	String nombreSede = partes[0];
	            	if (nombreSede.equals(nombreSedeBuscada)) {
	            		String ubicacionSede = partes[1];
	            		String horariosSede = partes[2];
	            		return new Sedes(nombreSede, ubicacionSede, horariosSede);
	            }
	        }
	    }
	    System.out.println("No se encontro la sede con el nombre especificado.");
	    } catch (FileNotFoundException e) {
	        System.out.println("No se pudo abrir el archivo de sedes.");
	    }
	    return null; 
	}
    
    
    private Sedes elegirSedeDevolucion() {
	    File archivoSedes = new File("data/sedes.txt");
	    try {
	        List<String> sedesInfo = rentaVehiculos.mostrarSedes(archivoSedes);
	        String nombreSedeBuscada = sedeDevolucionField.getText().toUpperCase();
	        for (String info : sedesInfo) {
	            String[] partes = info.split(" - ");
	            if (partes.length == 3) {
	            	String nombreSede = partes[0];
	            	if (nombreSede.equals(nombreSedeBuscada)) {
	            		String ubicacionSede = partes[1];
	            		String horariosSede = partes[2];
	            		return new Sedes(nombreSede, ubicacionSede, horariosSede);
	            }
	        }
	    }
	    System.out.println("No se encontro la sede con el nombre especificado.");
	    } catch (FileNotFoundException e) {
	        System.out.println("No se pudo abrir el archivo de sedes.");
	    }
	    return null; 
	}
    
    
    private void abrirPanelConductorAdicional() {
       
        JFrame frame = new JFrame("Conductor Adicional");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new PanelConductorAdicional());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    
    private void abrirPanelSeguros(RentaVehiculos rentaVehiculos) {
        JFrame frame = new JFrame("Panel Elegir Seguros");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Map<String, Integer> seguros = rentaVehiculos.getSeguros();
        PanelElegirSeguros panelSeguros = new PanelElegirSeguros(seguros, rentaVehiculos);
        frame.getContentPane().add(panelSeguros, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
    
	
	

}
