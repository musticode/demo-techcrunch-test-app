package com.techcrunch.demotechcrunch.listener;



import com.techcrunch.demotechcrunch.driver.DriverManager;
import io.qameta.allure.Attachment;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends DriverManager implements ITestListener {

    /**
     * Test Listener methods
     *
     */

    private static Logger logger = Logger.getLogger(TestListener.class);


    @Override
    public void onTestStart(ITestResult result) {

        logger.info("Test Started: "+ result.getName() );
//        System.out.println("Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Success: "+ result.getName());
//        System.out.println("Success: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.warn("Failure: "+ result.getName());
        logger.info(saveTextLog(result.getName()));
        saveTextLog(result.getName());
//        saveScreenshotPNG(driver);

//        System.out.println("Failure on test: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info("Test skipped: "+ result.getName());
//        System.out.println("Test skipped: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("On start: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("On finish: " + context.getName());
    }


    /**
     * Allure Attachment annotations
     * @param driver
     *
     */
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }


    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

}
