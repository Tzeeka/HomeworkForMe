package com.Homework.Gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MailTest {
    ChromeDriver driver = new ChromeDriver();

    @Test
    public void LoginTest() throws InterruptedException {

        driver.get("https://gmail.com");

        WebElement login = driver.findElement(By.cssSelector("#identifierId"));
        login.sendKeys("enter@youMail.com");
        Thread.sleep(2000);

        WebElement nextButton = driver.findElement(By.cssSelector("#identifierNext > content > span"));
        nextButton.click();
        Thread.sleep(1000);

        WebElement password = driver.findElement(By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input"));
        password.sendKeys("EnterPassword");
        Thread.sleep(1000);

        WebElement nextButton2 = driver.findElement(By.cssSelector("#passwordNext > content > span"));
        nextButton2.click();
        Thread.sleep(5000);

    }

    @Test

    public void findMail()throws InterruptedException {

        WebElement searchBox = driver.findElement(By.cssSelector("#gbqfq"));
        searchBox.sendKeys("TestHomework");

        WebElement search = driver.findElement(By.cssSelector("#gbqfb > span"));
        search.click();

        Thread.sleep(4000);

        Actions actions = new Actions(driver);
        WebElement findedMail = driver.findElement(By.cssSelector("#\\3a 6j > span"));
        actions.moveToElement(findedMail).build().perform();
        findedMail.click();

        Thread.sleep(3000);

        WebElement senderMail = driver.findElement(By.cssSelector("#\\3a 7t > div.adn.ads > div.gs > div.gE.iv.gt > table > tbody > tr:nth-child(1) > td.gF.gK > table > tbody > tr > td > h3 > span.go"));
        String senderMailTxt = senderMail.getText();
        System.out.println(senderMailTxt);
        Assert.assertTrue(senderMailTxt.equals("<tzeeka@gmail.com>"));

        WebElement mailBody = driver.findElement(By.cssSelector("#\\3a 7v > div:nth-child(1)"));
        String mailBodyTxt = mailBody.getText();
        Assert.assertTrue(mailBodyTxt.equals("Это нужное письмо"));

        WebElement theme = driver.findElement(By.cssSelector("#\\3a 71 > span"));
        String themeTxt = theme.getText();
        Assert.assertTrue(themeTxt.equals("TestHomework"));

        driver.quit();

    }
}
