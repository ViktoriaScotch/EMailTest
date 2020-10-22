package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Mail {
    public WebDriver driver;

    public Mail(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[contains(@class, 'mail-Message-Toolbar-Subject')]")
    public WebElement subjectText;

    @FindBy(xpath = "//span[contains(@class, 'mail-Message-Sender-Name')]")
    public WebElement senderNameText;

    @FindBy(xpath = "//span[contains(@class, 'mail-Message-Sender-Email')]")
    public WebElement senderEmailText;

    @FindBy(xpath = "//div[contains(@class, 'mail-Message-Body-Content')]")
    public WebElement contentText;

}
