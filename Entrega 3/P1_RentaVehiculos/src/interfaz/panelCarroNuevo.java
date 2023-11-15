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

public class panelCarroNuevo extends JPanel {

    private JTextField placa;
    private JTextField marca;
    private JTextField modelo;
    private JTextField color;
    private JTextField transmision;
    private JTextField capacidad;
    private JTextField tipo;
    private JTextField sede;
    private JButton btnGuardar;

    public panelCarroNuevo() {
        setLayout(new GridLayout(9, 2, 10, 10));

        JLabel lblPlaca = new JLabel("Placa del carro:");
        lblPlaca.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblPlaca);

        placa = new JTextField(20);
        add(placa);

        JLabel lblMarca = new JLabel("Marca del carro:");
        lblMarca.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblMarca);

        marca = new JTextField(20);
        add(marca);

        JLabel lblModelo = new JLabel("Modelo del carro:");
        lblModelo.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblModelo);

        modelo = new JTextField(20);
        add(modelo);

        JLabel lblColor = new JLabel("Color del carro:");
        lblColor.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblColor);

        color = new JTextField(20);
        add(color);

        JLabel lblTransmision = new JLabel("Tipo de transmisión del carro:");
        lblTransmision.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblTransmision);

        transmision = new JTextField(20);
        add(transmision);

        JLabel lblCapacidad = new JLabel("Capacidad de personas del carro:");
        lblCapacidad.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblCapacidad);

        capacidad = new JTextField(20);
        add(capacidad);

        JLabel lblTipo = new JLabel("Categoría del carro:");
        lblTipo.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblTipo);

        tipo = new JTextField(20);
        add(tipo);

        JLabel lblSede = new JLabel("Sede donde se guardará el carro:");
        lblSede.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblSede);

        sede = new JTextField(20);
        add(sede);

        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String placaCarro = placa.getText().toUpperCase();
                    String marcaCarro = marca.getText().toUpperCase();
                    String modeloCarro = modelo.getText();
                    String colorCarro = color.getText().toUpperCase();
                    String transmisionCarro = transmision.getText().toUpperCase();
                    String capacidadCarro = capacidad.getText();
                    String tipoCarro = tipo.getText().toUpperCase();
                    String sedeCarro = sede.getText().toUpperCase();

                    RentaVehiculos rentaVehiculos = new RentaVehiculos();
                    rentaVehiculos.setAdministradorGeneral();
                    rentaVehiculos.agregarArchivo(placaCarro, marcaCarro, modeloCarro, colorCarro, transmisionCarro,
                            capacidadCarro, tipoCarro, sedeCarro);
                    
                    placa.setText("");
                    marca.setText("");
                    modelo.setText("");
                    color.setText("");
                    transmision.setText("");
                    capacidad.setText("");
                    tipo.setText("");
                    sede.setText("");

                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panelCarroNuevo.this);
                frame.dispose();
            }
        });

        add(btnGuardar);
    }

    public JTextField getPlaca() {
        return placa;
    }

    public void setPlaca(JTextField placa) {
        this.placa = placa;
    }

    public JTextField getMarca() {
        return marca;
    }

    public void setMarca(JTextField marca) {
        this.marca = marca;
    }

    public JTextField getModelo() {
        return modelo;
    }

    public void setModelo(JTextField modelo) {
        this.modelo = modelo;
    }

    public JTextField getColor() {
        return color;
    }

    public void setColor(JTextField color) {
        this.color = color;
    }

    public JTextField getTransmision() {
        return transmision;
    }

    public void setTransmision(JTextField transmision) {
        this.transmision = transmision;
    }

    public JTextField getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(JTextField capacidad) {
        this.capacidad = capacidad;
    }

    public JTextField getTipo() {
        return tipo;
    }

    public void setTipo(JTextField tipo) {
        this.tipo = tipo;
    }

    public JTextField getSede() {
        return sede;
    }

    public void setSede(JTextField sede) {
        this.sede = sede;
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
                JFrame frame = new JFrame("Agregar Carro Nuevo");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new panelCarroNuevo());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
