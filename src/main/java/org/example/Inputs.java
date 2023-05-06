package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Inputs {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\2269280\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://letcode.in/edit");
        driver.manage().window().maximize();
        driver.findElement(By.id("fullName")).sendKeys("Santhosh Kumar K");
        driver.findElement(By.id("join")).sendKeys("i am good at everything", Keys.TAB);
        driver.findElement(By.id("clearMe")).clear();
        String isId = driver.findElement(By.id("dontwrite")).getAttribute("readonly");

        System.out.println(isId);
        driver.close();
    }
}
