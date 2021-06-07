package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod

    public void ensurePrecondition(){
        //go to login
        //if user logged in, click logout, go to login
        if(!isSignUpFormPresent()){
            logout();
        }
    }



    @Test
    public void loginRegisteredUserPositiveTest(){
        //go to login page
        click(By.xpath("//ul[@class='header__nav desktop']/li/a[@href='/login']"));
        //fill login form
        type(By.cssSelector("[name='email']"),"saralid11@gmail.com");
        type(By.name("password"),"Sl12345689");
        //submit login
        submit();
        isLogoutTabPresent();
        //assert user logged in


    }

}
