package com.ilCarro.qa14.tests;

import com.ilCarro.qa14.models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
                .withFirstName("Sara14")
                .withSecondName("Lid14")
                .withEmail("saralid14@gmail.com")
                .withPassword("Sl12345686"));

        app.user().clickCheckPolicy();
        //click Submit button
        app.user().submit();
        //check login form displayed
        app.user().isLoginFormPresent();


    }


}
