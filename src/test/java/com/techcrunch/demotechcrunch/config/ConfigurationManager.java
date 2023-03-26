package com.techcrunch.demotechcrunch.config;

import org.aeonbits.owner.ConfigCache;

public class ConfigurationManager {
    private ConfigurationManager(){
    }

    public static Configuration configurationManager(){
        return ConfigCache.getOrCreate(Configuration.class);
    }


}
