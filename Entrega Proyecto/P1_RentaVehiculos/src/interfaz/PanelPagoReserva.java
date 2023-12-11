package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import modelo.RentaVehiculos;

public class PanelPagoReserva extends JPanel {
	
	 private static RentaVehiculos rentaVehiculos;
	 private String tipo = "r";
	
	  public PanelPagoReserva(RentaVehiculos rentaVehiculos) {
		    this.rentaVehiculos = rentaVehiculos;
	        setLayout(new BorderLayout());
	        JPanel textoPanel = new JPanel();
	        JLabel textoLabel = new JLabel("Elija su método de pago");
	        textoLabel.setHorizontalAlignment(JLabel.CENTER);
	        textoPanel.add(textoLabel);
	        add(textoPanel, BorderLayout.CENTER);
	        JPanel botonesPanel = new JPanel(new GridLayout(5, 1));
	        JButton tarjetaButton = new JButton("Pago en tarjeta");
	        JButton paypalButton = new JButton("Paypal");
	        JButton sireButton = new JButton("Sire");
	        JButton payUButton = new JButton("PayU");
	        tarjetaButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                rentaVehiculos.AsignarEleccionPasarela(tipo, "archivo.ArchivoTarjeta");
	                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(PanelPagoReserva.this);
	                frame.dispose();
	            }
	        });
	        
	        paypalButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	rentaVehiculos.AsignarEleccionPasarela(tipo, "archivo.ArchivoPayPal");
	                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(PanelPagoReserva.this);
	                frame.dispose();
	            }
	        });
	        
	        sireButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                rentaVehiculos.AsignarEleccionPasarela(tipo, "archivo.ArchivoSire");
	                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(PanelPagoReserva.this);
	                frame.dispose();
	            }
	        });
	        
	        payUButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	rentaVehiculos.AsignarEleccionPasarela(tipo, "archivo.ArchivoPayU");
	                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(PanelPagoReserva.this);
	                frame.dispose();
	            }
	        });
	        botonesPanel.add(tarjetaButton);
	        botonesPanel.add(paypalButton);
	        botonesPanel.add(sireButton);
	        botonesPanel.add(payUButton);
	        add(botonesPanel, BorderLayout.SOUTH);
	    }

}
