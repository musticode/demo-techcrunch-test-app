package com.techcrunch.demotechcrunch.page.techcrunch;

import com.techcrunch.demotechcrunch.exception.NoElementException;
import com.techcrunch.demotechcrunch.exception.TimeOutException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base implements Page {

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

        try {
            element.click();
        }catch (NoElementException e){
            System.out.println(e.getMessage());
        }
        //element.click();
    }


    public void setText(WebElement element, String text){
        waitFor(element);

        try {
            element.clear();
            element.sendKeys(text);
        }catch (NoElementException e ){
            System.out.println(e.getMessage());
        }

    }

    public void getPage(String url){
        driver.get(url);
    }


    private void waitFor(WebElement element){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (TimeOutException e){
            e.getMessage();
        }

    }



    @Override
    public boolean isAt() {
        return false;
    }
}
