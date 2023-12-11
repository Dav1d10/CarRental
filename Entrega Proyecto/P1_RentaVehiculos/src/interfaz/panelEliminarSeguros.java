package interfaz;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import modelo.RentaVehiculos;

public class panelEliminarSeguros extends JPanel {

    private JButton btnSi;
    private JButton btnNo;

    public panelEliminarSeguros() {

        JLabel lblAdvertencia = new JLabel("¿Esta seguro de que quiere eliminar todos los seguros?");
        lblAdvertencia.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblAdvertencia);

        setLayout(new GridLayout(4, 2, 10, 10));

        btnSi = new JButton("Si");
        btnNo = new JButton("No");

        btnSi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    RentaVehiculos rentaVehiculos = new RentaVehiculos();
                    rentaVehiculos.setAdministradorGeneral();
                    rentaVehiculos.resetearMapa();
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }
            }
        });

        add(btnSi);

        btnNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panelEliminarSeguros.this);
                frame.dispose();
            }
        });

        add(btnNo);
    }

    
}
