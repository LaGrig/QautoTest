package org.apiActions;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import java.io.IOException;

public class Auth extends GlobalSettings {

    String name = RandomStringUtils.randomAlphabetic(8).toLowerCase();
    String surname = RandomStringUtils.randomAlphabetic(8).toLowerCase();

    public void registerNewUser() throws IOException {
        final String endpointName = "/auth/signup";
        String url = baseUrl + endpointName;

        String addUser =
                "{\n" +
                        "\"name\": \"" + name + "\",\n" +
                        "\"lastName\": \"" + surname + "\",\n" +
                        "\"email\": \"" + name + "@" + surname + ".com\",\n" +
                        "\"password\": \"Qwerty12345\",\n" +
                        "\"repeatPassword\": \"Qwerty12345\"\n" +
                        "}";

        RequestBody body = RequestBody.create(addUser, MediaType.get("application/json"));
        Request request = new Request.Builder()
                .url(url)
                .header("accept", "*/*")
                .method("POST", body)
                .build();
        Response response = client.newCall(request).execute();
        assert response.body() != null;
        System.out.println(response.body().string());
    }

    public void loginNewUser() throws IOException {
        final String endpointName = "/auth/signin";
        String url = baseUrl + endpointName;

        String addUser =
                "{\n" +
                        "\"email\": \"" + name + "@" + surname + ".com\",\n" +
                        "\"password\": \"Qwerty12345\",\n" +
                        "\"remember\": \"false\"\n" +
                        "}";

        RequestBody body = RequestBody.create(addUser, MediaType.get("application/json"));
        Request request = new Request.Builder()
                .url(url)
                .header("accept", "*/*")
                .method("POST", body)
                .build();
        Response response = client.newCall(request).execute();
        assert response.body() != null;
        System.out.println(response.body().string());
    }

    public void logOutNewUser() throws IOException {

        final String endpointName = "/auth/logout";
        String url = baseUrl + endpointName;

        Request request = new Request.Builder()
                .url(url)
                .header("accept", "*/*")
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();
        Assert.assertEquals(responseBody,"{\"status\":\"ok\"}");
    }

    public void loginAsAlreadyRegisteredUser() throws IOException {
        final String endpointName = "/auth/signin";
        String url = baseUrl + endpointName;

        String addUser =
                "{\n" +
                        "\"email\": \"JorgeDou@test.com\",\n" +
                        "\"password\": \"Qwerty12345\",\n" +
                        "\"remember\": \"false\"\n" +
                        "}";

        RequestBody body = RequestBody.create(addUser, MediaType.get("application/json"));
        Request request = new Request.Builder()
                .url(url)
                .header("accept", "*/*")
                .method("POST", body)
                .build();
        Response response = client.newCall(request).execute();
        assert response.body() != null;
        System.out.println(response.body().string());
    }
}
