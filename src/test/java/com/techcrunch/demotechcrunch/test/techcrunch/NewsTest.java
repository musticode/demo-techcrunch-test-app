package com.techcrunch.demotechcrunch.test.techcrunch;

import com.techcrunch.demotechcrunch.listener.TestListener;
import com.techcrunch.demotechcrunch.page.techcrunch.ArticleDetailsPage;
import com.techcrunch.demotechcrunch.page.techcrunch.MainPage;
import com.techcrunch.demotechcrunch.test.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class NewsTest extends BaseTest {


    MainPage mainPage;
    ArticleDetailsPage articleDetailsPage;



    @Test(priority = 0)
    @Description("Checking latest news: Each news has an author - Each news has an image")
    public void latestNewsTest(){
        mainPage = new MainPage(driver);
        mainPage.getMainPage();

        mainPage.printArticleAuthors();

        Assert.assertEquals(
                mainPage.authorIsNotNull(),
                true,
                "All articles have not author");


        Assert.assertEquals(mainPage.imageVerify(),
                true,
                "All articles have not image");
    }



    @Test(priority = 1)
    @Description("Checking article details: Browser title is the same with the news title - Links within the news content")
    public void checkArticleDetailsTest(){

        mainPage = new MainPage(driver);
        articleDetailsPage = new ArticleDetailsPage(driver);

        mainPage.getMainPage();
        mainPage.getArticleDetailsPage();

        Assert.assertEquals(
                articleDetailsPage.getArticleDetailsPageTitle(),
                articleDetailsPage.getArticleTitleText(),
                "Article's title is not matching with page title");


        Assert.assertEquals(
                articleDetailsPage.linksValid(),
                true,
                "lin+ks are not valid");


        articleDetailsPage.printLinks();

    }




}
