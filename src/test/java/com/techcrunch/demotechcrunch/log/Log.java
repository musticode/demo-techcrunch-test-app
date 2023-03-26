package com.techcrunch.demotechcrunch.log;

import org.testng.log4testng.Logger;

public class Log {


    private static Logger Log = Logger.getLogger(Log.class);//
    public static void info(String message){
        Log.info(message);
    }






}
