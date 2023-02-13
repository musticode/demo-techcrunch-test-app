package com.techcrunch.demotechcrunch.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    JavascriptExecutor js;
    private final static int TIME_OUT_DURATION = 20;
    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT_DURATION));
        js = (JavascriptExecutor)driver;
        PageFactory.initElements(driver, this);
    }

    private void waitFor(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
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


    public List<WebElement> findElements(By locator){

        List<WebElement> elementList = driver.findElements(locator);

        return elementList;
    }

    public boolean isElementDisplayed(WebElement element){
        waitFor(element);
        return element.isDisplayed();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public void getPage(String url){
        driver.get(url);
    }

    public String getText(WebElement element){
        waitFor(element);
        return element.getText();
    }

    public void scrollDown(){
        js.executeScript("window.scrollBy(0,600)");
    }

    public void scrollDownByValue(int value){
        String script = "window.scrollBy(0,"+ value + ")";
        js.executeScript(script);
    }





}
