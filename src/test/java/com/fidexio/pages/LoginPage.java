package com.fidexio.pages;

import com.fidexio.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "login")
    public WebElement usernameInputField;

    @FindBy(id = "password")
    public WebElement passwordInputField;

    @FindBy(css ="button.btn.btn-primary")
    public WebElement loginButton;

    @FindBy(css = "span.oe_topbar_name")
    public WebElement logged_username;

    @FindBy(css = "p.alert.alert-danger")
    public WebElement wrong_login_warning;



}
