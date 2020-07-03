package dao;

import entidades.Auto;
import exceptions.TallerMecanicoException;

public interface IAuto {

	public void borrarAuto(String patente) throws TallerMecanicoException;
	public Auto buscarAuto(String patente) throws TallerMecanicoException;
	void crearAuto(String marca, String modelo, String duenio, String patente, int anio) throws TallerMecanicoException;
	
}
