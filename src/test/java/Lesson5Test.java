import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;



public class Lesson5Test  extends AbstractTest{

    @Test
    void testAuth() throws InterruptedException {
        Assertions.assertDoesNotThrow( ()-> getDriver().navigate().to("https://testacc123.livejournal.com"),
                "Ошибка авторизации");
    }

    @Test
    void testPost() throws InterruptedException {
        Actions actions = new Actions(getDriver());
        actions.pause(3000l)
                .click(getDriver().findElement(By.xpath("//*[@id=\"js\"]/body/div[2]/header/div/nav[2]/ul/li[4]/a")))
                .pause(1000l)
                .sendKeys(getDriver().findElement(By.xpath(".//textarea")), "Факты")
                .pause(1000l)
                .sendKeys(getDriver().findElement(By.xpath(".//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']")), "Около 13500 домов было уничтожено при великом и знаменитом пожаре в Лондоне в 1666 году.")
                .pause(1000l)
                .click(getDriver().findElement(By.xpath(".//button/span[(text()='Настроить и опубликовать')]")))
                .pause(1000l)
                .click(getDriver().findElement(By.xpath(".//footer/div/button")));
        Assertions.assertTrue(getDriver().getTitle().contains("Факты: testacc123 — ЖЖ"), "Ваша статья не опубликована");

    }

    @Test
    void testComment() throws InterruptedException {
        Actions actions = new Actions(getDriver());
        actions.click(getDriver().findElement(By.xpath(".//div[@class='s-logo']/a[@href='https://www.livejournal.com']")))
                .pause(1000l)
                .click(getDriver().findElement(By.xpath(".//body/div[2]/div[3]/div[1]/section[1]/div/div/div[1]/div[1]/div/div/article/a")))
                .pause(1000l)
                .click(getDriver().findElement(By.xpath(".//*[@id='comments']/div/div[2]/div[1]/a")))
                .pause(1000l)
                .sendKeys(getDriver().findElement(By.xpath(".//div[@role='textbox']")), "тест")
                .pause(1000l)
                .click(getDriver().findElement(By.id("comment_submit")));
       String a = String.valueOf(getDriver().findElement(By.xpath("(.//p[contains(text(),'тест')")));
       Assertions.assertTrue(".//p[contains(text(),'тест')]" == a);
    }

    @Test
    void testSearch() throws InterruptedException {
        Actions actions = new Actions(getDriver());
        actions.click(getDriver().findElement(By.xpath(".//ul[@class='s-do']/li/div/form/button")))
                .pause(1000l)
                .sendKeys(getDriver().findElement(By.xpath(".//ul[@class='s-do']/li/div/form/button")))
                .pause(1000l)
                .click(getDriver().findElement(By.xpath(".//ul[@class='s-do']/li/div/form/button")));
        Assertions.assertTrue(getDriver().getTitle().contains("Поиск по ЖЖ"), "поиск не выполнен");
    }

}
