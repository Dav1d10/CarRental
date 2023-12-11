package interfaz;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class panelMostrarSedes extends JFrame{

	private JTextArea areaTexto;
	
	public panelMostrarSedes() {
        areaTexto = new JTextArea();
        add(areaTexto);

        setTitle("Información de Sedes");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void mostrarInformacion(String informacion) {
        areaTexto.setText(informacion);
        setVisible(true);
    }


   
}