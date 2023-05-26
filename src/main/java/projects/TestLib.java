package projects;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestLib {
	//Selenium-server-4.1.2.jar file is used 
	public static void main(String[] args) throws IOException, InterruptedException {
		//Invoking chrome driver
		WebDriver driver;
		System.out.println("Select Your Browser: 1.Chrome 2.Edge");
		Scanner sc=new Scanner(System.in);
		int choice=sc.nextInt();
		if(choice==1) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\2269280\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			}else{
			   System.setProperty("webdriver.edge.driver","./Resources/msedgedriver.exe");
			driver=new EdgeDriver();
		}
		//Maximize the window
		driver.manage().window().maximize();
		//Assigning the URL
		String A = "https://www.amazon.in";
		//Opening the website
		driver.get(A);
		//Maximum Wait time of a page
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Entering the search text in search box �mobile smartphones under 30000�
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile smartphones under 30000");
		//Clicking the submit button
		driver.findElement(By.id("twotabsearchtextbox")).submit();
		//Taking result text before sorting using xpath
		WebElement beforeSorting = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[1]"));
		driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]")).click();
		//Selecting the Newest Arrivals in the list
		driver.findElement(By.linkText("Newest Arrivals")).click();
		//Taking result text after sorting using xpath
		WebElement afterSorting = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[1]"));		
		Select availableOptions = new Select(driver.findElement(By.id("s-result-sort-select")));
		WebElement currOption = availableOptions.getFirstSelectedOption();
		//printing the options count
		List<WebElement> lst = availableOptions.getOptions();
		System.out.println("The count of the options displayed is : "+lst.size());
		//Verifying that  �Newest Arrivals� option got selected correctly or not
		String toCheck = currOption.getText();
		String expectedText = "Newest Arrivals";
		if(expectedText.matches(toCheck)) {
			System.out.println("Newest Arrivals option is selected successfully.");
		}else {
			System.out.println("Newest Arrivals option is not selected.");
		}
		//validating the search string
		if(beforeSorting == afterSorting) {
			System.out.println("Test Case Failed : Newly arrived mobiles phones are not sorted.");
		}else {
			System.out.println("Test Case passed : Newly arrived mobiles phones are displayed.");

		}
		//Closing the browser
		driver.quit();
		
	}

}
