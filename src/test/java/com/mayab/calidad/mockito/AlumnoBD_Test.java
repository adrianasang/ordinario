package com.mayab.calidad.mockito;

import junit.framework.TestCase;
import static org.junit.Assert.*;

import java.util.ArrayList;
import static org.mockito.Mockito.spy;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.hamcrest.Matchers.is;

public class AlumnoBD_Test {
	//ALUMNOS CREADOS
	public AlumnoBD aBD0;
	public AlumnoBD aBD1;
	public AlumnoBD aBD2;
	public AlumnoBD aBD3;
	
	@Before
	public void init() {	
		
		//ALUMNOS INICIALIZADOS
		aBD0 = new AlumnoBD();
		aBD1 = new AlumnoBD();
		aBD2 = new AlumnoBD();
		aBD3 = new AlumnoBD();
		
		//PRIMER ALUMNO
		aBD0.setId(1);
		aBD0.setName("WILLIAM");
		aBD0.setLastName("BALAN");
		aBD0.setAge(21);
		aBD0.setAVG(80);
				
		//SEGUNDO ALUMNO
		aBD1.setId(2);
		aBD1.setName("ADRIANA");
		aBD1.setLastName("SANCHEZ");
		aBD1.setAge(22);
		aBD1.setAVG(87);
				
		//TERCER ALUMNO
		aBD2.setId(3);
		aBD2.setName("EMILIO");
		aBD2.setLastName("GOMEZ");
		aBD2.setAge(25);
		aBD2.setAVG(84);
		
		//CUARTO ALUMNO
		aBD2.setId(4);
		aBD2.setName("LUIS");
		aBD2.setLastName("OLIVA");
		aBD2.setAge(21);
		aBD2.setAVG(60);	
	}
	
	@Test
	public void testDelete() {
		//INICIALIZACION DEL SPY JUNTO CON EL ARRAYLIST DE TIPO ALUMNOBD
		ArrayList<AlumnoBD> a = new ArrayList<AlumnoBD>();
		ArrayList<AlumnoBD> spyOnArrayList = Mockito.spy(a);
		
		spyOnArrayList.add(aBD0);
		spyOnArrayList.add(aBD1);
		spyOnArrayList.add(aBD2);
		
		spyOnArrayList.remove(0);
		
		assertThat(spyOnArrayList.size(), is(2));
	}
	
	@Test
	public void testAdd() {
		//INICIALIZACION DEL SPY JUNTO CON EL ARRAYLIST DE TIPO ALUMNOBD
		ArrayList<AlumnoBD> a = new ArrayList<AlumnoBD>();
		ArrayList<AlumnoBD> spyOnArrayList = spy(a);
		
		spyOnArrayList.add(aBD3);
		
		assertThat(spyOnArrayList.size(), is(1));
	}

}
