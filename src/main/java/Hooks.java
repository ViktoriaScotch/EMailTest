import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.LoginPage;
import pageObjects.Mail;
import pageObjects.UserMenu;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Hooks {

    public static ChromeDriver driver;
    public static WebDriverWait wait;

    public static LoginPage loginPage;
    public static UserMenu userMenu;
    public static Mail mail;

    @Before
    public void open() {
        System.setProperty("webdriver.chrome.driver", new File("").getAbsolutePath() + ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        userMenu = new UserMenu(driver);
        mail = new Mail(driver);
    }

    @After
    public void close() {
        String fileName = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        try {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("target/surefire-reports/screenshot-" + fileName + ".png"));
            System.out.println("file://" + file.toURI().getPath());
        } catch (Exception e) {
            System.out.println("Не удалось сохранить скриншот.");
        }
        driver.quit();
    }
}
