package TestExamenes;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class tinnova {
	
	private WebDriver driver;
	By miCuenta = By.xpath("//span[contains(text(),'My Account')]");
	By login = By.xpath("//a[contains(text(),'Login')]");
	By email = By.xpath("//input[@id='input-email']");
	By psw = By.xpath("//input[@id='input-password']");
	By btnSession = By.xpath("//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]");
	By buscador = By.name("search"); 
	By btnBuscador = By.xpath("//header/div[1]/div[1]/div[2]/div[1]/span[1]/button[1]");
	By btnWishList = By.xpath("//body/div[@id='product-search']/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[2]/button[2]");
	By btnAdd = By.xpath("//span[contains(text(),'Add to Cart')]");
	By btnCart = By.xpath("//span[contains(text(),'Shopping Cart')]");
	By btnConfAvan = By.id("details-button");
	By btnProceder = By.id("proceed-link");

	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://opencart.abstracta.us/index.php?route=common/home");
	}
	
	@Test
	public void test() throws InterruptedException{		
		
		//Iniciar sesión
		driver.findElement(miCuenta).click();
		driver.findElement(login).click();
		driver.findElement(btnConfAvan).click();
		driver.findElement(btnProceder).click();
		driver.findElement(email).sendKeys("manuel_aguilarr@live.com.mx");
		driver.findElement(psw).sendKeys("Pruebas123*");
		driver.findElement(btnSession).click();		
		
		//Se busca device Palm Treo Pro
		driver.findElement(buscador).sendKeys("Palm Treo Pro");
		driver.findElement(btnBuscador).click();
		
		//Add device to WishList
		driver.findElement(btnWishList).click();
		Thread.sleep(3000);
		
		//Add device to Cart
		driver.findElement(btnAdd).click();
		Thread.sleep(3000);
		
		//Save Price device
		WebElement precio = driver.findElement(By.className("price-tax"));
		String val = precio.getText();
		String sSubCadena = val.substring(8,15);
		System.out.println(sSubCadena);
		
		//Go to cart
		driver.findElement(btnCart).click();
		
		//Comparar precio total del producto
		WebElement precioTotal = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[2]/td[2]"));
		String val1 = precioTotal.getText();
		System.out.println(val1);
		
		if (sSubCadena.equals(val1)) {
			System.out.println("El precio unitario es igual al precio total en el carrito");			
		}
		else {
			System.out.println("El precio unitario es diferente al precio total en el carrito");
		}
	}
	@After
	public void finalizar(){
		driver.quit();
	}
}
