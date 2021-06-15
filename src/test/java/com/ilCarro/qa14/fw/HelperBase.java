package com.ilCarro.qa14.fw;

import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
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

    public String takeScreenshot(){
      File tmp = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
     // File screenshot = new File("screenshots" + System.currentTimeMillis() + ".png");
      File screenshot = new File("C:\\Users\\HP\\Desktop\\QA\\GitHub\\QA14_ilCarro\\src\\test\\screenshots\\screenshot" + System.currentTimeMillis() + ".png");


      try {
          Files.copy(tmp, screenshot);
      } catch(IOException e){
          e.printStackTrace();
      }
      return screenshot.getAbsolutePath();
    }

    public void refresh() {
        wd.navigate().refresh();
    }


}
