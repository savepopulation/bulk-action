package com.raqun.bulkaction;

/**
 * Created by tyln on 15/04/2017.
 */

public class Constants {
    private Constants() {
        // Empty Private Constructor
    }

    // RES
    public static final int NO_RES = 0;

    // API
    public static final String BASE_URL = "https://api.instagram.com/v1/";

    public static final String CLIENT_ID = "your_client_id";
    //public static final String CLIENT_SECRET = "your_client_secret";

    public static final String REDIRECT_URI = "http://www.raqun.com";
    public static final String RESPONSE_TYPE = "token";
    public static final String SCOPE = "public_content";


    public static final String LOGIN_URL = "https://www.instagram.com/oauth/authorize/?client_id=" +
            CLIENT_ID + "&redirect_uri=" + REDIRECT_URI +
            "&response_type=" + RESPONSE_TYPE + "&scope=" + SCOPE;

}
