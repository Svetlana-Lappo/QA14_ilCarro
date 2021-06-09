package com.ilCarro.qa14.fw;

import com.ilCarro.qa14.fw.HelperBase;
import com.ilCarro.qa14.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class UserHelper extends HelperBase {

    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public boolean isSignUpTabPresent() {

        return isElementPresent(By.cssSelector("[href='/signup']"));
    }

    public void logout() {

        click(By.xpath("//a[contains(.,'logOut')]"));
    }

    public void isSignUpFormPresent() {

        Assert.assertTrue(isElementPresent1(By.xpath("//div[@class='signup__right_block']//form[@class='signup__fields']")));
    }

    public void submit() {

        click(By.cssSelector("[type='submit']"));
    }

    public void isLogoutTabPresent() {

        Assert.assertTrue(isElementPresent(By.xpath("//a[contains(.,'logOut')]")));
    }

    public void clickOnLoginTab() {
        click(By.xpath("//ul[@class='header__nav desktop']/li/a[@href='/login']"));
    }

    public void fillLoginForm(User user) {
        type(By.cssSelector("[name='email']"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void logIn() {
        clickOnLoginTab();
        type(By.cssSelector("[name='email']"), "saralid11@gmail.com");
        type(By.name("password"), "Sl12345689");
        submit();
    }

    public boolean isUserLoggedIn() {
        return  isElementPresent((By.xpath("//a[contains(.,'logOut')]"))); ////!!!!!!!
    }

    public void isLoginFormPresent() {
        Assert.assertTrue(isElementPresent1(By.xpath("//div[@class='signup__registration_title ']/h2[contains(.,'Log in')]")));
    }

    public void clickCheckPolicy() {
        click(By.cssSelector("#check_policy"));
    }

    public void fillRegistrationForm(User user) {
        type(By.cssSelector("#first_name"), user.getFirstName());
        type(By.cssSelector("#second_name"), user.getSecondName());
        type(By.cssSelector("#email"), user.getEmail());
        type(By.cssSelector("#password"), user.getPassword());
    }

    public void isLogoutTabNotPresent() {
        Assert.assertFalse(isElementPresent(By.xpath("//a[contains(.,'logOut')]")));
    }

    @BeforeMethod

    public void ensurePrecondition(){
        //go to login
        //if user logged in, click logout, go to login
        if(!isSignUpTabPresent()){
            logout();
        }
    }
}
