package utils;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Helper {
	
	public static void messageBox(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public static void messageBox(Exception exception) {
		JOptionPane.showMessageDialog(null, exception.getMessage(), "" , JOptionPane.ERROR_MESSAGE);
		exception.printStackTrace();
	}
	
	public static int closeFrame(JFrame frame) {
		frame.getContentPane().removeAll();
		frame.dispose();
		
		return 1;
	}

	public static JFrame createNewFrame(JFrame frame, JPanel panel) {
		frame.setLayout(new FlowLayout(FlowLayout.LEFT));
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(Helper.closeFrame(frame));
        
        frame.getContentPane().add(panel);
        
		return frame;
	}
}
