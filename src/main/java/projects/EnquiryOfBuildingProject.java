package projects;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class EnquiryOfBuildingProject
{
	public static void main(String[] args) throws Throwable
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\2269280\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		//Maximize the browser
		driver.get("https://www.ishahomes.com/");  
		
    	WebElement more = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[6]/a[1]")));
    	driver.findElement(By.xpath("(//*[text()='Contact Us'])[1]")).click();  //Navigate to the “Contact us” page
    	Thread.sleep(5000);
    	driver.findElement(By.id("livchat_close")).click(); //Handle the live chat that may appear
		driver.manage().window().maximize();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Enquire Now')]")));
    	driver.findElement(By.xpath("//div[contains(text(),'Enquire Now')]")).click();
    	
    	System.out.println("Filling the necessary text fields in the given form");
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	WebElement clk=driver.findElement(By.xpath("(//a[normalize-space()='Buy a Property'])[1]"));
    	js.executeScript("arguments[0].click()", clk);   // Opening the form.
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Alex");
    	driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Alexmartin@gmail.com");
    	driver.findElement(By.xpath("//input[@placeholder='Phone']")).sendKeys("9876543120");
    	System.out.println("The projects are:");
    	Select s=new Select(driver.findElement(By.xpath("(//select[contains(@data-required,'true')])[1]")));  //drop down button
    	List<WebElement> prj = s.getOptions();
    	int i=0;
    	for(WebElement e:prj)       //printing list of projects in the console using for loop.
    	{
			System.out.println(e.getText());
		}
    	WebElement el=driver.findElement(By.xpath("(//select[@data-required='true'])[1]"));
    	Select sel=new Select(el);
    	sel.selectByVisibleText("Isha Anandham");    // Select the project from the field.
    	System.out.println("The Project selected is: "+driver.findElement(By.xpath("(//select[@data-required='true'])[1]//option[2]")).getText());
    	
    	Select link = new Select(driver.findElement(By.xpath("(//select[@name='sell_do[form][lead][source]'])[1]")));
		link.selectByVisibleText("Youtube");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Enquire Now']")));
		driver.findElement(By.xpath("//input[@value='Enquire Now']")).click();   //submit the form.
    	Thread.sleep(5000);
    	
    	driver.findElement(By.xpath("//*[@id=\"bg\"]/header/div/div/div/div[1]/a/img")).click();
    	Actions action = new Actions(driver); 
    	WebElement element = driver.findElement(By.xpath("//span[text()='Live Projects']"));
    	action.moveToElement(element).perform();                        // Moving the cursor to words Live projects.
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='All Projects']")));
    	driver.findElement(By.xpath("//a[text()='All Projects']")).click();
    	System.out.println("The Villas and their respective areas are: ");
    	 // Navigate to “Buy Villas” link
    	Thread.sleep(800);
    	WebElement element1 = driver.findElement(By.xpath("//h3[text()='Villa Project']")); 
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
    	Thread.sleep(5000);
    	//Extract the Area and city of the Villa projects which are available
    	List<WebElement> villa = driver.findElements(By.xpath("//*[@id=\"bg\"]/div/section/div/div[2]/div/div/div[2]/h5/a"));
    	List<WebElement> areas = driver.findElements(By.xpath("//*[@id=\"bg\"]/div/section/div/div[2]/div/div/div[2]/div[1]/p"));
    	for(int j=0;j<villa.size();j++){
			System.out.println(villa.get(j).getText() + " - "
					+ areas.get(j).getText());
		}
    	//Capture the Screenshot of the results
    	TakesScreenshot capture = (TakesScreenshot) driver;
		File srcFile = capture.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir")
				+ "/Screenshot/Villas.png");
		Files.copy(srcFile, destFile);
		Thread.sleep(1000);
		//Closing the Browser
		driver.quit();
	}

	private static JavascriptExecutor executeScript(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
