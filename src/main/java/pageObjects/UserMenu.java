package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserMenu {
    public WebDriver driver;

    public UserMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[contains(@class, 'user-account_left-name')]")
    public WebElement userButton;

    @FindBy(xpath = "//span[contains(text(), 'Выйти из сервисов Яндекса')]")
    public WebElement exitButton;

    public void logout() {
        userButton.click();
        exitButton.click();
    }
}
