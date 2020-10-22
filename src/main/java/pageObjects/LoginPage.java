package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[contains(@class, 'button2_theme_mail-white')]")
    public WebElement firstEnterButton;

    @FindBy(xpath = "//div[contains(@class, 'passp-sign-in-button')]/button")
    public WebElement secondEnterButton;

    @FindBy(xpath = "//input[@name='login']")
    public WebElement loginField;

    @FindBy(xpath = "//*[@id='passp-field-passwd']")
    public WebElement passwordField;

}
