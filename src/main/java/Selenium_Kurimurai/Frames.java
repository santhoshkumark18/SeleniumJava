package Selenium_Kurimurai;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\2269280\\Downloads\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://letcode.in/frame");
        driver.manage().window().maximize();
        driver.switchTo().frame("firstFr");
        driver.findElement(By.name("fname")).sendKeys("Santhosh Kumar");

        //one down
        driver.switchTo().frame(1);
        driver.findElement(By.name("email")).sendKeys("mail@mail.com");
        //comes to main frame
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[.='Watch tutorial']")).click();
    }
}
