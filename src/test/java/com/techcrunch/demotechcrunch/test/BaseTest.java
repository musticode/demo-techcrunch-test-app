package com.techcrunch.demotechcrunch.test;



import com.techcrunch.demotechcrunch.driver.DriverManager;
import com.techcrunch.demotechcrunch.page.techcrunch.ArticleDetailsPage;
import com.techcrunch.demotechcrunch.page.techcrunch.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest extends DriverManager {

    MainPage mainPage2;
    ArticleDetailsPage articleDetailsPage2;


    @BeforeTest
    @Parameters(value = {"browserName"} )
    public void initializeBrowser(@Optional String browserName){

        // to run test class in ide
        if (browserName == null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        }else{

            setDriver(browserName);

        }

        mainPage2 = new MainPage(driver);
        articleDetailsPage2 = new ArticleDetailsPage(driver);




    }


    @AfterTest
    public void quitDriver(){
        terminateBrowser();
    }

}
