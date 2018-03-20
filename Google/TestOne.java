package com.Homework.Google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestOne {

    ChromeDriver driver = new ChromeDriver();

    @Test
    public void Test1() throws InterruptedException {

        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Bebe's Boobs Destroy Society");
        Thread.sleep(2000);
        //WebElement button = driver.findElement(By.name("btnK"));
        WebElement button = driver.findElement(By.cssSelector(".jsb"));
        button.click();
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Bebe's Boobs Destroy Society - Поиск в Google"));

    }

    @Test
    public void Test2() throws InterruptedException {
        WebElement results = driver.findElement(By.id("resultStats"));
        String resultsText = results.getText();
        Assert.assertTrue(!resultsText.equals(null));
        Thread.sleep(5000);

        driver.quit();

    }



}

