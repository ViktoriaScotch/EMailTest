import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Inbox;
import pageObjects.LoginPage;
import pageObjects.Mail;
import pageObjects.UserMenu;

public class CheckEmailExistsTest {

    @Test
    public void checkEmail() {
        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        LoginPage loginPage = new LoginPage(driver);
        UserMenu userMenu = new UserMenu(driver);
        Mail mail = new Mail(driver);
        Inbox inbox = new Inbox(driver);

        loginPage.open();
        loginPage.loginByUser("avtotest.avtotestov@yandex.ru");

        inbox.clickOnEmailSubjectByNumber(1);
        Assert.assertEquals("Тест", mail.subjectText.getText());
        Assert.assertEquals("Виктория Халимонова", mail.senderNameText.getText());
        Assert.assertEquals("vkhalimonova@yandex.ru", mail.senderEmailText.getText());
        Assert.assertEquals("Автоматизировать тестовый сценарий с помощью Selenium WebDriver.\n" +
                "1) Открыть страницу почтового сервера; \n" +
                "2) Залогиниться под заранее подготовленным пользователем;\n" +
                "3) Найти и открыть заранее подготовленное письмо из списка Входящих;\n" +
                "4) Проверить отправителя, тему и содержание письма;\n" +
                "5) Разлогиниться.\n" +
                "Для написания автотестов использовать язык программирования Java.\n" +
                "Для тестирования можно выбрать любой общедоступный почтовый сервер (mail.ru, yandex.ru и др.)\n" +
                "Предполагается полная свобода в действиях. При оценке будут учитываться:\n" +
                "- работоспособность сценария;\n" +
                "- гибкость и адаптивность сценария (насколько просто заменить часть исходных данных, например - поиск и открытие другого письма);\n" +
                "- «живучесть» сценария (обработка ошибок и исключений). Желательно, чтобы в случае ошибки был снят и сохранен скриншот.\n" +
                "Ожидается что будете использовать Selenium или обертки над ним (например, Selenide). \n" +
                "Также для описания тестовых сценариев можно воспользоваться инструментом Cucumber (не обязательно).\n" +
                "Выполненное тестовое выложите, пожалуйста, в публичный репозиторий на Github.", mail.contentText.getText());
        userMenu.logout();
        Assert.assertTrue(wait.until(ExpectedConditions.titleIs("Авторизация")));
    }
}
