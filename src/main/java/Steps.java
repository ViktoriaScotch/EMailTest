import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class Steps extends Hooks {

    public void loginByUser(String user) {
        loginPage.firstEnterButton.click();
        Assert.assertEquals("Страница \"Авторизация\" не открыта!", "Авторизация", driver.getTitle());

        loginPage.loginField.sendKeys(user);
        Assert.assertEquals("Логин не введён в поле!", loginPage.loginField.getAttribute("value"), user);
        loginPage.secondEnterButton.click();

        String password = ConfProperties.getProperty(user);
        wait.until(ExpectedConditions.visibilityOf(loginPage.passwordField));
        loginPage.passwordField.sendKeys(password);
        Assert.assertEquals("Пароль не введён в поле!", password, loginPage.passwordField.getAttribute("value"));
        loginPage.secondEnterButton.click();
    }

    public void logout() {
        userMenu.userButton.click();
        userMenu.exitButton.click();
    }

    public void openPage(String page) {
        driver.get(page);
    }

    public void checkTabName(String tabName) {
        Assert.assertTrue(wait.until(ExpectedConditions.titleIs(tabName)));
    }

    public void checkTabNameContains(String tabName) {
        Assert.assertTrue(wait.until(ExpectedConditions.titleContains(tabName)));
    }

    public void checkFieldValue(WebElement webElement, String value) {
        Assert.assertEquals(webElement.getText(), webElement.getText(), value);
    }

    public void checkFieldValueContains(WebElement webElement, String value) {
        Assert.assertTrue(webElement.getText().contains(value));
    }

    public void fillFieldWithValue(WebElement webElement, String value) {
        webElement.sendKeys(value);
    }

    public void elementIsDisplayed(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void clickOnElementCollectionByNumber(TableColumns nameOfElementCollection, int number) {
        List<WebElement> e = new ArrayList<WebElement>();
        switch (nameOfElementCollection) {
            case SUBJECT:
                e = driver.findElementsByXPath("//span[contains(@class, 'Item_subjectWrapper')]");
                break;
            case DATE:
            case SENDER:
            case CHECKBOX:
            case FIRSTLINE:
                break;
        }
        e.get(number - 1).click();
    }

    enum TableColumns {
        CHECKBOX,
        SENDER,
        SUBJECT,
        FIRSTLINE,
        DATE
    }
}
