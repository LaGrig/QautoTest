package org.apiActions;

import okhttp3.OkHttpClient;


public class GlobalSettings {

    String baseUrl = "https://qauto.forstudy.space/api";
    OkHttpClient client = new OkHttpClient.Builder().build();

}
