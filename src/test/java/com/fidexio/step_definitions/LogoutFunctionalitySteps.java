package com.fidexio.step_definitions;

import com.fidexio.pages.LoginPage;
import com.fidexio.pages.LogoutPage;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.pool.TypePool;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutFunctionalitySteps extends LogoutPage {


    @When("user click logout select")
    public void userClickLogoutSelect() {
        user_select_menu.click();
        logout_btn.click();
    }

    @Then("verify user at login page")
    public void userVerifyLoginPage() {
        Assert.assertTrue(new LoginPage().passwordInputField.isDisplayed());
    }

    @When("user navigates back")
    public void userNavigatesBack() {
        Driver.getDriver().navigate().back();
    }

    @Then("verify user not in homepage")
    public void verifyUserNotInHomepage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(opps_message));
        Assert.assertTrue(opps_message.isDisplayed());
    }

    @Then("user logged in")
    public void user_logged_in() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(new LoginPage().logged_username));
        Assert.assertTrue(new LoginPage().logged_username.isDisplayed());
    }



}
