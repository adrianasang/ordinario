package com.mayab.calidad.DbUnit;

public interface AlumnoDAO {
///////
	public void addAlumno(Alumno alumno);
	public void removeAlumno(Alumno alumno);
	public void updatePromedio(Alumno alumno,float promedio);
	public void getAll(); //aun no implementado

	
}
