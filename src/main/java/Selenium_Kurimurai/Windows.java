package Selenium_Kurimurai;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Windows {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\2269280\\Downloads\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://letcode.in/windows");
        driver.manage().window().maximize();
        driver.findElement(By.id("home")).click();
        Set<String> windowshandles = driver.getWindowHandles();
        List<String> lst = new ArrayList<>(windowshandles);
        for(String str : lst ) {
            System.out.println(str);
        }
        System.out.println(lst.size());
        driver.switchTo().window(lst.get(1));
        driver.findElement(By.linkText("Inner HTML")).click();
        //Navigate back
        driver.switchTo().window(lst.get(0));
    }
}
