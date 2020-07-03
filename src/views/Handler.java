package views;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dao.AutoPartesDAOImpl;
import entidades.AutoPartes;
import exceptions.TallerMecanicoException;
import services.AutoPartesBO;
import utils.Helper;

public class Handler {
	
	private AutoPartesBO autoPartes;

	public Handler () {
		autoPartes = new AutoPartesBO();
		autoPartes.setAutoParte(new AutoPartesDAOImpl());
	}
	
	public void insertarAutoPartesHandler(String descripcion, String cantidad, String costo) {
		try {
			autoPartes.insertarAutoParteBO(descripcion, cantidad, costo);
		} catch (TallerMecanicoException e) {
			Helper.messageBox(e);
		}
	}
	
	public void actualizarAutoPartesHandler(String id, String descripcion, String cantidad, String costo) {
		try {
			autoPartes.actualizarAutoParteBO(id, descripcion, cantidad, costo);
		} catch (TallerMecanicoException e) {
			Helper.messageBox(e);
		}
	}
	
	public ArrayList<String[]> listarAutoPartesHandler(){
		ArrayList<String[]> listaAutoPartes = null;
		
		try {
			listaAutoPartes = autoPartes.listarAutoParteBO();
		} catch (TallerMecanicoException e) {
			Helper.messageBox(e);
		}
		
		return listaAutoPartes;
	}
	
	public AutoPartes buscarAutoParte(String id) {
		
		return null;
	}
	
	public boolean borrarAutoParte(String idAutoParte) {
		
		try {
			autoPartes.borrarXboAutoParte(idAutoParte);
		} catch (TallerMecanicoException e) {
			Helper.messageBox(e);
		}
		return true;
	}
	
    public static void cambiarPanel(JFrame frame, JPanel panel) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.getContentPane().validate();
    }
}
