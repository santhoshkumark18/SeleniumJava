package org.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstScript {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\2269280\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://letcode.in/");
        driver.manage().window().maximize();
        driver.findElement(By.partialLinkText("Log in")).click();
        driver.findElement(By.name("email")).sendKeys("santhoshkumar@gmail.com");
        driver.findElement(By.name("password")).sendKeys("12002021");
        driver.findElement(By.tagName("button")).click();
        //driver.close();
    }
}
