package com.ilCarro.qa14.tests;

import org.testng.annotations.Test;

public class FooterTest extends TestBase {


    @Test
    public void footerLogoLinkTest1(){
        app.footer().jumpToFooter();
        app.footer().clickOnLogoTabOnFooter();
        app.header().isFindCarFormPresent();

    }



}
