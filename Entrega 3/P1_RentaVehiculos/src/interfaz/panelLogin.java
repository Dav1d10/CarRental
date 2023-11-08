package interfaz;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class panelLogin extends JPanel {
	
	private JTextField usuarioField;
	private JPasswordField contrasenaField;
	private JButton loginButton;
	private JButton registroButton;
	
	public panelLogin() {
		setLayout(new GridLayout(4, 2, 10, 10));
		JLabel usuarioLabel = new JLabel("Usuario: ");
		usuarioField = new JTextField(20);
		JLabel contrasenaLabel = new JLabel("Contraseña: ");
		contrasenaField = new JPasswordField(20);
		loginButton = new JButton("Iniciar Sesión");
		registroButton = new JButton("Registrarse");
		add(usuarioLabel);
        add(usuarioField);
        add(contrasenaLabel);
        add(contrasenaField);
        add(new JLabel()); 
        add(loginButton);
        add(new JLabel()); 
        add(registroButton);
	}
	
	
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	        @Override
	        public void run() {
	            JFrame frame = new JFrame("Inicio de Sesión y Registro");
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.getContentPane().add(new panelLogin());
	            frame.pack();
	            frame.setLocationRelativeTo(null); 
	            frame.setVisible(true);
	        }
	    });
	}
}
