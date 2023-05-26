package Selenium_Kurimurai;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.util.List;

public class Tables {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\2269280\\Downloads\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://letcode.in/table");
        driver.manage().window().maximize();
        WebElement ele=driver.findElement(By.cssSelector("table#simpletable>tbody"));
        List<WebElement> rows = ele.findElements(By.tagName("tr"));
        System.out.println(rows.size());
        for(int i=0;i< rows.size();i++) {
        List<WebElement> cols = driver.findElements(By.tagName("td"));
        WebElement data = cols.get(3);
            if(data.getText().equals("Iron")) {
                cols.get(3).findElement(By.tagName("input")).click();
                break;
            }
            System.out.println();
        }
    }
}
