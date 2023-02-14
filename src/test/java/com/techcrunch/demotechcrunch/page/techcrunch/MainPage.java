package com.techcrunch.demotechcrunch.page.techcrunch;

import com.techcrunch.demotechcrunch.page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {

    private static String TECH_CRUNCH_MAIN_URL = "https://techcrunch.com/";

    @FindBy(xpath = "//div[@class='content']//article")
    private List<WebElement> articleList;

    @FindBy(xpath = "//span[@class='river-byline__authors']")
    private List<WebElement> authorList;


    @FindBy(xpath = "//img")
    private List<WebElement> imageList;






    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void getMainPage(){
        getPage(TECH_CRUNCH_MAIN_URL);
    }


    public void printArticleAuthors(){

        System.out.println("Size of list: " + authorList.size());


        for (int i = 0; i < authorList.size(); i++) {
            System.out.println("Author: " + getText(authorList.get(i)));
        }

    }

    @Step("Checking for authors")
    public boolean authorIsNotNull(){

        for (int i = 0; i < articleList.size(); i++) {
            if (getText(articleList.get(i)).isEmpty()){
                return false;
            }
        }

        return true;
    }

    @Step("Checking for images")
    public boolean imageVerify(){

        for (int i = 0; i < articleList.size(); i++) {
            if (!isElementDisplayed(imageList.get(i))){
                return false;
            }
        }


        return true;
    }

    @Step("Navigating Article Details page via clicking an article")
    public void getArticleDetailsPage(){
        click(articleList.get(0));
    }

}
