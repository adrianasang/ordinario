package com.mayab.calidad.DbUnit;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;

import com.mysql.cj.x.protobuf.MysqlxCrud.Column;

import org.junit.After;
import org.junit.Before;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.dataset.xml.FlatXmlWriter;
import org.dbunit.operation.DatabaseOperation;


import java.sql.Connection;
import java.sql.DriverManager;


public class DbUnit_Test extends DBTestCase{
	
	String driver = "com.mysql.cj.jdbc.Driver";
	String URL =  "jdbc:mysql://localhost:3306/bdcalidad"+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String user="root";
	String password="";
	
	public DbUnit_Test(String name) {
		super(name);
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, driver);
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, URL);
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, user);
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, password);
	}
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		IDatabaseConnection conn = getConnection();
		try {
			DatabaseOperation.CLEAN_INSERT.execute(conn, getDataSet());
		}finally {
			conn.close();
		}		
	}
	
	 @Test
	 public void testAddAlumno() throws Exception{
		 AlumnoDB DAO=new AlumnoDB();
		 Alumno alumno1=new Alumno(0,"Bilbo","Baggins",55,100);
		 IDatabaseConnection conn = getConnection();
		 DAO.addAlumno(alumno1); 	 	
		 assertEquals(1, conn.getRowCount("alumno"));
			conn.close();				 
	 }
	 
	 @Test
	 public void testRemoveAlumno() throws Exception{
		 AlumnoDB DAO=new AlumnoDB();
		 Alumno alumno1=new Alumno(0,"Bilbo","Baggins",55,100);
		 IDatabaseConnection conn = getConnection();
		 DAO.removeAlumno(alumno1);	 	
		 assertEquals(0, conn.getRowCount("alumno"));
			conn.close();			 			 		 
	 }
	 
	/*
	 @Test
	 public void testUpdatePromedio() throws Exception{
		 AlumnoDB DAO=new AlumnoDB();
		 Alumno alumno1=new Alumno(0,"Bilbo","Baggins",55,100); 	 
		 DAO.addAlumno(alumno1);        
		 DAO.updatePromedio(alumno1,70);
		 
		 
		 
		 IDataSet conn = getConnection().createDataSet();
		 ITable actualTable = conn.getTable("alumno");
		 	
	     IDataSet dataSetEsperado = new FlatXmlDataSetBuilder().build(new File("./resources/avgEsperado.xml"));	
	     ITable expectedTable=dataSetEsperado.getTable("alumno");
	   
	     
	      
	     assertEquals(expectedTable, actualTable);		 
	 }*/
	 
	 @After
	public void tearDown() throws Exception {
		 
	 }
	 	
	@Override
	protected IDataSet getDataSet() throws Exception {
			return new FlatXmlDataSetBuilder().build(new FileInputStream("./resources/empty.xml"));
			
	}
	
}//End class  

