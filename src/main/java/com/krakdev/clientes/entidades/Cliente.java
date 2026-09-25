package com.krakdev.clientes.entidades;

public class Cliente {
	// Atributos
	private String cedula;
	private String nombre;
	private String apellido;
	private String mail;

	// contructor Vacio
	public Cliente() {

	}

	// contructor cón pararametros
	public Cliente(String cedula, String apellido, String nombre, String mail) {
		super();
		this.cedula = cedula;
		this.apellido = apellido;
		this.nombre = nombre;
		this.mail = mail;

	}

	// toStirng para sobre escribir
	@Override
	public String toString() {
		return "Cliente [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail + "]";
	}

	// Geter y Stter
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
