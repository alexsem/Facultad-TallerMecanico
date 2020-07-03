package test;

import dao.AutoPartesDAOImpl;
import dao.IAutoPartes;
import entidades.*;
import exceptions.TallerMecanicoException;
import utils.Dentre;

import java.util.ArrayList;

public class Test {
	
	static IAutoPartes autoParte = new AutoPartesDAOImpl();

	public static void main(String[] args) {

		boolean sigue = true;

		// AutoPartesDAOImpl autoPartesImpl = null;

		while (sigue) {

			System.out.println("\nOPCIONES AUTO PARTES:");
			System.out.println("1) Agregar Auto Parte");
			System.out.println("2) Buscar Auto Parte");
			System.out.println("3) Listar Auto Partes");
			System.out.println("4) Actualizar Auto Parte");
			System.out.println("5) Borrar Auto Parte");

			System.out.println("\n99) Salir");

			int opcion = Dentre.entero("Indique opcion: ");

			switch (opcion) {
			case 1:
				Test.insertarAutoParte();
				break;
			case 2:
				Test.buscarAutoParte();
				break;
			case 3:
				Test.listarAutoPartes();
				break;
			case 4:
				Test.actualizarAutoParteCantidad();
				break;
			case 5:
				Test.borrarAutoParte();
				break;
			case 99:
				System.out.println("Saliendo del sistema.");
				sigue = false;
				break;
			default:
				System.out.println("Opcion equivocada.");
			}

		}

	}

	private static void actualizarAutoParteCantidad() {
		int idAutoParte = 0;
		int nueva_cantidad;

		idAutoParte = Dentre.entero("Ingrese el ID de la auto parte: ");
		nueva_cantidad = Dentre.entero("Ingrese la nueva cantidad: ");
		/*
		try {
			autoParte.actualizarCantidadAutoParte(idAutoParte, nueva_cantidad);
		} catch (TallerMecanicoException e) {
			System.out.println("No se encontro el ID de la auto parte a eliminar" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Hubo un problema la base de datos" + e.getMessage());
		}
		*/

	}

	private static void borrarAutoParte() {
		int idAutoParte = 0;

		idAutoParte = Dentre.entero("Ingrese el ID de la auto parte a eliminar: ");

		try {
			autoParte.borrarAutoParte(idAutoParte);

			System.out.println("Se elimino la auto parte con ID: " + idAutoParte);

		} catch (TallerMecanicoException e) {
			System.out.println("No se encontro el ID de la auto parte a eliminar" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Hubo un problema la base de datos" + e.getMessage());
		}

	}

	private static void buscarAutoParte() {
		AutoPartes autoParteBuscada = null;
		int idAutoParte = 0;

		idAutoParte = Dentre.entero("Ingrese el ID de la auto parte: ");

		try {
			autoParteBuscada = autoParte.buscarAutoParte(idAutoParte);

			System.out.println("Se encontro la auto parte con ID: " + autoParteBuscada.getIdAutoPartes());
			System.out.println("Descripcion: " + autoParteBuscada.getDescripcion());
			System.out.println("Cantidad Disponible: " + autoParteBuscada.getCantidad());

		} catch (TallerMecanicoException e) {
			System.out.println("No se pudo encontrar el registro" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Hubo un error en la base de datos" + e.getMessage());
		}
	}

	private static void insertarAutoParte() {
		
		String descripcion = null;
		int cantidad_disponible = 0;
		float costo = 0;

		System.out.println("Ingrese los datos de la auto parte:");

		descripcion = Dentre.texto("Ingrese una descripcion: ");
		cantidad_disponible = Dentre.entero("Ingrese la cantidad a agregar: ");
		costo = Dentre.entero("Ingrese el costo: ");

		try {
			autoParte.insertarAutoParte(descripcion, cantidad_disponible, costo);
		} catch (TallerMecanicoException e) {
			System.out.println("No se pudo insertar el registro correctamente" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Hubo un error en la base de datos" + e.getMessage());
		}

	}

	private static void listarAutoPartes() {
		ArrayList<AutoPartes> listaAutoParte = new ArrayList<AutoPartes>();
		
		try {
			listaAutoParte = autoParte.listarAutoPartes();

			for (int i = 0; i < listaAutoParte.size(); i++) {
				System.out.println(listaAutoParte.get(i).getIdAutoPartes() + " "
						+ listaAutoParte.get(i).getDescripcion() + " " 
						+ listaAutoParte.get(i).getCantidad() + " "
						+ listaAutoParte.get(i).getCosto());
			}
		} catch (Exception e) {
			System.out.println("Hubo un error en la base de datos: " + e.getMessage());
		}

		return;
	}
}
