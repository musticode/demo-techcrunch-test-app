package com.techcrunch.demotechcrunch.test.techcrunch;

import com.techcrunch.demotechcrunch.listener.TestListener;
import com.techcrunch.demotechcrunch.page.techcrunch.ArticleDetailsPage;
import com.techcrunch.demotechcrunch.page.techcrunch.MainPage;
import com.techcrunch.demotechcrunch.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class NewsTest extends BaseTest {


    MainPage mainPage;
    ArticleDetailsPage articleDetailsPage;

    @Test
    public void latestNewsTest() throws InterruptedException {
        mainPage = new MainPage(driver);
        mainPage.getMainPage();

        mainPage.goToArticleDetail();

        Assert.assertEquals(
                mainPage.authorIsNotNull(),
                true,
                "All articles have not author");


        Assert.assertEquals(mainPage.imageVerify(),
                true,
                "All articles have not image");
    }



    @Test
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


        articleDetailsPage.getaaaa();

    }




}
