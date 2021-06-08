package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{


    @Test
    public void loginRegisteredUserPositiveTest(){
        //go to login page
        clickOnLoginTab();
        //fill login form
        fillLoginForm(new User().withEmail("saralid11@gmail.com").withPassword("Sl12345689"));
        //submit login
        submit();
        //assert user logged in
        isLogoutTabPresent();



    }
    @Test
    public void loginRegisteredUserWithWrongPasswordNegativeTest(){
        //go to login page
        clickOnLoginTab();
        //fill login form
        fillLoginForm(new User().withEmail("saralid11@gmail.com").withPassword("sl12345689"));
        //submit login
        submit();
        //assert user not logged in
        isLogoutTabNotPresent();


    }

}
