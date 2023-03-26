package com.techcrunch.demotechcrunch.driverfactory.factory;

import com.techcrunch.demotechcrunch.driverfactory.drivermanager.ChromeDriverManager;
import com.techcrunch.demotechcrunch.driverfactory.drivermanager.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    public WebDriver createInstance(String browser){

        WebDriver driver;

        BrowserList browserType = BrowserList.valueOf(browser.toUpperCase());

        switch (browserType){

            case CHROME:
                driver = new ChromeDriverManager().createDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriverManager().createDriver();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + browserType);
        }

        return driver;

    }


}
