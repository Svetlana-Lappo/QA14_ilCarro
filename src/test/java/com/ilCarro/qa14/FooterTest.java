package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FooterTest extends TestBase{


    @Test
    public void footerLogoLinkTest1(){
        jumpToFooter();
        clickOnLogoTabOnFooter();
        isFindCarFormPresent();

    }
 /*  @Test
    public void footerLogoLinkTest(){
       jumpToFooter();
       clickOnLogoTabOnFooter();
       jumpToFooter();
       Assert.assertTrue(isElementPresent(By.cssSelector(".footer__red_text")));
   }*/


}
