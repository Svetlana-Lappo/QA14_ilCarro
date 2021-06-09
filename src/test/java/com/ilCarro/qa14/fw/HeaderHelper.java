package com.ilCarro.qa14.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HeaderHelper extends HelperBase {

    public HeaderHelper(WebDriver wd) {
        super(wd);
    }

    public void clickOnSignUpTab() {
        click(By.cssSelector("[href='/signup']"));
    }

    public void clickOnTermOfUseTab() {
        click(By.xpath("//ul[@class='header__nav desktop']/li/a[@href='/terms']"));
    }

    public void clickOnSearchTab() {
        click(By.xpath("//ul[@class='header__nav desktop']/li/a[@href='/search']"));
        Assert.assertTrue(isElementPresent1(By.cssSelector(".search-sidebar__inner")));
    }

    public void clickOnLogoTab() {
        click(By.xpath("//section[@class='container header']/a[@class='active']"));
    }
    public boolean isFindCarFormPresent() {
        return isElementPresent(By.cssSelector(".Main_mainpage__find_your_car__AHLkw"));
    }
}
