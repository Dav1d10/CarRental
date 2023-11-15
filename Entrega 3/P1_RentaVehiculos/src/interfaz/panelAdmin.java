package interfaz;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import modelo.AdministradorGeneral;
import modelo.RentaVehiculos;

public class panelAdmin extends JPanel {
	
	private JButton manejarSegurosButton;
	private JButton elegirTemporadaButton;
	private JButton agregarCarroNuevoButton;
	private JButton agregarSedeNuevaButton;
	private JButton eliminarSegurosButton;
	private JButton salirButton;
	
	public JButton getManejarSegurosButton() {
		return manejarSegurosButton;
	}


	public void setManejarSegurosButton(JButton manejarSegurosButton) {
		this.manejarSegurosButton = manejarSegurosButton;
	}


	public JButton getElegirTemporadaButton() {
		return elegirTemporadaButton;
	}


	public void setElegirTemporadaButton(JButton elegirTemporadaButton) {
		this.elegirTemporadaButton = elegirTemporadaButton;
	}


	public JButton getAgregarCarroNuevoButton() {
		return agregarCarroNuevoButton;
	}


	public void setAgregarCarroNuevoButton(JButton agregarCarroNuevoButton) {
		this.agregarCarroNuevoButton = agregarCarroNuevoButton;
	}


	public JButton getAgregarSedeNuevaButton() {
		return agregarSedeNuevaButton;
	}


	public void setAgregarSedeNuevaButton(JButton agregarSedeNuevaButton) {
		this.agregarSedeNuevaButton = agregarSedeNuevaButton;
	}


	public JButton getEliminarSegurosButton() {
		return eliminarSegurosButton;
	}


	public void setEliminarSegurosButton(JButton eliminarSegurosButton) {
		this.eliminarSegurosButton = eliminarSegurosButton;
	}


	public JButton getSalirButton() {
		return salirButton;
	}


	public void setSalirButton(JButton salirButton) {
		this.salirButton = salirButton;
	}


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
        
        manejarSegurosButton = new JButton("Manejar Seguros");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(manejarSegurosButton, gbc);
        
        manejarSegurosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	abrirPanelManejarSeguros();
            }
        });

        elegirTemporadaButton = new JButton("Elegir Temporada");
        gbc.gridx = 1;
        add(elegirTemporadaButton, gbc);
        
        elegirTemporadaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	abrirPanelTemporada();
            }
        });

        agregarCarroNuevoButton = new JButton("Agregar Carro Nuevo");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(agregarCarroNuevoButton, gbc);
        
        agregarCarroNuevoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	abrirPanelCarroNuevo();
            }
        });

        agregarSedeNuevaButton = new JButton("Agregar Sede Nueva");
        gbc.gridx = 1;
        add(agregarSedeNuevaButton, gbc);
        
        agregarSedeNuevaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	abrirPanelNuevaSede();
            }
        });

        eliminarSegurosButton = new JButton("Eliminar Seguros");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(eliminarSegurosButton, gbc);
        
        eliminarSegurosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	abrirPanelEliminarSeguros();
            }
        });

        salirButton = new JButton("Salir");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(salirButton, gbc);

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panelAdmin.this);
                frame.dispose();
            }
        });
	}
	
	
	private void abrirPanelManejarSeguros() {
        
        JFrame frame = new JFrame("Manejar seguros");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new panelManejarSeguros());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
	
	private void abrirPanelTemporada() {
        
        JFrame frame = new JFrame("Elegir temporada");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new panelTemporada());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
	private void abrirPanelCarroNuevo() {
        
        JFrame frame = new JFrame("Agregar carro nuevo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new panelCarroNuevo());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
	
	private void abrirPanelNuevaSede() {
        
        JFrame frame = new JFrame("Agregar sede");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new panelNuevaSede());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

	private void abrirPanelEliminarSeguros() {
    
		JFrame frame = new JFrame("Eliminar seguros");
    	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	frame.getContentPane().add(new panelEliminarSeguros());
    	frame.pack();
    	frame.setLocationRelativeTo(null);
    	frame.setVisible(true);
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