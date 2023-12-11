package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
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
    	setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);

        
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(nombreField = new JTextField(), gbc);
        nombreField.setPreferredSize(new Dimension(200, 25));
        

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Teléfono:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(telefonoField = new JTextField(), gbc);
        telefonoField.setPreferredSize(new Dimension(200, 25));
        
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Fecha de Nacimiento:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(fechadeNacimientoField = new JTextField(), gbc);
        fechadeNacimientoField.setPreferredSize(new Dimension(200, 25));
        
        
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Nacionalidad:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(nacionalidadField = new JTextField(), gbc);
        nacionalidadField.setPreferredSize(new Dimension(200, 25));
        
       
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Documento de Identidad:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(documentodeIdentidadField = new JTextField(), gbc);
        documentodeIdentidadField.setPreferredSize(new Dimension(200, 25));
        
       
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Número de Licencia:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(numeroLicenciaField = new JTextField(), gbc);
        numeroLicenciaField.setPreferredSize(new Dimension(200, 25));
        
        
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("País de Expedición:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(paisExpField = new JTextField(), gbc);
        paisExpField.setPreferredSize(new Dimension(200, 25));
        
       
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Dirección de la Licencia:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(licenciaField = new JTextField(), gbc);
        licenciaField.setPreferredSize(new Dimension(200, 25));
        
       
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Fecha de Vencimiento de la Licencia:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(fechadeVencimientoLicenciaField = new JTextField(), gbc);
        fechadeVencimientoLicenciaField.setPreferredSize(new Dimension(200, 25));
        
       
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Número de Tarjeta:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(numeroTarjetaField = new JTextField(), gbc);
        numeroTarjetaField.setPreferredSize(new Dimension(200, 25));
        
       
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Fecha de Vencimiento de la Tarjeta:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(fechaVencimientoField = new JTextField(), gbc);
        fechaVencimientoField.setPreferredSize(new Dimension(150, 25));
        
       
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("CVV:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cvvField = new JTextField(), gbc);
        cvvField.setPreferredSize(new Dimension(200, 25));
        
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Banco:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(bancoField = new JTextField(), gbc);
        bancoField.setPreferredSize(new Dimension(200, 25));
        
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Tipo de Carro:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(tipoCarroField = new JTextField(), gbc);
        tipoCarroField.setPreferredSize(new Dimension(200, 25));
        
        
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Sede Entrega:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(sedeEntregaField = new JTextField(), gbc);
        sedeEntregaField.setPreferredSize(new Dimension(200, 25));
        
        
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Sede Devolucion: "), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(sedeDevolucionField = new JTextField(), gbc);
        sedeDevolucionField.setPreferredSize(new Dimension(200, 25));
        
        
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Conductor Adicional: "), gbc);
        siButton = new JButton("Si");
        noButton = new JButton("No");
        JPanel panel = new JPanel();
        panel.add(siButton);
        panel.add(noButton);
        gbc.gridx = 1;
        add(panel, gbc);
        
        
        
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Dias Alquiler:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(diasAlquilerField = new JTextField(), gbc);
        diasAlquilerField.setPreferredSize(new Dimension(200, 25));
        
        
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Seguros:"), gbc);
        VerSeguros = new JButton("Ver Seguros");
        JPanel panel2 = new JPanel();
        panel2.add(VerSeguros);
        gbc.gridx = 1;
        add(panel2, gbc);
        
        
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Fecha y hora de entrega del vehiculo:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(fechayhoraEntregaField = new JTextField(), gbc);
        fechayhoraEntregaField.setPreferredSize(new Dimension(200, 25));
       
        
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
                    abrirPanelPagos();
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(PanelReserva.this);
                    frame.dispose();

                 
                } catch (Exception ex) {
                    ex.printStackTrace();
                   
                }
            }
        });
        
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(buttonPanel, gbc);
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
    
    
    private void abrirPanelPagos() {
    	JFrame frame = new JFrame("Pago del movimiento");
    	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new PanelPagoReserva(rentaVehiculos));
        frame.setSize(300, 200);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
	
	

}
