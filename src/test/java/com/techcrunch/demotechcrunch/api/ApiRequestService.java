package com.techcrunch.demotechcrunch.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ApiRequestService {

    private static ApiRequestService apiRequestService;
    private ApiRequestService(){

    }
    public static ApiRequestService getInstance(){

        if (apiRequestService == null){
            apiRequestService = new ApiRequestService();
        }

        return apiRequestService;
    }


    public int sendRequestToElementLinks(String url) {

        HttpURLConnection connection = null;
        int responseCode;

        try {

            connection = (HttpURLConnection) (new URL(url).openConnection());
            connection.setRequestMethod("GET");


            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");

            connection.connect();
            responseCode = connection.getResponseCode();

            return responseCode;

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
