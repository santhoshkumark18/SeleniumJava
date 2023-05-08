package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTableRowsAndColumn {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://letcode.in/table");
        WebElement ele=driver.findElement(By.cssSelector("table#simpletable>tbody"));
        List<WebElement> lstOfElements = ele.findElements(By.tagName("tr"));
        System.out.println(lstOfElements.size());
        for(int i=0;i<lstOfElements.size();i++) {
            List<WebElement> col=lstOfElements.get(i).findElements(By.tagName("td"));
            WebElement data= col.get(1);
            System.out.println(data.getText());
            if(data.getText().equals("Raj")) {
                col.get(3).findElement(By.tagName("input")).click();
            }
        }
       // d45a35b0


        //driver.quit();
    }
}
