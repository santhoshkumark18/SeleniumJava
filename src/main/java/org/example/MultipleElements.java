package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class MultipleElements {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.letcode.in/elements");
        driver.findElement(By.name("username")).sendKeys("santhoshkumark18", Keys.ENTER);
        Thread.sleep(3000);
        List<WebElement> linkLst  = driver.findElements(By.xpath("//div[@class='block']//ol[@type='1']"));
        //List<WebElement> linkLst = new ArrayList<>();
        for(WebElement lst : linkLst) {
            System.out.println(lst.getText());
        }
        driver.close();
    }
}
