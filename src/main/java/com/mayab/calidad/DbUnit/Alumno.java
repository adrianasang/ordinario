package com.mayab.calidad.DbUnit;

public class Alumno{
	
	private int id_alumno;
	private String nombre;
	private String lastname;
	private int edad;
	private float promedio;	
	/////////////
	
	public Alumno(int id_alumno, String nombre, String lastname, int edad, float promedio) {
		this.id_alumno=id_alumno;
		this.nombre=nombre;
		this.lastname=lastname;
		this.edad=edad;
		this.promedio=promedio;
	}
	
	public void setId_alumno(int id_alumno) {
		this.id_alumno=id_alumno;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public void setApellido(String apellido) {
		this.lastname=apellido;
	}
	public void setEdad(int edad) {
		this.edad=edad;
	}
	public void setPromedio(float promedio) {

		this.promedio=promedio;
	}

	public int getId_alumno() {
		return this.id_alumno;
	}
	public String getNombre() {
		return this.nombre;
	}
	public String getApellido() {
		return this.lastname;
	}
	public int getEdad() {
		return this.edad;
	}
	public float getPromedio() {

		return this.promedio;
	}
	
}//End alumno
