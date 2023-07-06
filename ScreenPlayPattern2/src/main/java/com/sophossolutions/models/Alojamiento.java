package com.sophossolutions.models;

public class Alojamiento {
	
	String nombre;
	String calificacion;
	String precio;
	String comentarios;
	String Confort;
	
	public Alojamiento(String nombre, String calificacion, String precio, String comentarios, String confort) {
		super();
		this.nombre = nombre;
		this.calificacion = calificacion;
		this.precio = precio;
		this.comentarios = comentarios;
		Confort = confort;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getConfort() {
		return Confort;
	}

	public void setConfort(String confort) {
		Confort = confort;
	}
	
	
	
}
