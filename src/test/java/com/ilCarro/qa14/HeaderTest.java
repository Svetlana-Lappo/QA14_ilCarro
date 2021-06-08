package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        super.ensurePrecondition();
    }

    @Test
    public void headerTabsTest(){

        clickOnSearchTab();
        clickOnLogoTab();
        clickOnAddCarTab();
        clickOnLogoTab();
        clickOnLoginTab();
        clickOnLogoTab();
        clickOnTermOfUseTab();
        wd.navigate().back();

    }

//    @Test
//    public void searchTabTest(){
//
//        click(By.xpath("//ul[@class='header__nav desktop']/li/a[@href='/search']"));
//        Assert.assertTrue(isElementPresent(By.cssSelector(".search-sidebar__inner")));
//    }
//
//    @Test
//    public void letTheCarWorkTabTest(){
//        click(By.xpath("//ul[@class='header__nav desktop']/li/a[@href='/car']"));
//        Assert.assertTrue(isElementPresent(By.tagName("h3")));
//    }
//    @Test
//    public void termOfUseTabTest(){
//        click(By.xpath("//ul[@class='header__nav desktop']/li/a[@href='/terms']"));
//        //or man can write:
//       // wd.findElement(By.xpath("//ul[@class='header__nav desktop']/li[3]")).click();
//        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='container-full']/h1[contains(.,'Terms')]")));
//
//
//    }

//    @Test
//    public void logInTabTest(){
//        click(By.xpath("//ul[@class='header__nav desktop']/li/a[@href='/login']"));
//        Assert.assertTrue(isElementPresent(By.cssSelector(".signup__fields")));
//    }




}

