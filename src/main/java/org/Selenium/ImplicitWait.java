package org.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ImplicitWait {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://letcode.in/");
        driver.manage().window().maximize();
        String email = "santhoshinrealife@gmail";
        String pass = "Santhosh@18";
        WebElement signIn= driver.findElement(By.linkText("Log in"));
        signIn.click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.xpath("//button[text()='LOGIN']")).click();
    }
}
