package services;

import java.util.ArrayList;

import dao.IAutoPartes;
import entidades.AutoPartes;
import exceptions.TallerMecanicoException;

public class AutoPartesBO {
	
	private IAutoPartes autoParte;
	
	public void setAutoParte(IAutoPartes autoParte) {
		this.autoParte = autoParte;
	}
	
	public void insertarAutoParteBO (String descripcion, String cantidad, String costo) throws TallerMecanicoException {
			autoParte.insertarAutoParte(descripcion, Integer.parseInt(cantidad), Float.parseFloat(costo));
	}
	
	public void actualizarAutoParteBO (String idAutoParte, String descripcion, String cantidad, String costo) throws TallerMecanicoException {
			autoParte.actualizarCantidadAutoParte(Integer.parseInt(idAutoParte), descripcion, Integer.parseInt(cantidad), Float.parseFloat(costo));
	}
	
	public ArrayList<String[]> listarAutoParteBO () throws TallerMecanicoException {
		ArrayList <AutoPartes> listaAutoPartes = new ArrayList<AutoPartes>();
		
		ArrayList<String[]> listaAutoPartesToStrings = new ArrayList<String[]>();
		
		listaAutoPartes = autoParte.listarAutoPartes();
		
		for (int i = 0; i < listaAutoPartes.size(); i++) {
			listaAutoPartesToStrings.add(listaAutoPartes.get(i).autoParteToString());
		}
		
		return listaAutoPartesToStrings;
	}
	
	public void borrarXboAutoParte(String idAutoParte) throws TallerMecanicoException {
		autoParte.borrarAutoParte(Integer.parseInt(idAutoParte));
	}
}
