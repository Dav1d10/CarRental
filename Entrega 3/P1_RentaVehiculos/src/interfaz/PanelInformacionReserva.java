package interfaz;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import modelo.Alquiler;
import modelo.Reserva;

public class PanelInformacionReserva extends JFrame {
	
	public PanelInformacionReserva(List<Reserva> reservas, String mensajeAdicional) {
        setTitle("Información de Reservas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        for (Reserva reserva : reservas) {
            textArea.append(reserva.toString() + "\n\n");
        }

        textArea.append("\n" + mensajeAdicional); 

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        setSize(500, 400); 
        setLocationRelativeTo(null); 
    }

   
    public PanelInformacionReserva() {
        
    }

    public void mostrarInformacionReserva(List<Reserva> reservas, String mensajeAdicional) {
        SwingUtilities.invokeLater(() -> {
            PanelInformacionReserva frame = new PanelInformacionReserva(reservas, mensajeAdicional);
            frame.setVisible(true);
        });
    }

}
