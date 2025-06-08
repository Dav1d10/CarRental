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

public class panelNuevaSede extends JPanel {
	
	private JTextField nombre;
    private JTextField ubicacion;
    private JTextField horarioAtencion;
    private JButton btnGuardar;
    
    public panelNuevaSede() {

    	nombre = new JTextField(20);
        ubicacion = new JTextField(20);
        horarioAtencion = new JTextField(20);
        btnGuardar = new JButton("Guardar");
        
        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel lblNombre = new JLabel("Ingrese el nombre de la sede:");
        lblNombre.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblNombre);

        add(nombre);

        JLabel lblUbicacion = new JLabel("Ingrese la ubicación de la sede:");
        lblUbicacion.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblUbicacion);

        add(ubicacion);
        
        JLabel lblHorarioAtencion = new JLabel("Ingrese los horarios de atención de la sede:");
        lblHorarioAtencion.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblHorarioAtencion);

        add(horarioAtencion);

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombreSede = nombre.getText().toUpperCase();
                    String ubicacionSede = ubicacion.getText().toUpperCase();
                    String horarioAtencionSede = horarioAtencion.getText();
                    RentaVehiculos rentaVehiculos = new RentaVehiculos();
                    rentaVehiculos.setAdministradorGeneral();
                    rentaVehiculos.agregarSede(nombreSede, ubicacionSede, horarioAtencionSede);
                    
                    nombre.setText("");
                    ubicacion.setText("");
                    horarioAtencion.setText("");

                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panelNuevaSede.this);
                frame.dispose();
            }
        });

        add(btnGuardar);
    }

	public JTextField getNombre() {
		return nombre;
	}

	public void setNombre(JTextField nombre) {
		this.nombre = nombre;
	}

	public JTextField getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(JTextField ubicacion) {
		this.ubicacion = ubicacion;
	}

	public JTextField getHorarioAtencion() {
		return horarioAtencion;
	}

	public void setHorarioAtencion(JTextField horarioAtencion) {
		this.horarioAtencion = horarioAtencion;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	
}
