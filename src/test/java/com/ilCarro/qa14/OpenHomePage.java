package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class OpenHomePage extends TestBase {

    @Test

    public void homePageTest(){
        System.out.println("FindCarForm: "+ isFindCarFormPresent());
    }


//    public boolean isFindCarFormPresent1(){
//
//        return wd.findElements(By.cssSelector(".Main_mainpage__find_your_car__AHLkw")).size()>0;
//    }

}
