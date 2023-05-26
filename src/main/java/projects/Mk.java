package projects;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.JavascriptExecutor;

public class Mk {

 public static void main(String[] args) {
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\2269280\\Downloads\\chromedriver_win32\\chromedriver.exe");
     WebDriver driver=new ChromeDriver();


  driver.get("http://automationpractice.com/index.php");
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	
  Actions action=new Actions(driver);
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
	
	//Move your cursor over Women's link.
	WebElement findStyle = driver.findElement(By.xpath("//a[@title='Women']"));		
	action.moveToElement(findStyle).build().perform();
	
	//Click on sub menu 'T-shirts'
	WebElement findTshirt=driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/ul/li[1]/ul/li[1]/a"));
	wait.until(ExpectedConditions.elementToBeClickable(findTshirt));
	findTshirt.click();

	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,500)");
	WebElement findProduct=driver.findElement(By.xpath("//a[contains(text(),'Faded Short Sleeve T-shirts')]"));

	//Mouse hover on the first product displayed
	WebElement findMore=driver.findElement(By.xpath("//span[contains(text(),'More')]"));
	action.moveToElement(findProduct).click(findMore).build().perform();	

	//'More' button will be displayed, click on 'More' button
	driver.findElement(By.xpath("//a[@class='btn btn-default button-plus product_quantity_up']")).click();
	
	//Increase quantity to 2.
	Select select5=new Select(driver.findElement(By.name("group_1")));
	
	//Select size 'L'
	select5.selectByVisibleText("L");
	
	//Select color.
	driver.findElement((By.id("color_14"))).click();
	
	//Click 'Add to Cart' button
	driver.findElement(By.name("Submit")).click();
		
	//Click 'Proceed to checkout' button.
	WebElement proceed=driver.findElement(By.cssSelector("a[title='Proceed to checkout'] span"));	
	wait.until(ExpectedConditions.elementToBeClickable(proceed));
	proceed.click();
	
	//Click 'Proceed to checkout' button and complete the buy order process till payment.
	driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']")).click();		
	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);		
		//Sign-Up
	//Click on sign in link.
			driver.findElement(By.className("login")).click();
			
			//Accept email id from user
			driver.findElement(By.id("email_create")).sendKeys("mkch3941@gmail.com");
			
			//Click on Create an Account button
		driver.findElement(By.name("SubmitCreate")).click();
		driver.findElement(By.id("id_gender1")).click();
		driver.findElement(By.name("customer_firstname")).sendKeys("Murali");
		driver.findElement(By.name("customer_lastname")).sendKeys("Krishna");
		driver.findElement(By.id("passwd")).sendKeys("Murali@123");
		driver.findElement(By.name("address1")).sendKeys("no.1 street");
		driver.findElement(By.id("city")).sendKeys("city1");
		WebElement state = driver.findElement(By.id("id_state"));
		Select s1 = new Select(state);
		s1.selectByVisibleText("Alaska");
		driver.findElement(By.name("postcode")).sendKeys("11111");
		driver.findElement(By.id("phone_mobile")).sendKeys("9988776654");
		driver.findElement(By.name("alias")).sendKeys("no.2 street");
		driver.findElement(By.name("submitAccount")).click();
		String userText=driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).getText();
		 
	// Validate that user has created
		
		  if(userText.contains("Murali Krishna"))
		  {
		   System.out.println("User Created");
		  }
		  else
		  {
		   System.out.println("User Not Created");
		  }
		 }
 }


		