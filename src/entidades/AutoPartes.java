package entidades;

public class AutoPartes {
	
	private int idAutoPartes;
	private String descripcion;
	private int	cantidad;
	private float costo;
	
	public AutoPartes(int idAutoPartes, String descripcion, int cantidad, float costo) {
		this.idAutoPartes = idAutoPartes;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.costo = costo;
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
	
	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}
	
	public String[] autoParteToString() {
		String[] autoParte = new String[4];
		
		autoParte[0] = String.valueOf(this.getIdAutoPartes());
		autoParte[1] = String.valueOf(this.getDescripcion());
		autoParte[2] = String.valueOf(this.getCantidad());
		autoParte[3] = String.valueOf(this.getCosto());
		
		return autoParte;
	}
	
}
