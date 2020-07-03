package entidades;

import java.sql.Date;
import java.util.List;

public class Factura {
	private int idFactura;
	private Date fecha;
	private float total_facturado;
	private List<Reparacion> listaReparacion;
	
	public Factura(int idFactura, Date fecha, float total_facturado, List<Reparacion> listaReparacion) {
		super();
		this.idFactura = idFactura;
		this.fecha = fecha;
		this.total_facturado = total_facturado;
		this.listaReparacion = listaReparacion;
	}
	
	
}
