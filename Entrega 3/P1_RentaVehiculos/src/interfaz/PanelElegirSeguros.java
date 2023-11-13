package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import modelo.AdministradorGeneral;
import modelo.RentaVehiculos;

public class PanelElegirSeguros extends JPanel {
	
	private Map<String, Integer> mapa;
	private AdministradorGeneral admin;
    private Map<String, JCheckBox> checkBoxes;
    private JButton guardarButton;
    private static List<String> segurosSeleccionados;
    private static RentaVehiculos rentaVehiculos = new RentaVehiculos();

    public PanelElegirSeguros(Map<String, Integer> seguros) {
        this.mapa = seguros;
        this.segurosSeleccionados = new ArrayList<>();
        setLayout(new GridLayout(seguros.size() + 1, 1));

        checkBoxes = new HashMap<>();

        for (Map.Entry<String, Integer> entry : seguros.entrySet()) {
            String nombreSeguro = entry.getKey();
            JCheckBox checkBox = new JCheckBox(nombreSeguro + " - $" + entry.getValue());
            checkBoxes.put(nombreSeguro, checkBox);
            add(checkBox);

            checkBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    actualizarSegurosSeleccionados();
                }
            });
        }

        guardarButton = new JButton("Guardar");
        add(guardarButton);

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obtenerSegurosSeleccionados();
            }
        });
    }

    private void actualizarSegurosSeleccionados() {
        segurosSeleccionados.clear(); // Limpiar la lista antes de actualizarla

        for (Map.Entry<String, JCheckBox> entry : checkBoxes.entrySet()) {
            String nombreSeguro = entry.getKey();
            JCheckBox checkBox = entry.getValue();

            if (checkBox.isSelected()) {
                segurosSeleccionados.add(nombreSeguro);
            }
        }
    }

    private void obtenerSegurosSeleccionados() {
        // Lógica para utilizar la lista de seguros seleccionados
        for (String seguro : segurosSeleccionados) {
            System.out.println("Seguro seleccionado: " + seguro);
        }
    }

    // Método para obtener la lista de seguros seleccionados
    public static List<String> getSegurosSeleccionados() {
        return new ArrayList<>(segurosSeleccionados);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Panel Elegir Seguros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rentaVehiculos.setAdministradorGeneral();
        rentaVehiculos.AgregarSeguroaMapa();
        Map<String, Integer> seguros = rentaVehiculos.getSeguros();
        PanelElegirSeguros panelSeguros = new PanelElegirSeguros(seguros);
        frame.getContentPane().add(panelSeguros, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
    
	

