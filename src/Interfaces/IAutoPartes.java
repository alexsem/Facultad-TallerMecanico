package Interfaces;

import java.util.ArrayList;

import Clases.AutoPartes;

public interface IAutoPartes {

	public void insertarAutoParte(String descripcion, int cantidad) throws Exception;

	public void borrarAutoParte(int idAutoParte) throws Exception;

	public AutoPartes buscarAutoParte(int idAutoParte) throws Exception;
	
	public ArrayList<AutoPartes> listarAutoPartes () throws Exception;
	
	public int actualizarCantidadAutoParte(int idAutoParte, int nueva_cantidad) throws Exception;

}
