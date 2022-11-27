package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppMain {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //Тест №1
        driver.get("https://www.livejournal.com");
        driver.findElement(By.xpath(".//a[@href='https://www.livejournal.com/login.bml?returnto=https://www.livejournal.com/&ret=1']")).click();
        driver.findElement(By.xpath(".//input[@id='user']")).sendKeys("Testacc123");
        driver.findElement(By.xpath(".//input[@id='lj_loginwidget_password']")).sendKeys("Qwerty12345678");
        driver.findElement(By.xpath(".//button[@ng-click='loginForm.loginUser($event)']")).click();

        //Тест №2
        driver.findElement(By.xpath("//*[@id=\"js\"]/body/div[2]/header/div/nav[2]/ul/li[4]/a")).click();
        driver.findElement(By.xpath(".//textarea[@placeholder='Придумайте заголовок']")).sendKeys("Факты");
        driver.findElement(By.xpath(".//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']")).sendKeys("Около 13500 домов было уничтожено при великом и знаменитом пожаре в Лондоне в 1666 году.");
        driver.findElement(By.xpath(".//button/span[(text()='Настроить и опубликовать')]")).click();
        driver.findElement(By.xpath(".//footer/div/button")).click();

        //Тест №3
        driver.findElement(By.xpath("//*[@id='comments']/div/div[2]/div[1]/a")).click();
        driver.findElement(By.xpath(".//div[@role='textbox']")).sendKeys("С данным утверждением можно поспорить");

        try {
            WebElement webElementAdd = driver.findElement(By.xpath(".//*[@id='comment_submit']"));
            Thread.sleep(2000);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.scrollBy(0,250)");
            webElementAdd.click();
        } catch (NoSuchElementException e){
            System.out.println(e.getSupportUrl());
        }

        //Тест №4

        try {
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.scrollBy(0,-250)");
            Thread.sleep(2000);
            WebElement webElementSearch = driver.findElement(By.xpath(".//ul[@class='s-do']/li/div/form/button"));
            webElementSearch.click();
            driver.findElement(By.xpath(".//ul[@class='s-do']/li/div/form/div/div/input")).sendKeys("Факты");
            webElementSearch.click();
        } catch (NoSuchElementException e){
            System.out.println(e.getSupportUrl());
        }

    }



}