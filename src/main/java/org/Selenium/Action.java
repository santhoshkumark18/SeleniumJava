package org.Selenium;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Action {
    static ChromeDriver driver;
    public static void main(String[] args) {
/*
        String str = "SanthoshKumarK";
        char[] chArr = new char[str.length()];
        for(int i=0;i<str.length();i++) {
            chArr[i]=str.charAt(i);
        }

        //iterating a char array
        for(char ltr : chArr)  {
            System.out.println(ltr);
        }

        // print char array
        System.out.println(chArr);*/

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        draggable();
    }
    static  void draggable() {
        //ChromeDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/draggable/");
        driver.switchTo().frame(0);
        WebElement src = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        Actions builder = new Actions(driver);
        Point loc = src.getLocation();
        builder.dragAndDrop(src,target).build().perform();
        //driver.quit();
    }
    static  void droppable() {
        //ChromeDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);
        WebElement src = driver.findElement(By.id("droppable"));
        WebElement target = driver.findElement(By.id("draggable"));
        Actions builder = new Actions(driver);
        Point loc = src.getLocation();
        builder.dragAndDropBy(src,loc.getX()+180,loc.getY()+10).perform();

        //driver.quit();
        //Mouse Hover
        //builder.moveToElement();
    }
    //Right click context Menu

}
