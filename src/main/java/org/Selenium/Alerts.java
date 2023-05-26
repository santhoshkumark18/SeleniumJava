package org.Selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\2269280\\Downloads\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.letcode.in");
        driver.manage().window().maximize();
        driver.get("https://www.letcode.in/alert");
        //Simple alert
        driver.findElement(By.id("accept")).click();
        //accept
        Alert alert = driver.switchTo().alert();
        String txt = alert.getText();
        System.out.println(txt);
        driver.switchTo().alert().accept();

        // Confirm alert
        driver.findElement(By.id("confirm")).click();
        Alert alert1 = driver.switchTo().alert();
        String txt1 = alert1.getText();
        System.out.println(txt1);
        driver.switchTo().alert().dismiss();

        //Prompt alert
        driver.findElement(By.id("prompt")).click();
        Alert alert2 = driver.switchTo().alert();
        alert2.sendKeys("Santhosh Kumar K");
        driver.switchTo().alert().accept();
    }
}
