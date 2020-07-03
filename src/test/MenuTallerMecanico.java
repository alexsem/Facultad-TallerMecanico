package test;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import views.AutoPartesPanel;
import views.Handler;

public class MenuTallerMecanico {
	
	private static JFrame frame;

	public static void main(String[] args) {
		
		frame = new JFrame("Taller Mecanico");
		frame.setLayout(new FlowLayout(FlowLayout.LEFT));
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        agregarMenu();
	}
	
    public static void agregarMenu() {
        JMenuBar menuBar = new JMenuBar();
		
		JMenu menuAutoPartes = new JMenu("Auto Partes");
		JMenu menuAutos = new JMenu("Autos");
		
		menuAutoPartes.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				System.out.println("Listar Auto Partes");
				
				AutoPartesPanel autoPartesPanel = new AutoPartesPanel(frame);
				
				Handler.cambiarPanel(frame, autoPartesPanel.listarAutoPartesPanel());
				frame.pack();
			}
			
			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		menuBar.add(menuAutoPartes);
		menuBar.add(menuAutos);
		
		frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }
}
