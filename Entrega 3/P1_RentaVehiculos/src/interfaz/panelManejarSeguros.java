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

public class panelManejarSeguros extends JPanel  {

    private JTextField nombreSeguro;
    private JTextField precioSeguro;
    private JButton btnGuardar;

    public panelManejarSeguros() {

        nombreSeguro = new JTextField(20);
        precioSeguro = new JTextField(20);
        btnGuardar = new JButton("Guardar");

        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel lblNombreSeguro = new JLabel("Ingrese el nombre del seguro que desea añadir:");
        lblNombreSeguro.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblNombreSeguro);

        add(nombreSeguro);

        JLabel lblPrecioSeguro = new JLabel("Ingrese el precio del seguro que desea añadir:");
        lblPrecioSeguro.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblPrecioSeguro);

        add(precioSeguro);

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = nombreSeguro.getText();
                    int precio = Integer.parseInt(precioSeguro.getText());
                    RentaVehiculos rentaVehiculos = new RentaVehiculos();
                    rentaVehiculos.setAdministradorGeneral();
                    rentaVehiculos.AgregarSeguro(nombre, precio);

                    nombreSeguro.setText("");
                    precioSeguro.setText("");

                } catch (NumberFormatException ex) {

                    ex.printStackTrace();
                }
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panelManejarSeguros.this);
                frame.dispose();
            }
        });

        add(btnGuardar);
    }

    public JTextField getNombreSeguro() {
        return nombreSeguro;
    }

    public void setNombreSeguro(JTextField nombreSeguro) {
        this.nombreSeguro = nombreSeguro;
    }

    public JTextField getPrecioSeguro() {
        return precioSeguro;
    }

    public void setPrecioSeguro(JTextField precioSeguro) {
        this.precioSeguro = precioSeguro;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Agregar Seguro");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new panelManejarSeguros());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
