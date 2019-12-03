package com.mayab.calidad.DbUnit;

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


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.openqa.selenium.Keys;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CRUD_Test {

	private String URL="";
	private static WebDriver driver;
	private static WebElement webElement;
	
	@Before
	public void init() {
		URL="https://mern-crud.herokuapp.com/";
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless","--whitelisted-ips","--no-sandbox","--disable-extensions");
		//options.addArguments("--headless","--disable-gpu","--window-size=1920,1200","--ignore-certificate-errors");

		//options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,UnexpectedAlertBehaviour.IGNORE);
		driver = new ChromeDriver(options);	
	}
	
	@Test
	public void aCreateUserSucces() { 
		driver.get(URL);
		String username="Adriana Sanchez";
		String email="adri.d.san@hotmail.com";
		String age="22";
			
		driver.findElement(By.xpath("/html/body/div/div/div[2]/button")).click(); 
		webElement=driver.findElement(By.name("name"));
		webElement.sendKeys(username);
		webElement=driver.findElement(By.name("email"));
		webElement.sendKeys(email);
		webElement=driver.findElement(By.name("age"));
		webElement.sendKeys(age);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[3]/div[2]/div")).click(); 
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[3]/div[2]/div/div[2]/div[2]")).click(); 
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button")).click(); 
		
		pause(2000);
		String verifyAdded=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[4]/div/div")).getText();
		String msg="Nice one!";
		System.out.println(verifyAdded);
		
		assertThat(msg,equalTo(verifyAdded));
		
		pause(2000);
		driver.close();
	}
	
	@Test
	public void bCreateUserFail() { 
		driver.get(URL);
		String username="Adriana Sanchez";
		String email="adri.d.san@hotmail.com";
		String age="22";
			
		driver.findElement(By.xpath("/html/body/div/div/div[2]/button")).click(); 
		webElement=driver.findElement(By.name("name"));
		webElement.sendKeys(username);
		webElement=driver.findElement(By.name("email"));
		webElement.sendKeys(email);
		webElement=driver.findElement(By.name("age"));
		webElement.sendKeys(age);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[3]/div[2]/div")).click(); 
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[3]/div[2]/div/div[2]/div[2]")).click(); 
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button")).click(); 
		
		pause(2000);
		String verifyAdded=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[5]/div/div")).getText();
		String msg="Woah!";
		System.out.println(verifyAdded);
		
		assertThat(msg,equalTo(verifyAdded));
		
		pause(2000);
		driver.close();
	}
	
	@Test
	public void cDeleteUserSuccess() { 
		driver.get(URL);
		String username="Tomas Catanzaritti";
		String email="thomas@hotmail.com";
		String age="22";
			
		driver.findElement(By.xpath("/html/body/div/div/div[2]/button")).click(); 
		webElement=driver.findElement(By.name("name"));
		webElement.sendKeys(username);
		webElement=driver.findElement(By.name("email"));
		webElement.sendKeys(email);
		webElement=driver.findElement(By.name("age"));
		webElement.sendKeys(age);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[3]/div[2]/div")).click(); 
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[3]/div[2]/div/div[2]/div[1]")).click(); 
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button")).click(); 
			
		webElement.sendKeys(Keys.ESCAPE); 
		pause(2000);			
		driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[1]/td[5]/button[2]")).click();
		pause(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[1]")).click(); 
		pause(2000);
		
		String verifyDeleted=driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[1]")).getText();		
		System.out.println(verifyDeleted);
		assertThat("Adriana Sanchez",equalTo(verifyDeleted)); 
		pause(2000);
		driver.close();
	}
	
	@Test
	public void dDeleteUserFailed() { 
		driver.get(URL);
		String username="Tomas Catanzaritti";
		String email="thomas@hotmail.com";
		String age="22";
			
		driver.findElement(By.xpath("/html/body/div/div/div[2]/button")).click(); 
		webElement=driver.findElement(By.name("name"));
		webElement.sendKeys(username);
		webElement=driver.findElement(By.name("email"));
		webElement.sendKeys(email);
		webElement=driver.findElement(By.name("age"));
		webElement.sendKeys(age);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[3]/div[2]/div")).click(); 
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[3]/div[2]/div/div[2]/div[1]")).click(); 
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button")).click(); 
					
		webElement.sendKeys(Keys.ESCAPE); 
		pause(2000);		
		driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[1]/td[5]/button[2]")).click(); 
		pause(2000);		
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[2]")).click(); 
		
		String verifyDeleted=driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[1]/td[1]")).getText();		
		System.out.println(verifyDeleted);
		assertThat("Tomas Catanzaritti",equalTo(verifyDeleted));
		pause(2000);
		driver.close();
	}
	
	@Test
	public void eUpdateUserSuccess() { 
		driver.get(URL);		
		String username="Arturo Lopez";
		String email="arthur@hotmail.com";

		driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[1]/td[5]/button[1]")).click(); 	
		webElement=driver.findElement(By.name("name")); 
		webElement.clear();	
		webElement.sendKeys(username);
		webElement=driver.findElement(By.name("email"));
		webElement.clear();	
		webElement.sendKeys(email); 
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button")).click(); 		
		webElement.sendKeys(Keys.ESCAPE);
		pause(2000);		
		
		String verifyUpdated=driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[1]/td[1]")).getText();		
		System.out.println(verifyUpdated);
		assertThat("Arturo Lopez",equalTo(verifyUpdated));
		pause(2000);
		driver.close();
	}
	
	@Test
	public void fUpdateUserFailed() {
		driver.get(URL);		
		String username="Gandalf the White";
		String email="fly_you_fools@hotmail.com";
		String age="1000"; 

		driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[1]/td[5]/button[1]")).click(); 	
		webElement=driver.findElement(By.name("name")); 
		webElement.clear();	
		webElement.sendKeys(username); 
		webElement=driver.findElement(By.name("email"));
		webElement.clear();
		webElement.sendKeys(email); 
		webElement=driver.findElement(By.name("age"));
		webElement.clear();	
		webElement.sendKeys(age);
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button")).click(); //Update	
		pause(2000);
		webElement.sendKeys(Keys.ESCAPE); 
		pause(2000);			
		
		String verifyUpdated=driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[1]/td[1]")).getText();		
		System.out.println(verifyUpdated);
		assertThat("Arturo Lopez",equalTo(verifyUpdated)); 
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
}