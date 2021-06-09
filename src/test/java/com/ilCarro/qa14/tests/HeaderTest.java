package com.ilCarro.qa14.tests;

import com.ilCarro.qa14.fw.HelperBase;
import org.testng.annotations.Test;

public class HeaderTest extends TestBase {



    @Test
    public void headerTabsTest(){

        app.header().clickOnSearchTab();
        app.header().clickOnLogoTab();
        app.car().clickOnAddCarTab();
        app.header().clickOnLogoTab();
        app.user().clickOnLoginTab();
        app.header().clickOnLogoTab();
        app.header().clickOnTermOfUseTab();
        HelperBase.wd.navigate().back();

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

