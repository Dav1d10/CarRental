package interfaz;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import modelo.Alquiler;

public class PanelInformacionAlquiler extends JFrame {
		
	public PanelInformacionAlquiler(List<Alquiler> alquileres, String mensajeAdicional) {
        setTitle("Información de Alquileres");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        for (Alquiler alquiler : alquileres) {
            textArea.append(alquiler.toString() + "\n\n");
        }

        textArea.append("\n" + mensajeAdicional); 

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        setSize(500, 400); 
        setLocationRelativeTo(null); 
    }

   
    public PanelInformacionAlquiler() {
        
    }

    public void mostrarInformacionAlquiler(List<Alquiler> alquileres, String mensajeAdicional) {
        SwingUtilities.invokeLater(() -> {
            PanelInformacionAlquiler frame = new PanelInformacionAlquiler(alquileres, mensajeAdicional);
            frame.setVisible(true);
        });
    }
}
	
	


