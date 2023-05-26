package projects;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StoreNameMandatoryCheck {

    static WebDriver driver;

    public static void main(String[] args) {

        // Choose the browser (Chrome or Firefox)
        String browser = "Chrome"; // or "Firefox"

        // Set the system property for the chosen browser driver
        if(browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if(browser.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
            driver = new FirefoxDriver();
        }

        // Navigate to the Shopify website
        driver.get("https://www.shopify.in/");

        // Click on the "Solutions" tab
        driver.findElement(By.linkText("Solutions")).click();

        // Click on the "Explore free business tools" button
        driver.findElement(By.linkText("Explore free business tools")).click();

        // Get the names of the available tools and display them on the console
        List<WebElement> toolsList = driver.findElements(By.xpath("//div[@class='ui-card__content']/h3"));
        for(WebElement tool : toolsList) {
            System.out.println(tool.getText());
        }

        // Maximize the browser window
        driver.manage().window().maximize();

        // Fill in the form, leaving the "Store Name" field blank
        driver.findElement(By.id("email")).sendKeys("testuser@email.com");
        driver.findElement(By.id("password")).sendKeys("testpassword");
        driver.findElement(By.id("create_store_form")).submit();

        // Verify that the error message is displayed for the "Store Name" field
        WebElement errorMessage = driver.findElement(By.xpath("//span[contains(text(), 'Store name is required')]"));
        if(errorMessage.isDisplayed()) {
            System.out.println("Store Name Mandatory Check: Passed");
        } else {
            System.out.println("Store Name Mandatory Check: Failed");
        }

        // Close the browser
        driver.quit();
    }
}