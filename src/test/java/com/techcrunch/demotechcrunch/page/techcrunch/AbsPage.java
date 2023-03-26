package com.techcrunch.demotechcrunch.page.techcrunch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AbsPage extends Base{

    @FindBy(xpath = "aaaa")
    private WebElement el;

    @FindBy(xpath = "aa")
    private WebElement testNAme;


    public AbsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {

        return el.isDisplayed();
    }
}
