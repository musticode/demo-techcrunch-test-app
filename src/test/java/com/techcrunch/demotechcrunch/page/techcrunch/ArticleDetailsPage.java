package com.techcrunch.demotechcrunch.page.techcrunch;

import com.techcrunch.demotechcrunch.api.ApiRequestService;
import com.techcrunch.demotechcrunch.page.BasePage;
import io.opentelemetry.api.trace.StatusCode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;

public class ArticleDetailsPage extends BasePage {

    @FindBy(xpath = "//h1[@class='article__title']")
    private WebElement articleTitleElement;

    @FindBy(xpath = "//article[@class='post-block post-block--image post-block--unread']")
    private List<WebElement> articleLinksList;

    @FindBy(xpath = "//a[@class='post-block__title__link']")
    private List<WebElement> articleLinksHrefList;



    private String pageTitleSuffix = " | TechCrunch";

    public ArticleDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void getaaaa(){
        for (int i = 0; i < articleLinksHrefList.size(); i++) {

            System.out.println(articleLinksHrefList.get(i).getAttribute("href"));
        }
    }


    public boolean linksValid(){

        Iterator<WebElement> it = articleLinksHrefList.iterator();

        System.out.println("Size of articlet list link: "+ articleLinksHrefList.size());

        while(it.hasNext()) {

            String articleLink = it.next().getAttribute("href");

            System.out.println(articleLink);

            if (articleLink == null || articleLink.isEmpty()) {
                System.out.println("Empty or null url");
                continue;
            }

            int responseCode = ApiRequestService.getInstance().sendRequestToElementLinks(articleLink);

            //Assert.assertEquals(responseCode, 200, "Broken");
            if (responseCode > 200){
                return false;
            }
        }

        return true;
    }


    public String getArticleDetailsPageTitle(){
        return getPageTitle();
    }

    public String getArticleTitleText(){
        return getText(articleTitleElement).concat(pageTitleSuffix);
    }
}
