package com.techcrunch.demotechcrunch.page.techcrunch;

import com.techcrunch.demotechcrunch.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
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


    public void goToArticleDetail() throws InterruptedException {
        scrollDownByValue(600);
        scrollDownByValue(600);
        scrollDownByValue(600);

        Thread.sleep(2000);
        //click(articleList.get(0));
        System.out.println("size of list: " + articleList.size());

        for (int i = 0; i < articleList.size(); i++) {
            //System.out.println(articleList.get(i).getText());
            System.out.println("Author: " + authorList.get(i).getText());
        }

        //click(articleList.get(0));
        //Thread.sleep(20000);
    }

    public boolean authorIsNotNull(){

        for (int i = 0; i < articleList.size(); i++) {
            if (authorList.get(i).getText().isEmpty()){
                return false;
            }
        }

        return true;
    }

    public boolean imageVerify(){

        for (int i = 0; i < articleList.size(); i++){
            if (!imageList.get(i).isEnabled()){
                return false;
            }
        }

        return true;
    }

    public void getArticleDetailsPage(){
        click(articleList.get(0));
    }

}
