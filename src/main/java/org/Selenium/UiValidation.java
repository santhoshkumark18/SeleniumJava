package org.Selenium;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UiValidation {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.letcode.in/radio");
        WebElement ele = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        boolean selected = ele.isSelected();
        System.out.println(selected);
        WebElement btn = driver.findElement(By.linkText("Watch tutorial"));
        System.out.println(btn.isDisplayed());
        System.out.println(btn.isEnabled());
    }
}
