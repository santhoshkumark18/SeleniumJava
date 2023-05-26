package org.Selenium;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class JavaScriptExecuter {


    private static String sText;
    static WebDriver driver;

    //chrome browser
    public static void chromeBrowser()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    //invoking edge browser
    public static void edgeBrowser()
    {
        System.setProperty("webdriver.edge.driver","C:\\Users\\Lenovo\\eclipse-workspace\\program\\driverrr\\msedgedriver.exe");
        driver = new EdgeDriver();

    }


    public static void main (String Args[]){


        System.out.println("select your browser 1.chrome 2.edge");
        Scanner sc=new Scanner(System.in);
        int choice=sc.nextInt();
        if(choice==1)
            chromeBrowser();
        else
            edgeBrowser();

        driver.manage().window().maximize();
        driver.get("https://www.stqatools.com/");

        //Set the Script Timeout to 20 seconds
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        JavascriptExecutor jss = (JavascriptExecutor)driver;
        jss.executeScript("alert('hello world');");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        driver.switchTo().alert().dismiss();
        sText = jss.executeScript("return document.documentElement.innerText;").toString();
        System.out.println(sText);

//navigate to another web page
        jss.executeScript("window.location = 'https://stqatools.com/demo/'");

        //Switching driver position to ("https://stqatools.com/demo/");
        driver.get("https://stqatools.com/demo/");
        //Creating the JavascriptExecutor interface object by Type casting
        JavascriptExecutor js = (JavascriptExecutor)driver;

        try{



            //To enter values in the text box by finding the id
            js.executeScript("document.getElementById('studentname').value='Amol'");

            //To enter values in the text box by finding the id
            js.executeScript("document.getElementById('fathername').value='Raj'");


            //To enter values in the text box by finding the id
            js.executeScript("document.getElementById('paddress').value='Pune'");


            //To enter values in the text box by finding the id
            js.executeScript("document.getElementById('personaladdress').value='Pune'");

            //To select the gender from the radio button
            driver.findElement(By.xpath("//input[@value='male']")).click();

            //To select the city from the drop down menu
            Select city=new Select( driver.findElement(By.name("City")));
            city.selectByVisibleText("PATNA");
            driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);


            //To select the course from the drop down menu
            Select course=new Select( driver.findElement(By.name("Course")));
            course.selectByVisibleText("B.TECH");
            driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);

            //To select the district from the drop down menu
            Select dst=new Select( driver.findElement(By.name("District")));
            dst.selectByVisibleText("NALANDA");
            driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);

            //To select the state from the drop down menu
            Select st=new Select( driver.findElement(By.name("State")));
            st.selectByVisibleText("BIHAR");
            driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);

            //To enter the pin code in the text box
            driver.findElement(By.id("pincode")).sendKeys("411009");
            driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);

            //To enter the email id in the text box
            driver.findElement(By.id("emailid")).sendKeys("abc@gmail.com");
            driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

            //To submit the web page
            driver.findElement(By.xpath("//input[@value='Submit Form']")).click();
            driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
            //verfiy the page is submitted
            String check=(String) js.executeScript("return document.getElementById('studentname').value");
            if (check!="")
            {
                System.out.println("Submited");
                driver.close();
            }
            else
                System.out.println(" Not Submited");
        }
        catch (Exception e){
            e.printStackTrace();



        }

        //close the Browser
        driver.quit();

    }

}
