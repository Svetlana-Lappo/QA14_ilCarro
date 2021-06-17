package com.ilCarro.qa14.tests;

import com.ilCarro.qa14.models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateAccountTest extends TestBase {



    //preconditions: user should be logged out

    @BeforeMethod
    public void ensurePrecondition(){
        app.user().ensurePrecondition();
    }

    @Test
    public void signUpTest(){

        //click on SignUp Tab on the Header
        app.header().clickOnSignUpTab();
        app.user().isSignUpFormPresent();

        //fill registration form
        app.user().fillRegistrationForm(new User()
                .withFirstName("Sara17")
                .withSecondName("Lid17")
                .withEmail("saralid" + System.currentTimeMillis() + "@gmail.com")
                .withPassword("Sl12345676"));

        app.user().clickCheckPolicy();

        //click Submit button
        app.user().submit();

        //check login form displayed
        app.user().isLoginFormPresent();


    }

    @Test(enabled = false,dataProvider = "validUser", dataProviderClass = DataProviders.class)
    public void signUpFromDataProviderTest(String fName,String sName,String email,String password){

        //click on SignUp Tab on the Header
        app.header().clickOnSignUpTab();
        app.user().isSignUpFormPresent();

        //fill registration form
        app.user().fillRegistrationForm(new User()
                .withFirstName(fName)
                .withSecondName(sName)
                .withEmail(email)
                .withPassword(password));

        app.user().clickCheckPolicy();
        //click Submit button
        app.user().submit();
        logger.info("Login form present. Actual result: " + app.user().isLogInFormPresent()
                + ". Expected result: true.");

        //check login form displayed
        app.user().isLoginFormPresent();



    }

    @Test(enabled = false,dataProvider = "validUserFromCSV", dataProviderClass = DataProviders.class)
    public void signUpFromDataProviderFromCSVTest(User user){

        //click on SignUp Tab on the Header
        app.header().clickOnSignUpTab();
        app.user().isSignUpFormPresent();

        //fill registration form
        app.user().fillRegistrationForm(user);

        app.user().clickCheckPolicy();
        //click Submit button
        app.user().submit();
        logger.info("Login form present. Actual result: " + app.user().isLogInFormPresent()
                + ". Expected result: true.");
//        logger.info("Login form present. Actual result:"+ String.valueOf(app.user().isLogInFormPresent()) + ". Expected result: true");
        //check login form displayed
        app.user().isLoginFormPresent();



    }


}
