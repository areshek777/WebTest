package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginTest extends org.example.AbstractTest {
    @Test
    void loginInSecond(){
        new LoginElements(getWebDriver())
                .loginIn("Testacc123","Qwerty12345678");
        Assertions.assertDoesNotThrow( ()-> getWebDriver().navigate().to("https://testacc123.livejournal.com"),
                "Ошибка авторизации");
    }
}
