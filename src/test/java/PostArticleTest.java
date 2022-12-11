package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PostArticleTest extends org.example.AbstractTest {
    @Test
    void postArt(){
        new LoginElements(getWebDriver())
                .loginIn("Testacc123","Qwerty12345678");
        new PostArticle(getWebDriver())
                .Post("Факты", "Тесты");
        Assertions.assertTrue(getWebDriver().findElement(By.xpath("//*[@id='entry-testacc123-10494']/header/h3/a")).getText().equals("Факты"));
    }
}
