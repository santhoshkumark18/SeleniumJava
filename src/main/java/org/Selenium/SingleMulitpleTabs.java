package org.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SingleMulitpleTabs {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.letcode.in/windows");
        driver.findElement(By.id("home")).click();
        Set<String> windowsHandles = driver.getWindowHandles();
        List<String> lst  = new ArrayList<>(windowsHandles);
        System.out.println("No of windows tabs :"+lst.size());
        for(String tab : lst) {
            System.out.println(tab);
        }
        driver.switchTo().window(lst.get(1));
        driver.findElement(By.xpath("//a[normalize-space()='Product']")).click();


    }
}
