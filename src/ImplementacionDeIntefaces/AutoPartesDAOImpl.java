package ImplementacionDeIntefaces;

import Interfaces.IAutoPartes;
import Clases.AutoPartes;
import DBManager.DBManager;
import Clases.MyException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AutoPartesDAOImpl implements IAutoPartes {

	@Override
	public void insertarAutoParte(String descripcion, int cantidad) throws Exception{
		Connection c = DBManager.connect();
		int registrosInsertados = 0;

		try {
			Statement s = c.createStatement();
			String sql = "INSERT INTO dbo.auto_partes (descripcion, cantidad_disponible) VALUES ('" + descripcion
					+ "', " + cantidad + ")";
			registrosInsertados = s.executeUpdate(sql);
			c.commit();
			if (registrosInsertados == 0) {
				throw new MyException("AutoParteNotInserted");
			}
		} catch (SQLException e) {
			try {
				c.rollback();
				throw new Exception("SQLTransactionRolledBack");
			} catch (SQLException e1) {
				throw new Exception("SQLErrorWhileRollingBack");
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				throw new Exception("SQLErrorWhileClosingConnection");
			}
		}
	}

	@Override
	public void borrarAutoParte(int idAutoParte) throws Exception{
		Connection c = DBManager.connect();
		int registrosBorrados = 0;

		try {
			Statement s = c.createStatement();
			String sql = "DELETE FROM dbo.auto_partes WHERE id_auto_partes = " + idAutoParte + "";
			registrosBorrados = s.executeUpdate(sql);
			c.commit();
			if (registrosBorrados == 0) {
				throw new MyException("AutoParteNotFound");
			}
		} catch (SQLException e) {
			try {
				c.rollback();
				throw new Exception("SQLTransactionRolledBack");
			} catch (SQLException e1) {
				throw new Exception("SQLErrorWhileRollingBack");
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				throw new Exception("SQLErrorWhileClosingConnection");
			}
		}
	}

	@Override
	public AutoPartes buscarAutoParte(int idAutoParte) throws Exception {
		AutoPartes autoPartes = null;
		String sql = "SELECT id_auto_partes, descripcion, cantidad_disponible FROM dbo.auto_partes WHERE id_auto_partes = '"
				+ idAutoParte + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				autoPartes = new AutoPartes(rs.getInt("id_auto_partes"), rs.getString("descripcion"),
						rs.getInt("cantidad_disponible"));
			}

			if (autoPartes == null) {
				throw new MyException("AutoPartesNotFound");
			}
		} catch (SQLException e) {
			try {
				c.rollback();
				throw new Exception("SQLTransactionRolledBack");
			} catch (SQLException e1) {
				throw new Exception("SQLErrorWhileRollingBack");
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				throw new Exception("SQLErrorWhileClosingConnection");
			}
		}

		return autoPartes;
	}

	@Override
	public ArrayList<AutoPartes> listarAutoPartes() throws Exception {
		ArrayList<AutoPartes> listaAutoPartes = new ArrayList<AutoPartes>();
		String sql = "SELECT id_auto_partes, descripcion, cantidad_disponible FROM dbo.auto_partes";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				listaAutoPartes.add(new AutoPartes(rs.getInt("id_auto_partes"), rs.getString("descripcion"),
						rs.getInt("cantidad_disponible")));
			}

			if (listaAutoPartes.isEmpty()) {
				throw new MyException("AutoPartesNotFound");
			}
		} catch (SQLException e) {
			try {
				c.rollback();
				throw new Exception("SQLTransactionRolledBack");
			} catch (SQLException e1) {
				throw new Exception("SQLErrorWhileRollingBack");
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				throw new Exception("SQLErrorWhileClosingConnection");
			}
		}

		return listaAutoPartes;
	}

	@Override
	public int actualizarCantidadAutoParte(int idAutoParte, int nueva_cantidad) throws Exception {
		Connection c = DBManager.connect();
		int registrosActualizados = 0;

		try {
			Statement s = c.createStatement();
			String sql = "UPDATE dbo.auto_partes SET cantidad_disponible = " + nueva_cantidad
					+ " WHERE id_auto_partes = " + idAutoParte + "";
			registrosActualizados = s.executeUpdate(sql);
			c.commit();
			if (registrosActualizados == 0) {
				throw new MyException("AutoPartesNotFound");
			}
		} catch (SQLException e) {
			try {
				c.rollback();
				throw new Exception("SQLTransactionRolledBack");
			} catch (SQLException e1) {
				throw new Exception("SQLErrorWhileRollingBack");
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				throw new Exception("SQLErrorWhileClosingConnection");
			}
		}

		return registrosActualizados;

	}
}
