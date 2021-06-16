package com.ilCarro.qa14.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class APITest {

    String baseURL = "https://java-3-ilcarro-team-b.herokuapp.com";

    @Test
    public void loginRegisteredUserPositiveTest() throws IOException {
        String response = getAuthorizationUser(baseURL + "/user/login", "Authorization", "dHNzQGxsLmNvbTpUc3NsbDEyMzQ1");

       // System.out.println(response);

        JsonElement parsed = new JsonParser().parse(response);
        JsonElement name = parsed.getAsJsonObject().get("first_name");
        Assert.assertEquals(name.toString(),"\"TesterL\"");

        JsonElement regDate = parsed.getAsJsonObject().get("registration_date");
        Assert.assertEquals(regDate.toString(),"\"2021-05-26\"");


    }

    public String getAuthorizationUser(String controller, String key, String value) throws IOException {
        return Request.Get(controller)
                .addHeader(key, value)
//                .addHeader("Authorization", "c3NAbGxsLmNvbTpzTDEyMzQ1Njc=")
                .execute().returnContent().asString();
    }

   @Test
   public void loginRegisteredUserNegativeTest() throws IOException {

        int statusCode = Request.Get(baseURL + "/user/login")
                .addHeader("Authorization", "1dHNzQGxsLmNvbTpUc3NsbDEyMzQ1")
                .execute().returnResponse().getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode,400);
   }

   @Test
    public void postNewUserRegistrationTest() throws IOException {
        String response = Request.Post(baseURL + "/registration")
                .addHeader("Authorization", "dHdAZ21haWwuY29tOlNsMTIzNDU2NA==")
                .bodyString("{\n" +
                        "  \"first_name\": \"Test\",\n" +
                        "  \"second_name\": \"Tester\"\n" +
                        "}", ContentType.APPLICATION_JSON)
                .execute().returnContent().asString();
       System.out.println(response);
   }

   @Test
    public void deleteUserTest() throws IOException {

       String response = deleteDataUser("Authorization", "dHdAZ21haWwuY29tOlNsMTIzNDU2NA==");
       System.out.println(response);
   }

    @Test
    public void deleteUserNegativeTest() throws IOException {

         deleteDataUserStatusCode("Authorization", "dHdAZ21haWwuY29tOlNsMTIzNDU2NA==");

    }

    private String deleteDataUser(String key, String value) throws IOException {
        String response = Request.Delete(baseURL + "/user")
                .addHeader(key, value)
                .execute().returnContent().asString();
        return response;
    }

    private int deleteDataUserStatusCode(String key, String value) throws IOException {
        int statusCode = Request.Delete(baseURL + "/user")
                .addHeader(key, value)
                .execute().returnResponse().getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode,404);
        return statusCode;
    }
}
