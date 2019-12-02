package com.mayab.calidad.DbUnit;

////////

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AlumnoDB implements AlumnoDAO{
	
	String driver = "com.mysql.cj.jdbc.Driver";
	String URL =  "jdbc:mysql://localhost:3306/bdcalidad"+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String user="root";
	String password="AdriSan";
	
	
	public void addAlumno(Alumno alumno) {
		try {
			Class.forName(driver);
		    Connection conn = DriverManager.getConnection(URL, user, password);
		    Statement st;
			st = conn.createStatement();
			 
			String query = "INSERT INTO alumno(id_alumno, nombre, apellido, edad, promedio) VALUES ("
							+Integer.toString(alumno.getId_alumno())+","
					 		+"'"+alumno.getNombre()+"'"+","
					 		+"'"+alumno.getApellido()+"'"+","
				 		    +Integer.toString(alumno.getEdad())+","
				 		    +Float.toString(alumno.getPromedio())+");";	
			System.out.println(query); 
			st.execute(query);
	        conn.close();		    
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	public void removeAlumno(Alumno alumno) {
		try {
			Class.forName(driver);
		    Connection conn = DriverManager.getConnection(URL, user, password);
		    Statement st;
			st = conn.createStatement();
			 
			String query = "DELETE FROM alumno WHERE id_alumno="
					 		+Integer.toString(alumno.getId_alumno())+";";	
			System.out.println(query); 
			st.execute(query);
	        conn.close();		    
		}catch(Exception e) {
			e.printStackTrace();
		}					
	}
	public void updatePromedio(Alumno alumno,float promedio) {
		try {
			Class.forName(driver);
		    Connection conn = DriverManager.getConnection(URL, user, password);
		    Statement st;
			st = conn.createStatement();
			 
			String query ="UPDATE alumno SET promedio="
						   +Float.toString(promedio)
					       +" WHERE id_alumno="
					 	   +Integer.toString(alumno.getId_alumno())+";";	
			System.out.println(query); 
			st.execute(query);
	        conn.close();		    
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void getAll() {
		try {
			Class.forName(driver);
		    Connection conn = DriverManager.getConnection(URL, user, password);
		    Statement st;
			st = conn.createStatement(); 
			String query ="SELECT * FROM alumno;";	
			System.out.println(query); 
			st.execute(query);
	        conn.close();		    
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


}
