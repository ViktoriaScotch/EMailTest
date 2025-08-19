package pageObjects;

import config.ConfProperties;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    @FindBy(xpath = "//a[contains(@class, 'button2_theme_mail-white')]")
    private WebElement firstEnterButton;

    @FindBy(xpath = "//div[contains(@class, 'passp-sign-in-button')]/button")
    private WebElement secondEnterButton;

    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id='passp-field-passwd']")
    private WebElement passwordField;

    public void open() {
        driver.get("https://mail.yandex.ru/");
        Assert.assertTrue(wait.until(ExpectedConditions.titleContains("Яндекс.Почта")));
    }

    public void loginByUser(String user) {
        firstEnterButton.click();
        Assert.assertEquals("Страница \"Авторизация\" не открыта!", "Авторизация", driver.getTitle());

        loginField.sendKeys(user);
        Assert.assertEquals("Логин не введён в поле!", loginField.getAttribute("value"), user);
        secondEnterButton.click();

        String password = ConfProperties.getProperty(user);
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
        Assert.assertEquals("Пароль не введён в поле!", password, passwordField.getAttribute("value"));
        secondEnterButton.click();
        Assert.assertTrue(wait.until(ExpectedConditions.titleContains("Яндекс.Почта")));
    }
}
