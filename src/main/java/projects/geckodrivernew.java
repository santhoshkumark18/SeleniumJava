package projects;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;


public class geckodrivernew {

    static WebDriver driver;


    public static void main(String[] args) throws IOException {


// Choose the browser (Chrome or Firefox)
        String browser = "Chrome"; // or "Firefox"


// Set the system property for the chosen browser driver
        if (browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\2269280\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
            driver = new FirefoxDriver();
        }


// Navigate to the Isha Homes website
        driver.get("https://ishahomes.com/");


        // Handle any pop-ups and the live chat that may appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[normalize-space()='-']")));


        try {
            driver.findElement(By.xpath("//b[normalize-space()='-']")).click();
        } catch (Exception e) {
            System.out.println("No Popup Found");
        }


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("live-chat")));


        try {
            driver.findElement(By.className("live-chat")).click();
        } catch (Exception e) {
            System.out.println("No Live Chat Found");
        }


        // Maximize the browser window
        driver.manage().window().maximize();


        // Navigate to the "Completed Projects" page by clicking on "Completed Projects" menu link
        driver.findElement(By.linkText("Completed Projects")).click();


// Get the list of completed projects
        List<WebElement> completedProjectsList = driver.findElements(By.cssSelector("div.col-md-4.col-sm-6 > div > h4"));


// Print the total number of completed projects to console
        System.out.println("Total Completed Projects: " + completedProjectsList.size());


        // Display the names of first five completed projects to the console
        System.out.println("First 5 Completed Projects:");
        for (int i = 0; i < 5; i++) {
            System.out.println(completedProjectsList.get(i).getText());
        }

// Scroll down and click on "Enquire Now" button
        driver.findElement(By.linkText("Enquire Now")).click();


// Verify if "Contact Info" text is displayed on the page
        WebElement contactInfoText = driver.findElement(By.xpath("//h2[contains(text(), 'Contact Info')]"));
        if (contactInfoText.isDisplayed()) {
            System.out.println("Contact Info Text is Displayed");
        } else {
            System.out.println("Contact Info Text is NOT Displayed");
        }


// Read and display the email address for contact to console
        WebElement emailAddress = driver.findElement(By.xpath("//div[@class='contact-details']/p[2]"));
        System.out.println("Email Address for Contact: " + emailAddress.getText());


        // Capture a screenshot of the result
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(screenshotFile, new File("path/to/screenshot.png"));


        driver.quit();
    }
}

