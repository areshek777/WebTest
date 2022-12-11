package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SearchTest extends org.example.AbstractTest {
    @Test
    void search(){
        new LoginElements(getWebDriver())
                .loginIn("Testacc123","Qwerty12345678");
        new Search(getWebDriver())
                .searchArticle("Факты");
        Assertions.assertTrue(getWebDriver().getTitle().contains("Поиск по ЖЖ"), "поиск не выполнен");
    }
}
