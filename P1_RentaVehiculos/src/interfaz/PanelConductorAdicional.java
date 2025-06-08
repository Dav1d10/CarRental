package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import modelo.DatosLicencia;
import modelo.Persona;

public class PanelConductorAdicional extends JPanel {
	
	
	    private JTextField nombreField;
	    private JTextField telefonoField;
	    private JTextField fechaNacimientoField;
	    private JTextField nacionalidadField;
	    private JTextField direccionIdentidadField;
	    private JTextField numeroLicenciaField;
	    private JTextField paisExpedicionLicenciaField;
	    private JTextField direccionLicenciaField;
	    private JTextField fechaVencimientoLicenciaField;
	    public boolean noQuiereConductorAdicional = true;

	    
	    public PanelConductorAdicional() {
	        setLayout(new GridLayout(11, 2));

	       
	        add(new JLabel("Nombre:"));
	        nombreField = new JTextField();
	        add(nombreField);

	        add(new JLabel("Teléfono:"));
	        telefonoField = new JTextField();
	        add(telefonoField);

	        add(new JLabel("Fecha de Nacimiento:"));
	        fechaNacimientoField = new JTextField();
	        add(fechaNacimientoField);

	        add(new JLabel("Nacionalidad:"));
	        nacionalidadField = new JTextField();
	        add(nacionalidadField);

	        add(new JLabel("Dirección de Identidad:"));
	        direccionIdentidadField = new JTextField();
	        add(direccionIdentidadField);

	        add(new JLabel("Número de Licencia:"));
	        numeroLicenciaField = new JTextField();
	        add(numeroLicenciaField);

	        add(new JLabel("País de Expedición de la Licencia:"));
	        paisExpedicionLicenciaField = new JTextField();
	        add(paisExpedicionLicenciaField);

	        add(new JLabel("Dirección de la Licencia:"));
	        direccionLicenciaField = new JTextField();
	        add(direccionLicenciaField);

	        add(new JLabel("Fecha de Vencimiento de la Licencia:"));
	        fechaVencimientoLicenciaField = new JTextField();
	        add(fechaVencimientoLicenciaField);

	        JButton guardarButton = new JButton("Guardar");
	        add(guardarButton);

	     
	        guardarButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	quiereConductorAdicional();
	                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(PanelConductorAdicional.this);
	                frame.dispose(); 
	            }
	        });
	    }
	    
	    
	    public Persona quiereConductorAdicional() {
	    	if (noQuiereConductorAdicional == false) {
	    		return null;
	    	} else {
	    		String nombre = nombreField.getText();
	        	String telefono = telefonoField.getText();
	        	String fechaNacimiento = fechaNacimientoField.getText();
	        	String nacionalidad = nacionalidadField.getText();
	        	String direccionIdentidad = direccionIdentidadField.getText();
	        	File documentoIdentidad = new File(direccionIdentidad);
	        	String numeroLicencia = numeroLicenciaField.getText();
	        	String paisExp = paisExpedicionLicenciaField.getText();
	        	String direccionLicencia = direccionLicenciaField.getText();
	        	File licencia = new File(direccionLicencia);
	        	String fechaVencimiento = fechaVencimientoLicenciaField.getText();
	        	return new Persona(nombre, telefono, fechaNacimiento, nacionalidad, 
						documentoIdentidad, new DatosLicencia(numeroLicencia, paisExp, licencia, 
								fechaVencimiento));
	    	}
	    	
	    }
	
	

}
