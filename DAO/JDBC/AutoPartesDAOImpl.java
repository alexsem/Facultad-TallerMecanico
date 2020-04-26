package JDBC;

import Interfaces.IAutoPartes;
import Clases.AutoPartes;
import DBManager.DBManager;
import Clases.TallerMecanicoException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AutoPartesDAOImpl implements IAutoPartes {

	@Override
	public void insertarAutoParte(String descripcion, int cantidad) throws Exception{
		
		DBManager db = DBManager.getInstace();
		Connection c = db.connect();
				
		int registrosInsertados = 0;

		try {
			Statement s = c.createStatement();
			String sql = "INSERT INTO dbo.auto_partes (descripcion, cantidad_disponible) VALUES ('" + descripcion
					+ "', " + cantidad + ")";
			registrosInsertados = s.executeUpdate(sql);
			c.commit();
			if (registrosInsertados == 0) {
				throw new TallerMecanicoException("AutoParteNotInserted");
			}
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {} 
			
			throw new Exception("Hubo un error en la operacion: " + e.getMessage());
		
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				throw new Exception("SQLErrorWhileClosingConnection: " + e1.getMessage());
			}
		}
	}

	@Override
	public void borrarAutoParte(int idAutoParte) throws Exception{
		
		DBManager db = DBManager.getInstace();
		Connection c = db.connect();
				
		int registrosBorrados = 0;

		try {
			Statement s = c.createStatement();
			String sql = "DELETE FROM dbo.auto_partes WHERE id_auto_partes = " + idAutoParte + "";
			registrosBorrados = s.executeUpdate(sql);
			c.commit();
			if (registrosBorrados == 0) {
				throw new TallerMecanicoException("AutoParteNotFound");
			}
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {} 
			
			throw new Exception("Hubo un error en la operacion: " + e.getMessage());
		
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				throw new Exception("SQLErrorWhileClosingConnection: " + e1.getMessage());
			}
		}
	}

	@Override
	public AutoPartes buscarAutoParte(int idAutoParte) throws Exception {
		AutoPartes autoPartes = null;
		String sql = "SELECT id_auto_partes, descripcion, cantidad_disponible FROM dbo.auto_partes WHERE id_auto_partes = '"
				+ idAutoParte + "'";
		
		DBManager db = DBManager.getInstace();
		Connection c = db.connect();
				
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				autoPartes = new AutoPartes(rs.getInt("id_auto_partes"), rs.getString("descripcion"),
						rs.getInt("cantidad_disponible"));
			}

			if (autoPartes == null) {
				throw new TallerMecanicoException("AutoPartesNotFound");
			}
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {} 
			
			throw new Exception("Hubo un error en la operacion: " + e.getMessage());
		
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				throw new Exception("SQLErrorWhileClosingConnection: " + e1.getMessage());
			}
		}

		return autoPartes;
	}

	@Override
	public ArrayList<AutoPartes> listarAutoPartes() throws Exception {
		ArrayList<AutoPartes> listaAutoPartes = new ArrayList<AutoPartes>();
		String sql = "SELECT id_auto_partes, descripcion, cantidad_disponible FROM dbo.auto_partes";
		
		DBManager db = DBManager.getInstace();
		Connection c = db.connect();
				
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				listaAutoPartes.add(new AutoPartes(rs.getInt("id_auto_partes"), rs.getString("descripcion"),
						rs.getInt("cantidad_disponible")));
			}

			if (listaAutoPartes.isEmpty()) {
				throw new TallerMecanicoException("AutoPartesNotFound");
			}
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {} 
			
			throw new Exception("Hubo un error en la operacion: " + e.getMessage());
		
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				throw new Exception("SQLErrorWhileClosingConnection: " + e1.getMessage());
			}
		}

		return listaAutoPartes;
	}

	@Override
	public int actualizarCantidadAutoParte(int idAutoParte, int nueva_cantidad) throws Exception {
		
		DBManager db = DBManager.getInstace();
		Connection c = db.connect();
				
		int registrosActualizados = 0;

		try {
			Statement s = c.createStatement();
			String sql = "UPDATE dbo.auto_partes SET cantidad_disponible = " + nueva_cantidad
					+ " WHERE id_auto_partes = " + idAutoParte + "";
			registrosActualizados = s.executeUpdate(sql);
			c.commit();
			if (registrosActualizados == 0) {
				throw new TallerMecanicoException("AutoPartesNotFound");
			}
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {} 
			
			throw new Exception("Hubo un error en la operacion: " + e.getMessage());
		
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				throw new Exception("SQLErrorWhileClosingConnection: " + e1.getMessage());
			}
		}

		return registrosActualizados;

	}
}
