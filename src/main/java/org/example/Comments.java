package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Comments extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"js\"]/body/div[2]/header/div[1]/div/a[1]/span")
    private WebElement sub;

    @FindBy(xpath = ".//body/div[2]/div[3]/div[1]/section[1]/div/div/div[1]/div[1]/div/div/article/a")
    private WebElement submitArticle;

    @FindBy(xpath = ".//*[@id='comments']/div/div[2]/div[1]/a")
    private WebElement submitComments;

    @FindBy(xpath = ".//div[@role='textbox']")
    private WebElement textboxCheck;

    @FindBy(id = "comment_submit")
    private WebElement submitCommentsTwo;


    public Comments(WebDriver driver) {
        super(driver);
    }

    public void leaveComment(String com){
        Actions comment = new Actions(getDriver());
        comment.click(this.sub)
                .click(this.submitArticle)
                .click(this.submitComments)
                .sendKeys(this.textboxCheck, com)
                .click(this.submitCommentsTwo)
                .build()
                .perform();;
    }
}
