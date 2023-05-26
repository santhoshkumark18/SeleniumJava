package org.Selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Dropdown {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.letcode.in");
        driver.manage().window().maximize();
        driver.get("https://www.letcode.in/dropdowns");
        //selectByVisibleText
        WebElement element = driver.findElement(By.id("fruits"));
        Select select = new Select(element);
        select.selectByVisibleText("Apple");

        //IfMultiple
        WebElement herosEle = driver.findElement(By.id("superheros"));
        Select heros = new Select(herosEle);
        boolean multi = heros.isMultiple();
        System.out.println(multi);
        heros.selectByIndex(1);
        heros.selectByValue("ds");
        heros.selectByVisibleText("Iron Man");
        //IterateWebElements
        List<WebElement> selectedElement = heros.getAllSelectedOptions();
        for (WebElement her : selectedElement) {
            System.out.println(her.getText());
        }
        WebElement elem1 = driver.findElement(By.id("lang"));
        Select select1 = new Select(elem1);
        select1.selectByIndex(4);
        List<WebElement> elementsSelected = select1.getOptions();
        for (WebElement e : elementsSelected) {
            e.getText();
        }
        WebElement country = driver.findElement(By.id("country"));
        Select seleCountry = new Select(country);
        seleCountry.selectByVisibleText("India");
        List<WebElement> selectedElement1 = seleCountry.getAllSelectedOptions();
        for (WebElement her : selectedElement1) {
            System.out.println(her.getText());
        }
    }
}

