package com.ilCarro.qa14.tests;

import com.ilCarro.qa14.tests.TestBase;
import org.testng.annotations.Test;

public class OpenHomePage extends TestBase {

    @Test

    public void homePageTest(){
        System.out.println("FindCarForm: "+ app.header().isFindCarFormPresent());
    }




}
