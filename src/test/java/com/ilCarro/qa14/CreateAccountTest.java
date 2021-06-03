package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

    //preconditions: user should be logged out

    @BeforeMethod
    public void ensurePrecondition(){
        if(!isElementPresent(By.cssSelector("[href='/signup']"))){      // sign up not present
            wd.findElement(By.xpath("//a[contains(.,'logOut')]")).click(); //click on logout button
        }
    }

    @Test
    public void signUpTest(){
        //first_name
        //second_name
        //email
        //password
        //check_policy
        wd.findElement(By.cssSelector("[href='/signup']")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("form.signup__fields")));
        wd.findElement(By.cssSelector("#first_name")).click();
        wd.findElement(By.cssSelector("#first_name")).clear();
        wd.findElement(By.cssSelector("#first_name")).sendKeys("SS1");
        wd.findElement(By.cssSelector("#second_name")).click();
        wd.findElement(By.cssSelector("#second_name")).clear();
        wd.findElement(By.cssSelector("#second_name")).sendKeys("LL1");
        wd.findElement(By.cssSelector("#email")).click();
        wd.findElement(By.cssSelector("#email")).clear();
        wd.findElement(By.cssSelector("#email")).sendKeys("ss1@gmail.com");
        wd.findElement(By.cssSelector("#password")).click();
        wd.findElement(By.cssSelector("#password")).clear();
        wd.findElement(By.cssSelector("#password")).sendKeys("SL1234567");
        wd.findElement(By.cssSelector("#check_policy")).click();
    }
    //click on SignUp Button
    //fill registration form
    //click Submit button
    //check login form displayed



}
