package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class LoginElements extends  AbstractPage{
    @FindBy(xpath = ".//a[@href='https://www.livejournal.com/login.bml?returnto=https://www.livejournal.com/&ret=1']")
    private WebElement submit;

    @FindBy(xpath = ".//input[@id='user']")
    private WebElement login;

    @FindBy(xpath = ".//input[@id='lj_loginwidget_password']")
    private WebElement password;

    @FindBy(xpath = ".//button[@ng-click='loginForm.loginUser($event)']")
    private WebElement submitLast;

    public LoginElements(WebDriver driver) {
        super(driver);
    }

    public void loginIn(String login, String password){

        Actions loginIn = new Actions(getDriver());
        loginIn.click(submit)
                .sendKeys(this.login,login)
                .click(this.password)
                .sendKeys(password)
                .click(this.submitLast)
                .build()
                .perform();
    }

}
