package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
public class PostArticle extends AbstractPage{
    @FindBy(xpath = "//*[@id='home']/div[3]/header/div[1]/nav[2]/ul/li[4]/a/span[1]")
    private WebElement submitArticle;

    @FindBy(xpath = ".//textarea[@placeholder='Придумайте заголовок'")
    private WebElement header;

    @FindBy(xpath = ".//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']")
    private WebElement textarea;

    @FindBy(xpath = ".//button/span[(text()='Настроить и опубликовать')]")
    private WebElement submitPost;

    @FindBy(xpath = ".//footer/div/button")
    private WebElement submitPostTwo;

    public PostArticle(WebDriver driver) {
        super(driver);
    }

    public void Post(String head, String text){
        Actions post = new Actions(getDriver());
        post.pause(2000l).click(this.submitArticle)
                .sendKeys(this.header, head)
                .sendKeys(this.textarea, text)
                .click(this.submitPost)
                .click(this.submitPostTwo)
                .build()
                .perform();;
    }
}
