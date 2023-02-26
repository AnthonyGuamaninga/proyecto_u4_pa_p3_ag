package com.example.demo.funcional;

public class Ciudadano {
	private String nombreCompleto;
	private String ciudad;
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	@Override
	public String toString() {
		return "Ciudadano [nombreCompleto=" + nombreCompleto + ", ciudad=" + ciudad + "]";
	}
	// SET Y GET
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
}
