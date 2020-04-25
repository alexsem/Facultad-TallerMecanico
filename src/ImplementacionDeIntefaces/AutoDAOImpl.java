package ImplementacionDeIntefaces;

import Interfaces.IAuto;
import Clases.Auto;
import DBManager.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AutoDAOImpl implements IAuto{

	@Override
	public void crearAuto(String nombre) {
		Connection c = DBManager.connect();

		try {
			Statement s = c.createStatement();
			String sql = "INSERT INTO autos (nombre) VALUES ('" + nombre + "')";
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	@Override
	public void borrarAuto(String nombre) {
		String sql = "DELETE FROM autos WHERE nombre = '" + nombre + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				//no hago nada
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				//no hago nada
			}
		}
	}
	
	@Override
	public Auto buscarAuto(String nombre) throws Exception {
		Auto auto = null;
		String sql = "SELECT * FROM autos WHERE nombre = '" + nombre + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next()) { 
				auto = new Auto(rs.getInt("id"), rs.getString("nombre"));
			}
			
			if(auto == null) {
				throw new Exception("AutoNotFound");
			}
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				//no hago nada
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				//no hago nada
			}
		}
		return auto;
	}
}
