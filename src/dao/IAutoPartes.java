package dao;

import java.util.ArrayList;

import entidades.AutoPartes;
import exceptions.TallerMecanicoException;

public interface IAutoPartes {

	public void insertarAutoParte(String descripcion, int cantidad, float costo) throws TallerMecanicoException;

	public void borrarAutoParte(int idAutoParte) throws TallerMecanicoException;

	public AutoPartes buscarAutoParte(int idAutoParte) throws TallerMecanicoException;
	
	public ArrayList<AutoPartes> listarAutoPartes () throws TallerMecanicoException;
	
	public int actualizarCantidadAutoParte(int idAutoParte, String descripcion, int cantidad, float costo) throws TallerMecanicoException;

}
