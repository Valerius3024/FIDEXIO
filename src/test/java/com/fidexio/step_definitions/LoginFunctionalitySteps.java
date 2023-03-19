package com.fidexio.step_definitions;

import com.fidexio.pages.LoginPage;
import com.fidexio.utilities.ConfigurationReader;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginFunctionalitySteps {

    LoginPage homePage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("urlLoginPage"));
    }

    @When("user enters username")
    public void user_enters_username() {
        homePage.usernameInputField.sendKeys("salesmanager13@info.com");
    }

    @Then("user enters password")
    public void user_enters_password() {
        homePage.passwordInputField.sendKeys("salesmanager");
    }

    @Then("user hits enter button from keyboard")
    public void user_hits_enter_button_from_keyboard() {
        homePage.loginButton.sendKeys(Keys.ENTER);
    }

    @Then("user logged in application")
    public void user_logged_in_application() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));
        Assert.assertEquals("#Inbox - Odoo", Driver.getDriver().getTitle());
    }

    @And("user clicks button from keyboard")
    public void user_Clicks_Button_From_Keyboard() {
        homePage.loginButton.click();
    }

    @When("enters invalid username")
    public void enters_invalid_username() {
        homePage.usernameInputField.sendKeys("notavalid@info.com");
    }

    @Then("enters invalid password")
    public void enters_invalid_password() {
        homePage.passwordInputField.sendKeys("invalidpass");
    }

    @Then("clicks login button")
    public void clicks_login_button() {
        homePage.loginButton.click();
    }

    @Then("user can NOT login application")
    public void user_can_not_login_application() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(homePage.wrong_login_warning));
        Assert.assertTrue(homePage.wrong_login_warning.isDisplayed());
    }

    @Then("user gets empty field notification")
    public void user_gets_empty_field_notification() throws Exception {
        Driver.takeSnapShot("target/validate_image.png");
        Assert.assertEquals("Please fill out this field.",
                homePage.passwordInputField.getAttribute("validationMessage"));
    }

    @Then("password is covered by dot signs")
    public void password_is_covered_by_dot_signs() throws Exception {

        Driver.takeSnapShot("target/password_hidden.png");
        Assert.assertEquals("password", homePage.passwordInputField.getAttribute("type"));

       /* if (homePage.passwordInputField.getAttribute("type").equals("password"))
            System.out.println("it should be MASKED on default by browser");
       */
    }

}
