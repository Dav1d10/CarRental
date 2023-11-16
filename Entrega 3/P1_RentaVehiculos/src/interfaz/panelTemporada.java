package interfaz;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import modelo.RentaVehiculos;

public class panelTemporada extends JPanel {
	
	private JTextField temporada;
	private JButton btnGuardar;
    private String temporadaSeleccionada;

    public panelTemporada() {

        JLabel lblTitulo = new JLabel("Elegir temporada");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(lblTitulo);
        
        temporada = new JTextField(20);
        btnGuardar = new JButton("Guardar");
        
        setLayout(new GridLayout(4, 2, 10, 10));
        
        JLabel lblTemporada = new JLabel("Ingrese la temporada(baja, media, alta):");
        lblTemporada.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblTemporada);

        add(temporada);

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                	
                    String nombre = temporada.getText().toUpperCase();

                    if (nombre.equals("ALTA") || nombre.equals("MEDIA") || nombre.equals("BAJA")) {
                        temporadaSeleccionada = nombre;

                        RentaVehiculos rentaVehiculos = new RentaVehiculos();
                        rentaVehiculos.setAdministradorGeneral();
                        rentaVehiculos.resetearTemporada();
                        rentaVehiculos.cambiarTemporada(temporadaSeleccionada);
                        
                        temporada.setText("");
                    } else {
                        
                        System.out.println("Error: La temporada debe ser 'alta', 'media' o 'baja'.");
                    }

                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panelTemporada.this);
                frame.dispose();
            }
        });
        
        add(btnGuardar);
    }

    public String getTemporada() {
        return temporadaSeleccionada;
    }

   
}