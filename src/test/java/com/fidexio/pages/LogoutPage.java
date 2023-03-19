package com.fidexio.pages;
import com.fidexio.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

    public LogoutPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "span.oe_topbar_name")
    public WebElement user_select_menu;

    @FindBy(xpath= "//a[.='Log out']")
    public WebElement logout_btn;

    @FindBy(tagName = "h4")
    public WebElement opps_message;

}
