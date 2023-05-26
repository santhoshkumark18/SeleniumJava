package projects;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;

public class BuildingEnquiry {

    static WebDriver driver;

//invoking chrome browser

    public static void chromeBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\2269280\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

//invoking edge browser

    public static void edgeBrowser() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\2269280\\Downloads\\edgedriver_win64\\msedgedriver.exe");
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
            edgeBrowser();

//navigating to the url
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 10-second explicit wait
        try {

            driver.get("https://ishahomes.com/");
            //Closing popups
            //driver.findElement(By.)

            driver.manage().window().maximize();
            //CompletedProjects
            WebElement completedProject = driver.findElement(By.xpath("//a[.='Completed Projects' and @class='nav-link dropdown-toggle']"));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", completedProject);

            //Counting and Displaying completed projects
            //WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='module_properties' and @class='listing-view grid-view card-deck grid-view-3-cols'])[1]")));
           // WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@id='menu-item-25812'])[1]")));
         /*   WebElement EnquiryNow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='menu-item-25812']//ul[@class='dropdown-menu']//li")));
            EnquiryNow.isEnabled();*/
            List<WebElement> toolNames = driver.findElements(By.xpath("//li[@id='menu-item-25812']//ul[@class='dropdown-menu']/li/a"));
            for (WebElement toolName : toolNames) {
                System.out.println(toolName.getText());
            }

        } catch (
                ElementNotInteractableException e) {
            System.out.println("Element not interactable: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
