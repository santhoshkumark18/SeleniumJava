package projects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MiniProject {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        Thread.sleep(3000);

        driver.findElement(By.name("password")).sendKeys("admin123");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//ul[@class='oxd-main-menu']/li[2]/a/span")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//nav[@role=\"navigation\"]/ul/li[3]/a")).click();

        Thread.sleep(3000);

        driver.findElement(By.name("firstName")).sendKeys("Carunnye");

        Thread.sleep(3000);

        driver.findElement(By.name("middleName")).sendKeys("aravind");

        Thread.sleep(3000);
        driver.findElement(By.name("lastName")).sendKeys("shingote");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")).click();

        Thread.sleep(3000);

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='oxd-userdropdown-img']")));
        //driver.findElement(By.xpath("//img[@class='oxd-userdropdown-img']")).click();
        button.click();
        Thread.sleep(3000);
        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Logout']")));
        //driver.findElement(By.xpath("//a[normalize-space()='Logout']"));
        logout.click();
        Thread.sleep(3000);
        driver.quit();

    }

}