package test;

import ImplementacionDeIntefaces.*;
import Clases.*;
import Dentre.Dentre;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {

		boolean sigue = true;

		// AutoPartesDAOImpl autoPartesImpl = null;

		test menu = new test();

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
				test.insertarAutoParte();
				break;
			case 2:
				test.buscarAutoParte();
				break;
			case 3:
				menu.listarAutoPartes();
				break;
			case 4:
				test.actualizarAutoParte();
				break;
			case 5:
				test.borrarAutoParte();
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

	private static void actualizarAutoParte() {
		AutoPartesDAOImpl autoParteImpl = new AutoPartesDAOImpl();
		int idAutoParte = 0;
		int nueva_cantidad;

		idAutoParte = Dentre.entero("Ingrese el ID de la auto parte: ");
		nueva_cantidad = Dentre.entero("Ingrese la nueva cantidad: ");

		try {
			autoParteImpl.actualizarCantidadAutoParte(idAutoParte, nueva_cantidad);
		} catch (MyException e) {
			System.out.println("No se encontro el ID de la auto parte a eliminar");
		} catch (Exception e) {
			System.out.println("Hubo un problema la base de datos");
		}

	}

	private static void borrarAutoParte() {
		AutoPartesDAOImpl autoParteImpl = new AutoPartesDAOImpl();
		int idAutoParte = 0;

		idAutoParte = Dentre.entero("Ingrese el ID de la auto parte a eliminar: ");

		try {
			autoParteImpl.borrarAutoParte(idAutoParte);

			System.out.println("Se elimino la auto parte con ID: " + idAutoParte);

		} catch (MyException e) {
			System.out.println("No se encontro el ID de la auto parte a eliminar");
		} catch (Exception e) {
			System.out.println("Hubo un problema la base de datos");
		}

	}

	private static void buscarAutoParte() {
		AutoPartesDAOImpl autoParteImpl = new AutoPartesDAOImpl();
		AutoPartes autoParte = null;
		int idAutoParte = 0;

		idAutoParte = Dentre.entero("Ingrese el ID de la auto parte: ");

		try {
			autoParte = autoParteImpl.buscarAutoParte(idAutoParte);

			System.out.println("Se encontro la auto parte con ID: " + autoParte.getIdAutoPartes());
			System.out.println("Descripcion: " + autoParte.getDescripcion());
			System.out.println("Cantidad Disponible: " + autoParte.getCantidad());

		} catch (MyException e) {
			System.out.println("No se pudo encontrar el registro");
		} catch (Exception e) {
			System.out.println("Hubo un error en la base de datos");
		}
	}

	private static void insertarAutoParte() {
		AutoPartesDAOImpl autoParteImpl = new AutoPartesDAOImpl();

		String descripcion = null;
		int cantidad_disponible = 0;

		System.out.println("Ingrese los datos de la auto parte:");

		descripcion = Dentre.texto("Ingrese una descripcion: ");
		cantidad_disponible = Dentre.entero("Ingrese la cantidad a agregar: ");

		try {
			autoParteImpl.insertarAutoParte(descripcion, cantidad_disponible);
		} catch (MyException e) {
			System.out.println("No se pudo insertar el registro correctamente");
		} catch (Exception e) {
			System.out.println("Hubo un error en la base de datos");
		}

	}

	private void listarAutoPartes() {
		ArrayList<AutoPartes> listaAutoParte = new ArrayList<AutoPartes>();

		AutoPartesDAOImpl autoPartesImpl = new AutoPartesDAOImpl();

		try {
			listaAutoParte = autoPartesImpl.listarAutoPartes();

			for (int i = 0; i < listaAutoParte.size(); i++) {
				System.out.println(listaAutoParte.get(i).getIdAutoPartes() + " "
						+ listaAutoParte.get(i).getDescripcion() + " " + listaAutoParte.get(i).getCantidad());
			}
		} catch (Exception e) {
			System.out.println("Hubo un error en la base de datos");
		}

		return;
	}
}
