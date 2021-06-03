package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        if(!isElementPresent(By.cssSelector("[href='/signup']"))){      // sign up not present
            wd.findElement(By.xpath("//a[contains(.,'logOut')]")).click(); //click on logout button
        }
    }

    @Test
    public void searchTabTest(){

        wd.findElement(By.xpath("//ul[@class='header__nav desktop']/li/a[@href='/search']")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector(".search-sidebar__inner")));
    }

    @Test
    public void letTheCarWorkTabTest(){
        wd.findElement(By.xpath("//ul[@class='header__nav desktop']/li/a[@href='/car']")).click();
        Assert.assertTrue(isElementPresent(By.tagName("h3")));
    }
    @Test
    public void termOfUseTabTest(){
        wd.findElement(By.xpath("//ul[@class='header__nav desktop']/li/a[@href='/terms']")).click();
        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='container-full']/h1[contains(.,'Terms')]")));

    }

    @Test
    public void logInTabTest(){
        wd.findElement(By.xpath("//ul[@class='header__nav desktop']/li/a[@href='/login']")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector(".signup__fields")));
    }

    @Test
    public void headerTabsTest(){

        wd.findElement(By.xpath("//ul[@class='header__nav desktop']/li/a[@href='/search']")).click();
        if(isElementPresent(By.cssSelector(".search-sidebar__inner"))){
            System.out.println("Search was opened");
        }
        //wd.navigate().back();
        wd.findElement(By.xpath("//section[@class='container header']/a[@class='active']")).click();
        wd.findElement(By.xpath("//ul[@class='header__nav desktop']/li/a[@href='/car']")).click();
        if(isElementPresent(By.tagName("h3"))){
            System.out.println("Let the car work was opened");
        }
        //wd.navigate().back();
        wd.findElement(By.xpath("//section[@class='container header']/a[@class='active']")).click();
        wd.findElement(By.xpath("//ul[@class='header__nav desktop']/li/a[@href='/login']")).click();
        if(isElementPresent(By.cssSelector(".signup__fields"))){
            System.out.println("Login was opened");
        }
        //wd.navigate().back();
        wd.findElement(By.xpath("//section[@class='container header']/a[@class='active']")).click();
        wd.findElement(By.xpath("//ul[@class='header__nav desktop']/li/a[@href='/terms']")).click();
        if(isElementPresent(By.xpath("//div[@class='container-full']/h1[contains(.,'Terms')]"))){
            System.out.println("Terms of use was opened");
        }
        wd.navigate().back();


    }


}

