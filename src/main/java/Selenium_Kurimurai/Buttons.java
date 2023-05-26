package Selenium_Kurimurai;

import org.Selenium.Navigation;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Buttons {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\2269280\\Downloads\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://letcode.in/windows");
        driver.manage().window().maximize();
        //driver.findElement(By.xpath("//*[@id=\"home\"]")).click();
        /*WebElement ele = driver.findElement(By.xpath("//*[@id=\"fruits\"]"));
        Select slt = new Select(ele);
        slt.selectByVisibleText("Apple");
       *//* slt.selectByIndex(2);
        slt.selectByValue("Mango");*//*
       WebElement mul= driver.findElement(By.xpath("//*[@id=\"superheros\"]"));
       Select st = new Select(mul);
        System.out.println(st.isMultiple());
        st.selectByValue("ca");
        st.selectByIndex(4);
        st.deselectByValue("ca");*/

     /*   driver.findElement(By.id("accept")).click();
       Alert alt= driver.switchTo().alert();
        System.out.println(alt.getText());
        alt.accept();


        driver.findElement(By.id("confirm")).click();
        Alert alert1 = driver.switchTo().alert();
        String txt1 = alert1.getText();
        System.out.println(txt1);
        driver.switchTo().alert().dismiss();

        //Prompt alert
        driver.findElement(By.id("prompt")).click();
        Alert alert2 = driver.switchTo().alert();
        alert2.sendKeys("Santhosh Kumar K");
        driver.switchTo().alert().accept();*/

       /* driver.switchTo().frame("firstFr");
        driver.findElement(By.name("fname")).sendKeys("SANTHOSH KUMAR K");
        driver.switchTo().frame(1);
        driver.findElement(By.name("email")).sendKeys("santhoshinrealife@gmail.com");
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("Watch tutorial")).click();*/

        driver.findElement(By.id("home")).click();
        Set<String> windowsHand = driver.getWindowHandles();
        List<String> lst = new ArrayList<>(windowsHand);
        System.out.println(lst.size());
        driver.switchTo().window(lst.get(0));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ame")));
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("");
    }
}