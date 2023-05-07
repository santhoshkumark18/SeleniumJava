package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.letcode.in/frame");
        driver.manage().window().maximize();
        driver.switchTo().frame("firstFr");
        driver.findElement(By.name("fname")).sendKeys("SANTHOSH KUMAR K");
        driver.switchTo().frame(0);
        driver.findElement(By.name("email")).sendKeys("santhoshinrealife@gmail.com");
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("Watch tutorial")).click();
    }
}
