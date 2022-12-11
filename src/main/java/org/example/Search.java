package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Search extends AbstractPage {
    @FindBy(xpath = ".//ul[@class='s-do']/li/div/form/button")
    private WebElement submitSearch;

    @FindBy(xpath = ".//ul[@class='s-do']/li/div/form/div/div/input")
    private WebElement inputSearch;

    public Search(WebDriver driver) {
        super(driver);
    }

    public void searchArticle(String searchWho) {
        Actions search = new Actions(getDriver());
        search.click(this.submitSearch)
                .pause(1000l)
                .sendKeys(this.inputSearch, searchWho)
                .pause(1000l)
                .click(this.submitSearch)
                .build()
                .perform();
    }
}
