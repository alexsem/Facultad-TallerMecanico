package Interfaces;

import Clases.Auto;

public interface IAuto {

	public void crearAuto(String nombre);
	public void borrarAuto(String nombre);
	public Auto buscarAuto(String nombre) throws Exception;
	
}
