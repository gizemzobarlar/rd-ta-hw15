package com.rd.tests;

import com.rd.drivers.Driver;
import com.rd.utils.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class XpathTest2 {

    public static WebDriver driver;
    Driver webDriver = new Driver();
    PropertyManager propertyManager= new PropertyManager();
    String url =propertyManager.getProperty("APP_URL2");

    @BeforeMethod
    public void before() throws MalformedURLException {
        driver = webDriver.initializeDriver();
        driver.get(url);
    }

    @Test
    public void openDemoQAPageTest() {
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle,"DEMOQA");
    }


    @Test(priority=1)
    public void Add(){
        WebElement Add = driver.findElement(By.xpath("//button[@id='addNewRecordButton']"));
        Add.click();
        WebElement textWebTables = driver.findElement(By.xpath("//div[@id='registration-form-modal']"));
        String control = textWebTables.getText();
        Assert.assertEquals(control,"Registration Form");
    }

    @Test
    public void firstName(){
        WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
        firstName.click();
        firstName.sendKeys("Gizem");
    }

    @Test
    public void lastName(){
        WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
        lastName.click();
        lastName.sendKeys("Zobarlar");
    }

    @Test
    public void eMail(){
        WebElement eMail = driver.findElement(By.xpath("//input[@id='userEmail']"));
        eMail.click();
        eMail.sendKeys("asd@gmail.com");
    }

    @Test
    public void age(){
        WebElement age = driver.findElement(By.xpath("//input[@id='age']"));
        age.click();
        age.sendKeys("29");
    }

    @Test
    public void salary(){
        WebElement salary = driver.findElement(By.xpath("//input[@id='salary']"));
        salary.click();
        salary.sendKeys("1000");
    }

    public void department(){
        WebElement department = driver.findElement(By.xpath("//input[@id='department']"));
        department.click();
        department.sendKeys("TEST");
    }

    public void submit(){
        WebElement submit = driver.findElement(By.xpath("//input[@id='submit']"));
        submit.click();
    }

    public void edit(){
        WebElement edit = driver.findElement(By.xpath("span[@id='edit-record-1']"));
        edit.click();
    }

    @Test
    public void newAge(){
        WebElement newAge = driver.findElement(By.xpath("//input[@id='age']"));
        newAge.click();
        newAge.sendKeys("28");
    }

    public void submitClick(){
        WebElement submitClick = driver.findElement(By.xpath("//input[@id='submit']"));
        submitClick.click();
    }

    @AfterMethod
    public void close(){
        webDriver.quitDriver();
    }
}