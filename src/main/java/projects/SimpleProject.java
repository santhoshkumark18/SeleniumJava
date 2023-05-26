package projects;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import static java.util.concurrent.TimeUnit.SECONDS;

//creating class

public class SimpleProject {

// elements declaration

    static WebDriver driver;

//invoking chrome browser

    public static void chromeBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\2269280\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

//invoking edge browser

    public static void FireFoxBrowser() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\2269280\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();

    }

//main function

    public static void main(String[] arg) throws InterruptedException,
            IOException {
        System.out.println("select your browser 1.chrome 2.edge");
        Scanner sc = new Scanner(System.in);

//selecting browser

        int choice = 1;

        if (choice == 1)
            chromeBrowser();
        else
            FireFoxBrowser();

//navigating to the url
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 10-second explicit wait

        try {
            driver.get("https://www.shopify.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(20, SECONDS);
            // Wait until the element is visible and interactable
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='mr-3'])[1]")));
            // Perform actions on the element
            button.click();
            driver.manage().timeouts().pageLoadTimeout(20, SECONDS);
            //Thread.sleep(3000);
            //WebElement clk = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/header/div[1]/div/div/nav/ul/li[1]/div[2]/div/div[1]/ul/li[6]/a")));
            WebElement element = driver.findElement(By.xpath("/html/body/div[3]/header/div[1]/div/div/nav/ul/li[1]/div[2]/div/div[1]/ul/li[6]/a"));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);


// Get the names of the available tools and display on the console
            List<WebElement> toolNames = driver.findElements(By.xpath("//ul[@class='grid grid--layout-mode grid--equal-height redesign-page-grid']"));
            for (WebElement toolName : toolNames) {
                System.out.println(toolName.getText());
            }
            driver.manage().timeouts().pageLoadTimeout(20, SECONDS);
            //Logn in
            WebElement logIn = driver.findElement(By.xpath("//a[@class='whitespace-nowrap hover:underline text-black']"));
            executor.executeScript("arguments[0].click();", logIn);
            driver.manage().timeouts().pageLoadTimeout(20, SECONDS);
            //email Id
            WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='account_email']")));
            ele.sendKeys("myemail@abc.com");
            driver.manage().timeouts().pageLoadTimeout(20, SECONDS);
            //loginButton
            WebElement logInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='commit']")));
            logInButton.click();
            driver.manage().timeouts().pageLoadTimeout(20, SECONDS);
            //password
            WebElement pswd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='account_password']")));
            pswd.sendKeys("password@123");
            driver.manage().timeouts().pageLoadTimeout(20, SECONDS);
            //passwordbtn
            WebElement pswdBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='commit']")));
            pswdBtn.click();
            driver.manage().timeouts().pageLoadTimeout(20, SECONDS);
            //ScreenShot
            /*TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
            File dest = new File("C:\\Projects\\StoreNameMandatoryCheck\\screenshot\\screenshot.png");
            driver.manage().timeouts().pageLoadTimeout(20, SECONDS);
            FileHandler.copy(scrFile, dest);*/

            //ScreenCapture.passScreenCapture();
            driver.manage().timeouts().pageLoadTimeout(20, SECONDS);
        } catch (ElementNotInteractableException e) {
            System.out.println("Element not interactable: " + e.getMessage());
        } finally {
            driver.quit();
        }

    }
}