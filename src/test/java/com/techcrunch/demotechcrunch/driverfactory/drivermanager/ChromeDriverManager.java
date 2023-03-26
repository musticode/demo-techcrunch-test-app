package com.techcrunch.demotechcrunch.driverfactory.drivermanager;

import com.techcrunch.demotechcrunch.driverfactory.factory.Factory;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager implements Factory {

    @Override
    public WebDriver createDriver() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        return new ChromeDriver();
    }
}
