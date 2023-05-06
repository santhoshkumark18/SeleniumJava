package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buttons {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\2269280\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://letcode.in/");
        driver.manage().window().maximize();
        driver.get("https://letcode.in/buttons");
        //Position
        WebElement btn1 = driver.findElement(By.id("position"));
        Point location = btn1.getLocation();
        System.out.println(location);
        //Color
        WebElement btn2 = driver.findElement(By.id("color"));
        String color = btn2.getCssValue("background-color");
        System.out.println("color " + color);
        //width & height
        Rectangle  rect= driver.findElement(By.id("property")).getRect();
        int height=rect.getHeight();
        int width= rect.getWidth();
        System.out.println("Height "+height+" Widht "+ width);
        //isdisabled
        boolean enabled =driver.findElement(By.id("isDisabled")).isEnabled();
        System.out.println(enabled);
    }
}
