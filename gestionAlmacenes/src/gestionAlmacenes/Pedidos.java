package gestionAlmacenes;

import java.util.ArrayList;
import java.util.Date;

import gestionAlmacenes.Producto;

public class Pedidos {
	
	private ArrayList<Producto> productos;
	private int cantidad;
	private String calle;
	private int numero;
	private int cp;
	private String poblacion;
	private String pais;
	private String destinatario;
	private Date fechaEntrega;
	
	
	public Pedidos(ArrayList<Producto> productos, int cantidad, String calle, int numero, int cp, String poblacion,
			String pais, String destinatario, Date fechaEntrega) {
		super();
		this.productos = productos;
		this.cantidad = cantidad;
		this.calle = calle;
		this.numero = numero;
		this.cp = cp;
		this.poblacion = poblacion;
		this.pais = pais;
		this.destinatario = destinatario;
		this.fechaEntrega = fechaEntrega;
	}


	public ArrayList<Producto> getProductos() {
		return productos;
	}


	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public String getCalle() {
		return calle;
	}


	public void setCalle(String calle) {
		this.calle = calle;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public int getCp() {
		return cp;
	}


	public void setCp(int cp) {
		this.cp = cp;
	}


	public String getPoblacion() {
		return poblacion;
	}


	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	public String getDestinatario() {
		return destinatario;
	}


	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}


	public Date getFechaEntrega() {
		return fechaEntrega;
	}


	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	
	
	
}
