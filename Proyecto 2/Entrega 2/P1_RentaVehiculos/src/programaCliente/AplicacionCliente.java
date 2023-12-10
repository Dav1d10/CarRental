package programaCliente;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import administradorLocal.IngresoUsuario;
import interfaz.panelCliente;
import interfaz.panelLogin;
import modelo.RentaVehiculos;

public class AplicacionCliente extends JFrame {
	
	private static RentaVehiculos rentaVehiculos = new RentaVehiculos();
	private panelLogin panelLogin;
    private panelCliente panelCliente;
    private IngresoUsuario ingresoUsuario;
    

	
	public AplicacionCliente() {
		ingresoUsuario = new IngresoUsuario();
		setTitle("DGA RENTAL");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); 
        setLocationRelativeTo(null); 

        
        panelLogin = new panelLogin();
        panelCliente = new panelCliente(rentaVehiculos);
        
     
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);
        cardPanel.add(panelLogin, "login");
        cardPanel.add(panelCliente, "cliente");
        add(cardPanel, BorderLayout.CENTER);

       
        panelLogin.getLoginButton().addActionListener(e -> {
            String usuario = panelLogin.getUsuarioField().getText();
            String contrasena = new String(panelLogin.getContrasenaField().getPassword());
            if (ingresoUsuario.autenticarUsuario(usuario, contrasena)) {
            	if (ingresoUsuario.esAdmin(contrasena)) {
            		cardLayout.show(cardPanel, "login");
            	} else if (ingresoUsuario.esEmpleado(contrasena)) {
            		cardLayout.show(cardPanel, "login");
            	} else {
            		cardLayout.show(cardPanel, "cliente");
            	}
            	} else {
                System.out.println("Inicio de sesión fallido");
            }
        });
    }
	
	
	private static void cargarTemporada() {
		rentaVehiculos.cargarTemporada();
	}
	
	
	private static void cargarDatos() throws FileNotFoundException, IOException {
		rentaVehiculos.setAdministradorGeneral();
		File archivoInventario = new File("data/inventario.txt");
		File archivoSedes = new File("data/sedes.txt");
		rentaVehiculos.cargarInformacionInventario(archivoInventario, archivoSedes);
		cargarTemporada();
	}

	
    public static void main(String[] args) throws IOException{
    	try {
            cargarDatos();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            AplicacionCliente aplicacionCliente = new AplicacionCliente();
            aplicacionCliente.setVisible(true);
        });
    }

}
