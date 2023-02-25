package com.techcrunch.demotechcrunch.page.techcrunch;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class Base implements Page {

    private WebDriver driver;
    private WebDriverWait wait;

    JavascriptExecutor js;
    private final static int TIME_OUT_DURATION = 20;
    public Base(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT_DURATION));
        js = (JavascriptExecutor)driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element){
        waitFor(element);
        element.click();
    }

    public void setText(WebElement element, String text){
        waitFor(element);
        element.clear();
        element.sendKeys(text);
    }

    public void getPage(String url){
        driver.get(url);
    }


    private void waitFor(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


}
