package Interfaces;

import Clases.Auto;

public interface IAuto {

	public void crearAuto(String nombre) throws Exception;
	public void borrarAuto(int idAuto) throws Exception;
	public Auto buscarAuto(int idAuto) throws Exception;
	
}
