package interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import administradorLocal.IngresoUsuario;
import administradorLocal.RegistroUsuario;

public class panelLogin extends JPanel {
	
	private JTextField usuarioField;
	private JPasswordField contrasenaField;
	private JButton loginButton;
	private JButton registroButton;
	private IngresoUsuario ingresoUsuario;
	private RegistroUsuario registroUsuario;
	
	public panelLogin() {
		ingresoUsuario = new IngresoUsuario();
		registroUsuario = new RegistroUsuario();
		setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        JLabel usuarioLabel = new JLabel("Usuario:");
        usuarioField = new JTextField(20);
        JLabel contrasenaLabel = new JLabel("Contraseña:");
        contrasenaField = new JPasswordField(20);
        loginButton = new JButton("Iniciar Sesión");
        registroButton = new JButton("Registrarse");
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(usuarioLabel, gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(usuarioField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(contrasenaLabel, gbc);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(contrasenaField, gbc);
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(loginButton, gbc);
        gbc.gridy = 3;
        add(registroButton, gbc);
        
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioField.getText();
                String contrasena = new String(contrasenaField.getPassword());

                if (ingresoUsuario.autenticarUsuario(usuario, contrasena)) {
                    if (ingresoUsuario.esAdmin(contrasena)) {
                        
                        System.out.println("Inicio de sesión como admin");
                    } else {
                       
                        System.out.println("Inicio de sesión como cliente");
                    }
                } else {
                   
                    System.out.println("Inicio de sesión fallido");
                }
            }
        });

        registroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioField.getText();
                String contrasena = new String(contrasenaField.getPassword());

                boolean registrado = registroUsuario.registrarUsuario(usuario, contrasena);
                if (registrado) {
                 
                    System.out.println("Registro exitoso");
                } else {
                   
                    System.out.println("Registro fallido");
                }
            }
        });
    }
	
	
	public JButton getLoginButton() {
        return loginButton;
    }
	

	public JTextField getUsuarioField() {
		return usuarioField;
	}


	public void setUsuarioField(JTextField usuarioField) {
		this.usuarioField = usuarioField;
	}


	public JPasswordField getContrasenaField() {
		return contrasenaField;
	}


	public void setContrasenaField(JPasswordField contrasenaField) {
		this.contrasenaField = contrasenaField;
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
