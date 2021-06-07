package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

    //preconditions: user should be logged out

    @BeforeMethod
    public void ensurePrecondition(){
        if(!isSignUpFormPresent()){      // sign up not present
            logout();
        }
    }

    @Test
    public void signUpTest(){
        //first_name
        //second_name
        //email
        //password
        //check_policy
        click(By.cssSelector("[href='/signup']"));
        isLoginFormPresent();

        type(By.cssSelector("#first_name"), "Sara1");

        type(By.cssSelector("#second_name"), "Lid1");

        type(By.cssSelector("#email"), "saralid11@gmail.com");

        type(By.cssSelector("#password"), "Sl12345689");

        click(By.cssSelector("#check_policy"));
        submit();
        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='signup__registration_title ']/h2[contains(.,'Log in')]")));
        
        //click on SignUp Button
        //fill registration form
        //click Submit button
        //check login form displayed
    }


}
