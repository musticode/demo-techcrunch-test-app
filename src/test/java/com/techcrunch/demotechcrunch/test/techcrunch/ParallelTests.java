package com.techcrunch.demotechcrunch.test.techcrunch;

import com.techcrunch.demotechcrunch.log.Log;
import com.techcrunch.demotechcrunch.page.techcrunch.AbsPage;
import com.techcrunch.demotechcrunch.page.techcrunch.Base;
import com.techcrunch.demotechcrunch.test.BaseParallelTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParallelTests extends BaseParallelTest {

    Base absPage;
    Base abs2;


    @Test
    public void test() throws InterruptedException {
        absPage = new AbsPage(getDriver());
        abs2 = new AbsPage(getDriver());


        Thread.sleep(3000);
        abs2.getPage("https://www.youtube.com/");
//        Assert.assertEquals("aaaa", false, "aasadsda");
        Log.info("ccascxacac");
    }

    @Test
    public void test2() throws InterruptedException {
        absPage = new AbsPage(getDriver());
        abs2 = new AbsPage(getDriver());

        Thread.sleep(3000);
        abs2.getPage("https://www.youtube.com/");
//        Assert.assertEquals("aaaa", false, "aasadsda");
        Log.info("ccascxacac");
    }



}