package entidades;

import java.sql.Date;

public class Reparacion {

	private int id_reparacion;
	private int id_auto;
	private int id_auto_partes;
	private int cantidad_usada;
	private Date fecha_de_uso;
	private String tarea_descripcion;
	private float valor_reparacion;
	
	public Reparacion(int id_reparacion, int id_auto, int id_auto_partes, int cantidad_usada, Date fecha_de_uso,
			String tarea_descripcion, float valor_reparacion) {
		super();
		this.id_reparacion = id_reparacion;
		this.id_auto = id_auto;
		this.id_auto_partes = id_auto_partes;
		this.cantidad_usada = cantidad_usada;
		this.fecha_de_uso = fecha_de_uso;
		this.tarea_descripcion = tarea_descripcion;
		this.valor_reparacion = valor_reparacion;
	}

	public int getId_reparacion() {
		return id_reparacion;
	}

	public void setId_reparacion(int id_reparacion) {
		this.id_reparacion = id_reparacion;
	}

	public int getId_auto() {
		return id_auto;
	}

	public void setId_auto(int id_auto) {
		this.id_auto = id_auto;
	}

	public int getId_auto_partes() {
		return id_auto_partes;
	}

	public void setId_auto_partes(int id_auto_partes) {
		this.id_auto_partes = id_auto_partes;
	}

	public int getCantidad_usada() {
		return cantidad_usada;
	}

	public void setCantidad_usada(int cantidad_usada) {
		this.cantidad_usada = cantidad_usada;
	}

	public Date getFecha_de_uso() {
		return fecha_de_uso;
	}

	public void setFecha_de_uso(Date fecha_de_uso) {
		this.fecha_de_uso = fecha_de_uso;
	}

	public String getTarea_descripcion() {
		return tarea_descripcion;
	}

	public void setTarea_descripcion(String tarea_descripcion) {
		this.tarea_descripcion = tarea_descripcion;
	}

	public float getValor_reparacion() {
		return valor_reparacion;
	}

	public void setValor_reparacion(float valor_reparacion) {
		this.valor_reparacion = valor_reparacion;
	}
	
	
}
