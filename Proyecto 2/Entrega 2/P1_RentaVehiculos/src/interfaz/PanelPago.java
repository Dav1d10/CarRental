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

public class PanelPago extends JPanel {
	
	 private static RentaVehiculos rentaVehiculos;
	 private String tipo = "a";
	
	  public PanelPago(RentaVehiculos rentaVehiculos) {
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
	        JButton efectivoButton = new JButton("Efectivo");
	        JButton payUButton = new JButton("PayU");
	        tarjetaButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Lógica 
	            }
	        });
	        
	        paypalButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Lógica 
	            }
	        });
	        
	        sireButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                rentaVehiculos.AsignarEleccionPasarela(tipo, "archivo.ArchivoSire");
	                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(PanelPago.this);
	                frame.dispose();
	            }
	        });
	        
	        efectivoButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Lógica 
	            }
	        });

	        payUButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Lógica 
	            }
	        });
	        botonesPanel.add(tarjetaButton);
	        botonesPanel.add(paypalButton);
	        botonesPanel.add(sireButton);
	        botonesPanel.add(efectivoButton);
	        botonesPanel.add(payUButton);
	        add(botonesPanel, BorderLayout.SOUTH);
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                JFrame frame = new JFrame("Panel de Pago");
	                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                frame.getContentPane().add(new PanelPago(rentaVehiculos));
	                frame.setSize(300, 200);
	                frame.setLocationRelativeTo(null);
	                frame.setVisible(true);
	            }
	        });
	    }
	
	

}
