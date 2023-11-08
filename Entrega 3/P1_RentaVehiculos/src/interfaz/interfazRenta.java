package interfaz;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class interfazRenta extends JFrame {

	
	public interfazRenta() {
		setTitle("DGA Rental");
		setSize(700,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
			interfazRenta i = new interfazRenta();
			i.setVisible(true);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
