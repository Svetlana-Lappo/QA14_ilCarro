package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FooterTest extends TestBase{

   @Test
    public void footerLogoLinkTest(){
       jumpToFooter();
       click(By.xpath("//div[@class='footer__top_row_logo']/a[@class='active']"));
       jumpToFooter();
       Assert.assertTrue(isElementPresent(By.cssSelector(".footer__red_text")));
   }

    @Test
    public void footerLogoLinkTest1(){
        jumpToFooter();
        click(By.xpath("//div[@class='footer__top_row_logo']/a[@class='active']"));
        Assert.assertTrue(isElementPresent(By.cssSelector(".Main_mainpage__find_your_car__AHLkw")));
    }
}
