package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    static WebDriver wd;

    @BeforeSuite
    public void setUp(){

        wd = new ChromeDriver();
        wd.get("https://ilcarro-dev-v1.firebaseapp.com/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public boolean isElementPresent(By by){

        return wd.findElements(by).size()>0;
    }

    public boolean isElementPresent1(By locator){

        try{
            wd.findElement(locator);

            return true;
        }catch (NoSuchElementException ex){
            return false;
        }
    }

    @AfterMethod(enabled = false)
    public void tearDown(){

        wd.quit();
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

    public void type(By locator, String text) {
        if(text!=null) {
            click(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }

    public void click(By locator){

        wd.findElement(locator).click();
    }

    public void submit() {

        click(By.cssSelector("[type='submit']"));
    }

    public void isLogoutTabPresent() {

        Assert.assertTrue(isElementPresent(By.xpath("//a[contains(.,'logOut')]")));
    }

    public void jumpToFooter(){

        wd.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,Keys.END);
    }

    public void clickOnLoginTab() {
        click(By.xpath("//ul[@class='header__nav desktop']/li/a[@href='/login']"));
    }

    @BeforeMethod

    public void ensurePrecondition(){
        //go to login
        //if user logged in, click logout, go to login
        if(!isSignUpTabPresent()){
            logout();
        }
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

    public void pause() throws InterruptedException {
        Thread.sleep(2000);
    }

    public void clickOnAddCarTab() {
        click(By.xpath("//ul[@class='header__nav desktop']/li[2]"));
    }

    public void fillCarForm(Car car) {
        type(By.cssSelector(".country"), car.getCountry());
        type(By.cssSelector(".address"), car.getAddress());
        type(By.cssSelector(".distance_included"), car.getDistance());
    }

    public void isLoginFormPresent() {
        Assert.assertTrue(isElementPresent1(By.xpath("//div[@class='signup__registration_title ']/h2[contains(.,'Log in')]")));
    }

    public void clickCheckPolicy() {
        click(By.cssSelector("#check_policy"));
    }

    public void clickOnSignUpTab() {
        click(By.cssSelector("[href='/signup']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.cssSelector("#first_name"), user.getFirstName());
        type(By.cssSelector("#second_name"), user.getSecondName());
        type(By.cssSelector("#email"), user.getEmail());
        type(By.cssSelector("#password"), user.getPassword());
    }

    public boolean isFindCarFormPresent() {
        return isElementPresent(By.cssSelector(".Main_mainpage__find_your_car__AHLkw"));
    }

    public void isLogoutTabNotPresent() {
        Assert.assertFalse(isElementPresent(By.xpath("//a[contains(.,'logOut')]")));
    }

    public void clickOnButtonSubmitOnCarAddPage() {
        click(By.cssSelector(".let-carwork-style_let_car__submit__17482"));
    }

    public void clickOnTermOfUseTab() {
        click(By.xpath("//ul[@class='header__nav desktop']/li/a[@href='/terms']"));
    }

    public void clickOnLogoTab() {
        click(By.xpath("//section[@class='container header']/a[@class='active']"));
    }

    public void clickOnSearchTab() {
        click(By.xpath("//ul[@class='header__nav desktop']/li/a[@href='/search']"));
        Assert.assertTrue(isElementPresent1(By.cssSelector(".search-sidebar__inner")));
    }

    public void clickOnLogoTabOnFooter() {
        click(By.xpath("//div[@class='footer__top_row_logo']/a[@class='active']"));
    }
}
