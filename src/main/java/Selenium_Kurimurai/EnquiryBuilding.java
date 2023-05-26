package Selenium_Kurimurai;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//creating class

public class EnquiryBuilding {

// elements declaration

	public static WebDriver driver;
	public static Properties prop;

public void driverSetup()
{
	prop=new Properties();
	try 
	{
		prop.load(new FileInputStream("src/main/java/Config/config.properties"));
	}	
	 catch (Exception e) 
	{
		e.printStackTrace();
	}
	if(prop.getProperty("browserName").matches("chrome"))
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\2269280\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
	     option.addArguments("--disable-blink-features=AutomationControlled");
	     option.addArguments("--disable-notifications");// Disabling any notifications
		driver=new ChromeDriver();
	}
	if(prop.getProperty("browserName").matches("firefox"))
	{
		driver=new FirefoxDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	
}

public void openUrl() throws InterruptedException {
	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	driver.get("https://www.ishahomes.com/");
	
}

// Enuiry Buildings

public void inquiry() throws InterruptedException {

	driver.findElement(By.xpath("//span[normalize-space()='Completed Projects']")).click();
	driver.findElement(By.xpath("//*[@id=\"livchat_close\"]")).click();
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scroll(0,1000)", "");
	driver.findElement(By.xpath("//*[@id=\"livchat_close\"]")).click();
	By project = By.xpath("//*[@class='dz-info']//a");
	Thread.sleep(3000);
	List<WebElement> myElements = driver.findElements(project);
	System.out.println("The total number of completed projects are :- "+myElements.size());
	System.out.println("-------------------------------------------------");
	System.out.println("The first five completed projects are");
	int j=1;
	for(WebElement proj : myElements) {
		System.out.println(proj.getText());
		if(j==5)
		break;
		j++;
	}
	System.out.println("-----------------------------------------------");
	Thread.sleep(5000);
 // driver.findElement(By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[6]/div[1]/i[1]")).click();
	driver.findElement(By.xpath("//*[@id=\"bg\"]/header/div/div/div/div[6]/div[2]")).click();
	String expected = "CONTACT INFO";
	
	String actual = driver.findElement(By.xpath("//*[@id=\"bg\"]/div[2]/div/div/div[2]/div[1]/h4")).getText();
	
	System.out.println("Actual Text : " + actual);
	
	if(expected.equals(actual)) 
	{
	System.out.println(actual);
	}
	else {
	System.out.println("Text CONTACT INFO is not displayed on the page");
	}
	System.out.println(driver.findElement(By.linkText("marketing@ishahomes.com")).getText());
	
	}
	



//main function

public static void main (String[] arg) throws InterruptedException,IOException 
{
	EnquiryBuilding eb = new EnquiryBuilding();
	 eb.driverSetup();
	 eb.openUrl();
	 eb.inquiry();
	 driver.quit();
	
	}
}
