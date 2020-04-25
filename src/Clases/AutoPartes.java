package Clases;

public class AutoPartes {
	
	private int idAutoPartes;
	private String descripcion;
	private int	cantidad;
	
	public AutoPartes(int idAutoPartes, String descripcion, int cantidad) {
		this.idAutoPartes = idAutoPartes;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
	}
	
	public int getIdAutoPartes() {
		return idAutoPartes;
	}

	public void setIdAutoPartes(int idAutoPartes) {
		this.idAutoPartes = idAutoPartes;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
