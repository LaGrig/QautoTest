package org.apiActions;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CarsActions extends GlobalSettings{

    public void getAllCarsBrands() throws IOException {
        final String getUserCarsBrandsEndpoint = "/cars/brands";
        String url = baseUrl + getUserCarsBrandsEndpoint;

        Request request = new Request.Builder()
                .url(url)
                .header("accept", "*/*")
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();
        Assert.assertEquals(response.body().string(),"{\"status\":\"ok\",\"data\":" +
                "[{\"id\":1,\"title\":\"Audi\",\"logoFilename\":\"audi.png\"}," +
                "{\"id\":2,\"title\":\"BMW\",\"logoFilename\":\"bmw.png\"}," +
                "{\"id\":3,\"title\":\"Ford\",\"logoFilename\":\"ford.png\"}," +
                "{\"id\":4,\"title\":\"Porsche\",\"logoFilename\":\"porsche.png\"}," +
                "{\"id\":5,\"title\":\"Fiat\",\"logoFilename\":\"fiat.png\"}]}");
    }

    public void addBrandNewCar2() throws IOException {
        final String addBrandNewCarEndpoint = "/cars";
        String url = baseUrl + addBrandNewCarEndpoint;

        String addCar =
                "{\n" +
                        "  \"carBrandId\": 1,\n" +
                        "  \"carModelId\": 1,\n" +
                        "  \"mileage\": 122\n" +
                        "}";

        RequestBody body = RequestBody.create(addCar, MediaType.get("application/json"));
        Request request = new Request.Builder()
                .url(url)
                .header("accept", "*/*")
                .method("POST", body)
                .build();
        Response response = client.newCall(request).execute();
        assert response.body() != null;
        String responseBody = response.body().string();
        Assert.assertTrue(responseBody.contains("\"status\": \"ok\""));
        Assert.assertTrue(responseBody.contains("\"carBrandId\": 1"));
        Assert.assertTrue(responseBody.contains("\"carModelId\": 1"));
    }

    public int addBrandNewCar() throws IOException {
        final String addBrandNewCarEndpoint = "/cars";
        String url = baseUrl + addBrandNewCarEndpoint;

        String addCar =
                "{\n" +
                        "  \"carBrandId\": 1,\n" +
                        "  \"carModelId\": 1,\n" +
                        "  \"mileage\": 122\n" +
                        "}";

        RequestBody body = RequestBody.create(addCar, MediaType.get("application/json"));
        Request request = new Request.Builder()
                .url(url)
                .header("accept", "*/*")
                .method("POST", body)
                .build();
        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();

        System.out.println("Response Body: " + responseBody);

        JSONObject jsonObject = new JSONObject(responseBody);
        if(jsonObject.has("data")) {
            System.out.println(jsonObject.getJSONObject("data").getInt("id"));
            return jsonObject.getJSONObject("data").getInt("id");
        } else {
            throw new JSONException("Data field not found in the response");
        }
    }

    public void deleteCar() throws IOException {
        int id = addBrandNewCar();
        final String deleteCarEndpoint = "/cars/"+id;
        String url = baseUrl + deleteCarEndpoint;

        Request request = new Request.Builder()
                .url(url)
                .header("accept", "*/*")
                .method("DELETE", null)
                .build();
        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();
        Assert.assertEquals(responseBody,"{\"status\":\"ok\"}");

    }
}
