package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

    //preconditions: user should be logged out

    @BeforeMethod
    public void ensurePrecondition(){
        super.ensurePrecondition();
    }

    @Test
    public void signUpTest(){

        //click on SignUp Tab on the Header
        clickOnSignUpTab();
        isSignUpFormPresent();

        //fill registration form
        fillRegistrationForm(new User()
                .withFirstName("Sara13")
                .withSecondName("Lid13")
                .withEmail("saralid13@gmail.com")
                .withPassword("Sl12345687"));

        clickCheckPolicy();
        //click Submit button
        submit();
        //check login form displayed
        isLoginFormPresent();


    }


}
