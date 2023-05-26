package org.Selenium;

import org.openqa.selenium.chrome.ChromeDriver;

public class Title {
    public static void main(String[] args) {
        //getTitle
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.letcode.in/");
        String title = driver.getTitle();
        System.out.println(title);

        //Get Page Source

        String source = driver.getPageSource();
        System.out.println(source);
        driver.quit();
    }
}
