package TestExamenes;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GaiaLogin {
	
	private WebDriver driver;
	By cerrar = By.xpath("//body/div[@id='mageplaza-betterpopup-block']/div[@id='bio_ep']/div[1]/div[1]/span[1]"); 
	By menuUsuario = By.xpath("//header/div[@id='header']/div[2]/div[1]/div[3]/a[1]"); 
	By inicioSesion = By.xpath("//a[contains(text(),'Inicio de sesión')]");
	By etiquetaInicioSesion = By.xpath("//strong[contains(text(),'Iniciar sesión')]");
	By correo = By.id("email");
	By pass = By.id("pass");
	By botonInicioSesion = By.id("send2");
	By miCuenta = By.linkText("Mi cuenta");
	By buscador = By.id("search");
		
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.gaiadesign.com.mx");
	}
	
	@Test
	public void testGaia() throws InterruptedException{		
		
		//Se obtiene etiqueta del pop up
		WebElement etiqueta1= driver.findElement(By.className("title-signup"));
		String val = etiqueta1.getText();
		driver.findElement(cerrar).click();
		
		//Se ingresa en el campo de busqueda
		driver.findElement(buscador).sendKeys(val);
		Thread.sleep(5000);
		
		driver.findElement(menuUsuario).click();
		driver.findElement(inicioSesion).click();
		
		
		
		if(driver.findElement(etiquetaInicioSesion).isDisplayed()) {
			driver.findElement(correo).sendKeys("manuel_aguilarr@live.com.mx");
			driver.findElement(pass).sendKeys("Gaia1234*");
			driver.findElement(botonInicioSesion).click();
			
		}
		else {
			System.out.println("No se muestra la página de inicio de sesión");
		}
		driver.get("https://www.gaiadesign.com.mx");
		//Thread.sleep(10000);
		driver.findElement(menuUsuario).click();
		driver.findElement(miCuenta).click();
		//Thread.sleep(10000);
		List<WebElement> etiqueta = driver.findElements(By.className("page-title"));	
		assertEquals("Mi cuenta", etiqueta.get(0).getText());
	}
	
	@After
	public void finalizar(){
		driver.quit();
	}

}