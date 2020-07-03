package entidades;

import java.sql.Date;

public class Auto {

	private int id;
	private String marca;
	private String modelo;
	private String duenio;
	private String patente;
	private int anio;
	private Date fecha_ingreso;
	private Date fecha_egreso;
	
	public Auto(int id, String marca, String modelo, String duenio, String patente, int anio, Date fecha_ingreso,
			Date fecha_egreso) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.duenio = duenio;
		this.patente = patente;
		this.anio = anio;
		this.fecha_ingreso = fecha_ingreso;
		this.fecha_egreso = fecha_egreso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDuenio() {
		return duenio;
	}

	public void setDuenio(String duenio) {
		this.duenio = duenio;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public Date getFecha_egreso() {
		return fecha_egreso;
	}

	public void setFecha_egreso(Date fecha_egreso) {
		this.fecha_egreso = fecha_egreso;
	}


	
}
