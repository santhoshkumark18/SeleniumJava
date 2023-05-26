package Selenium_Kurimurai;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class Alerts1 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\2269280\\Downloads\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://letcode.in/alert");
        driver.manage().window().maximize();
        //simple alert
        driver.findElement(By.id("accept")).click();
        driver.switchTo().alert();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //confirm alert
        driver.findElement(By.id("confirm")).click();
        driver.switchTo().alert();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

        //prompt alert
        driver.findElement(By.id("prompt")).click();
        driver.switchTo().alert().sendKeys("Santhosh");
        driver.switchTo().alert().accept();
        driver.quit();
    }
}
