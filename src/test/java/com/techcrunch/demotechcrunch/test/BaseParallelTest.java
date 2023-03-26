package com.techcrunch.demotechcrunch.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class BaseParallelTest {

    static ThreadLocal<RemoteWebDriver> remoteWebDriverThreadLocal = new ThreadLocal<>();
    static ThreadLocal<WebDriver> localDriver = new ThreadLocal<>();

    @BeforeClass
    @Parameters(value={"browserName"})
    public void setUp(@Optional String browserName){

        if (browserName != null){
            WebDriverManager.chromedriver().setup();
            localDriver.set(new ChromeDriver());
        }


    }

    public WebDriver getDriver(){
        return localDriver.get();
    }


    @AfterClass
    public void terminate(){
        getDriver().quit();
        localDriver.remove();
    }





}
