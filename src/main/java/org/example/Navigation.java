package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://letcode.in/buttons");
        System.out.println("Expecting btn :"+driver.getCurrentUrl());
        driver.findElement(By.id("home")).click();
        System.out.println("Expecting letcode :"+driver.getCurrentUrl());
        
    }
}
