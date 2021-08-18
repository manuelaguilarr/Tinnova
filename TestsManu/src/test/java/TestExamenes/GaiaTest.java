package TestExamenes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GaiaTest {
	
	private WebDriver driver;
	By cerrar = By.xpath("//body/div[@id='mageplaza-betterpopup-block']/div[@id='bio_ep']/div[1]/div[1]/span[1]");
	By buscadorGaia = By.name("q");
	By buscadorPredictorio = By.xpath("//span[contains(text(),'Cama matrimonial Marquelia - Gris')]");
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.gaiadesign.com.mx");
	}
	
	@Test
	public void testGaia() throws InterruptedException{
		driver.findElement(cerrar).click();
		driver.findElement(buscadorGaia).sendKeys("Cama matrimonial Marquelia - Gris");
		Thread.sleep(7000);
		if(driver.findElement(buscadorPredictorio).isDisplayed()) {
			driver.findElement(buscadorPredictorio).click();;
			Thread.sleep(7000);
		}
		else {
			System.out.println("No se encontro el elemento");
		}
		
		if(driver.findElement(buscadorPredictorio).isDisplayed()){
			driver.quit();
		}
		else {
			System.out.println("No se encontro el elemento");
		}
	}
	
	@After
	public void finalizar(){
		driver.quit();
	}

}
