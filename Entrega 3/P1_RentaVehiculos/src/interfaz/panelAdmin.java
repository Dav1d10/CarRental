package interfaz;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class panelAdmin extends JPanel {
	
	public panelAdmin() {
		setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JLabel tituloLabel = new JLabel("Bienvenido Admin");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 20, 20, 20);
        add(tituloLabel, gbc);
        JButton manejarSegurosButton = new JButton("Manejar Seguros");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(manejarSegurosButton, gbc);

        manejarSegurosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });

        JButton elegirTemporadaButton = new JButton("Elegir Temporada");
        gbc.gridx = 1;
        add(elegirTemporadaButton, gbc);

        elegirTemporadaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });

        JButton agregarCarroNuevoButton = new JButton("Agregar Carro Nuevo");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(agregarCarroNuevoButton, gbc);

        agregarCarroNuevoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });

        JButton agregarSedeNuevaButton = new JButton("Agregar Sede Nueva");
        gbc.gridx = 1;
        add(agregarSedeNuevaButton, gbc);

        agregarSedeNuevaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        JButton eliminarSegurosButton = new JButton("Eliminar Seguros");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(eliminarSegurosButton, gbc);

        eliminarSegurosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        JButton salirButton = new JButton("Salir");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(salirButton, gbc);

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Panel de Administrador");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new panelAdmin());
                frame.pack();
                frame.setLocationRelativeTo(null); 
                frame.setVisible(true);
            }
        });
    }
}


