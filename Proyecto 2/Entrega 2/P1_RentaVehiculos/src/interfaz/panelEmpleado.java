package interfaz;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class panelEmpleado extends JPanel {

    private JButton mostrarSedesButton;
    private JButton devolverCarroButton;
    private JButton salirButton;

    public panelEmpleado() {
        initComponents();
        addComponents();
        addActionListeners();
    }

    private void initComponents() {
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        JLabel tituloLabel = new JLabel("Bienvenido Empleado");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));

        mostrarSedesButton = new JButton("Mostrar sedes");
        devolverCarroButton = new JButton("Devolver carro");
        salirButton = new JButton("Salir");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 20, 20, 20);
        add(tituloLabel, gbc);
        
        devolverCarroButton = new JButton("Devolver Carro");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(devolverCarroButton, gbc);
        
        devolverCarroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	abrirPanelDevolverCarro();
            }
        });
    }
    
    private void abrirPanelDevolverCarro() {
        
        JFrame frame = new JFrame("Devolver carro");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new panelDevolverCarro());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void addComponents() {
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(mostrarSedesButton, gbc);

        gbc.gridx = 1;
        add(devolverCarroButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(salirButton, gbc);
    }

    private void addActionListeners() {
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panelEmpleado.this);
                frame.dispose();
            }
        });

        mostrarSedesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarSedes();
            }
        });
    }

    private void mostrarSedes() {
        try {
            String informacionSedes = obtenerInformacionDelArchivo("data/sedes.txt");
            panelMostrarSedes ventanaSedes = new panelMostrarSedes();
            ventanaSedes.mostrarInformacion(informacionSedes);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo de sedes.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String obtenerInformacionDelArchivo(String nombreArchivo) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
            	String[] lista = linea.split(";");
            	String sedeActual = "Nombre: " + lista[0] + ", Ubicacion: " + lista[1] + ", Horario de atencion: " + lista[2] + ".";
                sb.append(sedeActual).append("\n");
            }
        }
        return sb.toString();
    }

   
}