package com.ilCarro.qa14.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import java.util.NoSuchElementException;

public class HelperBase {

     public static WebDriver wd;

    public HelperBase(WebDriver wd) {

        this.wd = wd;
    }

    public boolean isElementPresent(By by){

        return wd.findElements(by).size()>0;
    }

    public boolean isElementPresent1(By locator){

        try{
            wd.findElement(locator);

            return true;
        }catch (NoSuchElementException ex){
            return false;
        }
    }

    public void type(By locator, String text) {
        if(text!=null) {
            click(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }

    public void click(By locator){

        wd.findElement(locator).click();
    }

    public void pause() throws InterruptedException {
        Thread.sleep(2000);
    }


}
