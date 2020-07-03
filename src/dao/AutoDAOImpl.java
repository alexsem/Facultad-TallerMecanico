package dao;

import entidades.Auto;
import exceptions.TallerMecanicoException;
import DBManager.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AutoDAOImpl implements IAuto {

	@Override
	public void crearAuto(String marca, String modelo, String duenio, String patente, int anio) throws TallerMecanicoException {

		DBManager db = DBManager.getInstace();
		Connection c = db.connect();

		int autoInsertado = 0;

		try {
			Statement s = c.createStatement();
			String sql = "INSERT INTO autos ([marca]" + 
					",[modelo]" + 
					",[duenio]" + 
					",[patente]" + 
					",[anio]" + 
					",[fecha_ingreso]" + 
					",[fecha_egreso]) VALUES ('" + marca + ", " + modelo + ", " + duenio + ", " + patente + ", " + anio + "')";
			autoInsertado = s.executeUpdate(sql);
			c.commit();

			if (autoInsertado == 0) {
				throw new TallerMecanicoException("AutoNotInserted");
			}

		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {} 
			
			throw new TallerMecanicoException("Hubo un error en la operacion: " + e.getMessage());
		
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				throw new TallerMecanicoException("SQLErrorWhileClosingConnection: " + e1.getMessage());
			}
		}
	}

	@Override
	public void borrarAuto(String patente) throws TallerMecanicoException {
		String sql = "DELETE FROM autos WHERE patente = " + patente + "";

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
			
			throw new TallerMecanicoException("Hubo un error en la operacion: " + e.getMessage());
		
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				throw new TallerMecanicoException("SQLErrorWhileClosingConnection: " + e1.getMessage());
			}
		}
	}

	@Override
	public Auto buscarAuto(String patente) throws TallerMecanicoException {
		Auto auto = null;
		String sql = "SELECT * FROM autos WHERE patente = " + patente + "";
		
		DBManager db = DBManager.getInstace();
		Connection c = db.connect();
				
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next()) { 
				auto = new Auto(rs.getInt("id_auto"), rs.getString("marca"), rs.getString("modelo"), rs.getString("duenio"), rs.getString("patente"), rs.getInt("anio"), null, null);
			}
			
			if(auto == null) {
				throw new TallerMecanicoException("AutoNotFound");
			}
			
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {} 
			
			throw new TallerMecanicoException("Hubo un error en la operacion: " + e.getMessage());
		
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				throw new TallerMecanicoException("SQLErrorWhileClosingConnection: " + e1.getMessage());
			}
		}
		return auto;
	}
}
