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

public class panelEmpleado extends JPanel{
	
	private JButton mostrarSedes;
	private JButton devolverCarro;
	
	public panelEmpleado() {
		
		setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JLabel tituloLabel = new JLabel("Bienvenido Empleado");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 20, 20, 20);
        add(tituloLabel, gbc);
        
        JButton mostrarSedesButton = new JButton("Mostrar sedes");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(mostrarSedesButton, gbc);
        
        JButton devolverCarroButton = new JButton("Devolver carro");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(devolverCarroButton, gbc);
        
        JButton salirButton = new JButton("Salir");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(salirButton, gbc);

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panelEmpleado.this);
                frame.dispose();
            }
        });
		
	}
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Panel de Empleado");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new panelEmpleado());
                frame.pack();
                frame.setLocationRelativeTo(null); 
                frame.setVisible(true);
            }
        });
    }

}
