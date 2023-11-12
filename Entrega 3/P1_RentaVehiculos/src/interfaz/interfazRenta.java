package interfaz;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import administradorLocal.IngresoUsuario;

public class interfazRenta extends JFrame {
	
	private panelLogin panelLogin;
    private panelCliente panelCliente;
    private panelAdmin panelAdmin;
    private IngresoUsuario ingresoUsuario;

	
	public interfazRenta() {
		ingresoUsuario = new IngresoUsuario();
		setTitle("DGA RENTAL");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // Establece el tamaño del marco según tus necesidades
        setLocationRelativeTo(null); // Centra el marco en la pantalla

        // Inicializa los paneles
        panelLogin = new panelLogin();
        panelCliente = new panelCliente();
        panelAdmin = new panelAdmin();

        // Añade los paneles al marco con CardLayout
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);
        cardPanel.add(panelLogin, "login");
        cardPanel.add(panelCliente, "cliente");
        cardPanel.add(panelAdmin, "admin");

        add(cardPanel, BorderLayout.CENTER);

        // Agrega un ActionListener al botón de inicio de sesión en PanelLogin
        panelLogin.getLoginButton().addActionListener(e -> {
            String usuario = panelLogin.getUsuarioField().getText();
            String contrasena = new String(panelLogin.getContrasenaField().getPassword());

            if (ingresoUsuario.autenticarUsuario(usuario, contrasena)) {
                if (ingresoUsuario.esAdmin(contrasena)) {
                    cardLayout.show(cardPanel, "admin");
                } else {
                    cardLayout.show(cardPanel, "cliente");
                }
            } else {
                // Lógica si la autenticación falla
                System.out.println("Inicio de sesión fallido");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            interfazRenta interfazRenta = new interfazRenta();
            interfazRenta.setVisible(true);
        });
    }
}
