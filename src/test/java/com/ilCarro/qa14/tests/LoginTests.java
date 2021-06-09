package com.ilCarro.qa14.tests;

import com.ilCarro.qa14.models.User;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {


    @Test
    public void loginRegisteredUserPositiveTest(){
        //go to login page
        app.user().clickOnLoginTab();
        //fill login form
        app.user().fillLoginForm(new User().withEmail("saralid11@gmail.com").withPassword("Sl12345689"));
        //submit login
        app.user().submit();
        //assert user logged in
        app.user().isLogoutTabPresent();



    }
    @Test
    public void loginRegisteredUserWithWrongPasswordNegativeTest(){
        //go to login page
        app.user().clickOnLoginTab();
        //fill login form
        app.user().fillLoginForm(new User().withEmail("saralid11@gmail.com").withPassword("sl12345689"));
        //submit login
        app.user().submit();
        //assert user not logged in
        app.user().isLogoutTabNotPresent();


    }

}
