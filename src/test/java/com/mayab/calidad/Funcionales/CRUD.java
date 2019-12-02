/*
package com.mayab.calidad.Funcionales;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.openqa.selenium.Keys;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CRUD {

	private String URL="";
	private static WebDriver driver;
	private static WebElement webElement;
	
	@Before
	public void init() {
		//URL="http://localhost:4200/";
		URL="https://mern-crud.herokuapp.com/";
		//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		//options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,UnexpectedAlertBehaviour.IGNORE);
		options.setBinary("/path/to/google-chrome-stable");
		options.addArguments("--headless");
		options.addArguments("--disable-gpu");	
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(options);		
	}
	
	@Test
	public void aCreateUserSucces() { //caso creacion exitosa
		driver.get(URL);
		//Crea el usuario de adriana
		String username="Adriana Sanchez";
		String email="adri.d.san@hotmail.com";
		String age="22";
			
		driver.findElement(By.xpath("/html/body/div/div/div[2]/button")).click(); //Button Add New
		webElement=driver.findElement(By.name("name"));
		webElement.sendKeys(username);
		webElement=driver.findElement(By.name("email"));
		webElement.sendKeys(email);
		webElement=driver.findElement(By.name("age"));
		webElement.sendKeys(age);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[3]/div[2]/div")).click(); //Click box
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[3]/div[2]/div/div[2]/div[2]")).click(); //Select Genre
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button")).click(); //Button Add
		
		pause(2000);
		String verifyAdded=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[4]/div/div")).getText();
		String msg="Nice one!";
		System.out.println(verifyAdded);
		
		assertThat(msg,equalTo(verifyAdded));
		
		pause(2000);
		driver.close();
	}
	
	@Test
	public void bCreateUserFail() { //caso creacion fallida
		driver.get(URL);
		//Intenta crear el usuario de Adriana de nuevo
		String username="Adriana Sanchez";
		String email="adri.d.san@hotmail.com";
		String age="22";
			
		driver.findElement(By.xpath("/html/body/div/div/div[2]/button")).click(); //Button Add New
		webElement=driver.findElement(By.name("name"));
		webElement.sendKeys(username);
		webElement=driver.findElement(By.name("email"));
		webElement.sendKeys(email);
		webElement=driver.findElement(By.name("age"));
		webElement.sendKeys(age);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[3]/div[2]/div")).click(); //Click box
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[3]/div[2]/div/div[2]/div[2]")).click(); //Select Genre
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button")).click(); //Button Add
		
		pause(2000);
		String verifyAdded=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[5]/div/div")).getText();
		String msg="Woah!";
		System.out.println(verifyAdded);
		
		assertThat(msg,equalTo(verifyAdded));
		
		pause(2000);
		driver.close();
	}
	
	@Test
	public void cDeleteUserSuccess() { //caso borrado exitoso
		driver.get(URL);
		
		//Crea usuario nuevo para borrarlo despues
		String username="Tomas Catanzaritti";
		String email="thomas@hotmail.com";
		String age="22";
			
		driver.findElement(By.xpath("/html/body/div/div/div[2]/button")).click(); //Button Add New
		webElement=driver.findElement(By.name("name"));
		webElement.sendKeys(username);
		webElement=driver.findElement(By.name("email"));
		webElement.sendKeys(email);
		webElement=driver.findElement(By.name("age"));
		webElement.sendKeys(age);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[3]/div[2]/div")).click(); //Click box
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[3]/div[2]/div/div[2]/div[1]")).click(); //Select Genre
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button")).click(); //Button Add
			
		webElement.sendKeys(Keys.ESCAPE); //Retorna a la pagina de usuarios
		pause(2000);			
		driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[1]/td[5]/button[2]")).click(); //Button Delete USer
		pause(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[1]")).click(); //Yes button
		pause(2000);
		
		String verifyDeleted=driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[1]")).getText();		
		System.out.println(verifyDeleted);
		assertThat("Adriana Sanchez",equalTo(verifyDeleted)); //Se comprueba que el unico usuario restante es el de Adriana
		pause(2000);
		driver.close();
	}
	
	@Test
	public void dDeleteUserFailed() { //caso borrado fallido
		driver.get(URL);
		
		//Crea usuario nuevo para borrarlo despues
		String username="Tomas Catanzaritti";
		String email="thomas@hotmail.com";
		String age="22";
			
		driver.findElement(By.xpath("/html/body/div/div/div[2]/button")).click(); //Button Add New
		webElement=driver.findElement(By.name("name"));
		webElement.sendKeys(username);
		webElement=driver.findElement(By.name("email"));
		webElement.sendKeys(email);
		webElement=driver.findElement(By.name("age"));
		webElement.sendKeys(age);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[3]/div[2]/div")).click(); //Click box
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[3]/div[2]/div/div[2]/div[1]")).click(); //Select Genre
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button")).click(); //Button Add
					
		webElement.sendKeys(Keys.ESCAPE); //Retorna a la pagina de usuarios
		pause(2000);		
		driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[1]/td[5]/button[2]")).click(); //Button Delete USer
		pause(2000);		
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[2]")).click(); 
		
		String verifyDeleted=driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[1]/td[1]")).getText();		
		System.out.println(verifyDeleted);
		assertThat("Tomas Catanzaritti",equalTo(verifyDeleted)); //Se comprueba que el usuario de Tomas sigue existiendo
		pause(2000);
		driver.close();
	}
	
	@Test
	public void eUpdateUserSuccess() { //caso actualizar exitoso
		driver.get(URL);		
		//Modificar el usuario de Tomas Catanzaritti
		String username="Arturo Lopez";
		String email="arthur@hotmail.com";

		driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[1]/td[5]/button[1]")).click(); //Button Update USer	
		webElement=driver.findElement(By.name("name")); 
		webElement.clear();	//Borro name del text box
		webElement.sendKeys(username); //Escribo nuevo nombre de usuario
		webElement=driver.findElement(By.name("email"));
		webElement.clear();	//Borro mail del text box
		webElement.sendKeys(email); //Escribo nuevo email
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button")).click(); //Update		
		webElement.sendKeys(Keys.ESCAPE); //Retorna a la pagina de usuarios
		pause(2000);		
		
		String verifyUpdated=driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[1]/td[1]")).getText();		
		System.out.println(verifyUpdated);
		assertThat("Arturo Lopez",equalTo(verifyUpdated)); //Se comprueba que el usuario de Tomas se actualizo a Arturo Lopez
		pause(2000);
		driver.close();
	}
	
	@Test
	public void fUpdateUserFailed() { //caso actualizar fallido
		driver.get(URL);		
		//Modificar el usuario de Arturo Lopez
		String username="Gandalf the White";
		String email="fly_you_fools@hotmail.com";
		String age="1000"; //Edad no valida, max 130

		driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[1]/td[5]/button[1]")).click(); //Button Update USer	
		webElement=driver.findElement(By.name("name")); 
		webElement.clear();	//Borro name del text box
		webElement.sendKeys(username); //Escribo nuevo nombre de usuario
		webElement=driver.findElement(By.name("email"));
		webElement.clear();	//Borro mail del text box
		webElement.sendKeys(email); //Escribo nuevo email
		webElement=driver.findElement(By.name("age"));
		webElement.clear();	//Borro edad del text box
		webElement.sendKeys(age);
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button")).click(); //Update	
		pause(2000);
		webElement.sendKeys(Keys.ESCAPE); //Retorna a la pagina de usuarios
		pause(2000);			
		
		String verifyUpdated=driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[1]/td[1]")).getText();		
		System.out.println(verifyUpdated);
		assertThat("Arturo Lopez",equalTo(verifyUpdated)); //Se comprueba que el usuario de Arturo Lopez no se actualizo a Gandalf por la edad no valida
		pause(2000);
		driver.close();
	}
	
	
	
	@After
	public void tearDown() {
		driver.quit();
	}
	public void pause(long millis) {
		try {
			Thread.sleep(millis);		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}*/