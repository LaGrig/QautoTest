package org.apiActions;

import okhttp3.Request;
import okhttp3.Response;
import org.testng.Assert;

import java.io.IOException;

public class UserDataPage extends GlobalSettings{

    public void getUserProfileData() throws IOException {
        final String getUserProfileEndpoint = "/users/profile";
        String url = baseUrl + getUserProfileEndpoint;

        Request request = new Request.Builder()
                .url(url)
                .header("accept", "*/*")
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();
        Assert.assertEquals(responseBody,"{\n" +
                "  \"status\": \"ok\",\n" +
                "  \"data\": {\n" +
                "    \"userId\": 1,\n" +
                "    \"photoFilename\": \"default-user.png\",\n" +
                "    \"name\": \"John\",\n" +
                "    \"lastName\": \"Dou\"\n" +
                "  }\n" +
                "}");
    }
}
