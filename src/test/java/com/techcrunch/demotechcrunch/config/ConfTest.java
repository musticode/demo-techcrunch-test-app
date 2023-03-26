package com.techcrunch.demotechcrunch.config;

public class ConfTest {
    public static void main(String[] args) {

        String configurationUrl = ConfigurationManager.configurationManager().stagingUrl();

        System.out.println(configurationUrl);
        System.out.println(ConfigurationManager.configurationManager().stagingUrl());


        System.out.println(ConfigurationManager.configurationManager().prodUrl());

    }

}
