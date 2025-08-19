package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Inbox {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public Inbox (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    @FindBy(xpath = "//span[contains(@class, 'Item_subjectWrapper')]")
    private List<WebElement> subjects;

    public void clickOnEmailSubjectByNumber(int number) {
        subjects.get(number - 1).click();
        Assert.assertTrue(wait.until(ExpectedConditions.titleContains("Письмо")));

    }
}
