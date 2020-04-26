package JDBC;

import Interfaces.IAuto;
import Clases.Auto;
import Clases.TallerMecanicoException;
import DBManager.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AutoDAOImpl implements IAuto {

	@Override
	public void crearAuto(String nombre) throws Exception {

		DBManager db = DBManager.getInstace();
		Connection c = db.connect();

		int autoInsertado = 0;

		try {
			Statement s = c.createStatement();
			String sql = "INSERT INTO autos (nombre) VALUES ('" + nombre + "')";
			autoInsertado = s.executeUpdate(sql);
			c.commit();

			if (autoInsertado == 0) {
				throw new TallerMecanicoException("AutoNotInserted");
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
	public void borrarAuto(int idAuto) throws Exception {
		String sql = "DELETE FROM autos WHERE id_auto = " + idAuto + "";

		DBManager db = DBManager.getInstace();
		Connection c = db.connect();

		int registrosBorrados = 0;

		try {
			Statement s = c.createStatement();
			registrosBorrados = s.executeUpdate(sql);
			c.commit();

			if (registrosBorrados == 0) {
				throw new TallerMecanicoException("AutoNotFound");
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
	public Auto buscarAuto(int idAuto) throws Exception {
		Auto auto = null;
		String sql = "SELECT * FROM autos WHERE id_auto = " + idAuto + "";
		
		DBManager db = DBManager.getInstace();
		Connection c = db.connect();
				
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next()) { 
				auto = new Auto(rs.getInt("id"), rs.getString("nombre"));
			}
			
			if(auto == null) {
				throw new TallerMecanicoException("AutoNotFound");
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
		return auto;
	}
}
