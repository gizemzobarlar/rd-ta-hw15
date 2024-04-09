package com.rd.tests;

import com.rd.drivers.Driver;
import com.rd.utils.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class XpathTest {

    public static WebDriver driver;
    Driver webDriver = new Driver();
    PropertyManager propertyManager= new PropertyManager();
    String url =propertyManager.getProperty("APP_URL");



    @BeforeMethod
    public void before() throws MalformedURLException {
        driver = webDriver.initializeDriver();
        driver.get(url);
    }

    @Test(priority=1)
    public void openDemoQAPageTest() {
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle,"DEMOQA");
    }

    @Test(priority=2)
    public void clickButtons(){
        WebElement Buttons = driver.findElement(By.xpath("//span[contains(text(),'Buttons')]"));
        Buttons.click();
    }

    @Test(priority=3)
    public void clickMeClick(){
        WebElement clickMe = driver.findElement(By.xpath("//button[@id='1jNQ8']"));
        clickMe.click();
    }

    @Test(priority=4)
    public void read(){
        WebElement readText = driver.findElement(By.xpath("//p[@id='dynamicClickMessage']"));
        String text = readText.getText();
        Assert.assertEquals(text, "You have done a dynamic click");
    }

    @AfterMethod
    public void close(){
        webDriver.quitDriver();
    }
}