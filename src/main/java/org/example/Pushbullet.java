package org.example;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Pushbullet {
    public static void main(String[] args) {
        String apiKey = "o.eJwOPW2bHIIGlEAWVnQpNAyht1XPPBX9";
        String title = "Приветdfcgh";
        String message = "Привет, это я))    Hello, mikee";

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost("https://api.pushbullet.com/v2/pushes");
            httpPost.setHeader("Access-Token", apiKey);
            httpPost.setHeader("Content-Type", "application/json");

            String json = "{"
                    + "\"type\": \"note\","
                    + "\"title\": \"" + title + "\","
                    + "\"body\": \"" + message + "\""
                    + "}";

            httpPost.setEntity(new StringEntity(json));

            HttpResponse response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();

            System.out.println("Response code: " + statusCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
