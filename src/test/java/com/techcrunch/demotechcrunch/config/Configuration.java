package com.techcrunch.demotechcrunch.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:general.properties"})
public interface Configuration extends Config {



    @Key("url.stg")
    String stagingUrl();


    @Key("url.prod")
    String prodUrl();





}
