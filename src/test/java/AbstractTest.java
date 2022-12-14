import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;



public class AbstractTest {
    private static WebDriver driver;

    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @BeforeEach
    void goTo(){
        Assertions.assertDoesNotThrow( ()-> driver.navigate().to("https://www.livejournal.com"),
                "Страница не доступна");
            Actions actions = new Actions(driver);
                actions.click(driver.findElement(By.xpath(".//a[@href='https://www.livejournal.com/login.bml?returnto=https://www.livejournal.com/&ret=1']")))
               .pause(1000l)
               .sendKeys(driver.findElement(By.xpath(".//input[@id='user']")), "Testacc123")
               .sendKeys(driver.findElement(By.xpath(".//input[@id='lj_loginwidget_password']")), "Qwerty12345678")
               .click(driver.findElement((By.xpath(".//button[@ng-click='loginForm.loginUser($event)']"))));

    }



    @AfterAll
    static void close(){
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
