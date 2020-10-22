import org.junit.Test;

public class CheckEmailExist extends Steps{

    @Test
    public void checkEmail() {
        openPage("https://mail.yandex.ru/");
        checkTabNameContains("Яндекс.Почта");

        loginByUser("avtotest.avtotestov@yandex.ru");
        checkTabNameContains("Входящие — Яндекс.Почта");

        clickOnElementCollectionByNumber(TableColumns.SUBJECT, 1);
        checkTabNameContains("Письмо");
        checkFieldValue(mail.subjectText, "Тест");
        checkFieldValue(mail.senderNameText, "Виктория Халимонова");
        checkFieldValue(mail.senderEmailText, "vkhalimonova@yandex.ru");
        checkFieldValue(mail.contentText, "Автоматизировать тестовый сценарий с помощью Selenium WebDriver.\n" +
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
                "Выполненное тестовое выложите, пожалуйста, в публичный репозиторий на Github.");

        logout();
        checkTabName("Авторизация");
    }
}
