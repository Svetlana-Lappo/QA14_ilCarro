package com.ilCarro.qa14.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.google.gson.JsonObject;

public class RestAssuredTest {

    @Test
    public void postNewUserRegistrationTest(){

        RequestSpecification httpRequest = io.restassured.RestAssured.given();

        Response response = httpRequest
                .given().contentType(ContentType.JSON)
                .given().header("Authorization", "c3dAZ21haWwuY29tOlR3MTIzNDU2Nzg=")
                .given().body("{\n" +
                        "  \"first_name\": \"Test\",\n" +
                        "  \"second_name\": \"Test\"\n" +
                        "}")
                .when().post("https://java-3-ilcarro-team-b.herokuapp.com/registration");

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        //old variant
//        JsonElement parsed = new JsonParser().parse(responseBody);
//        String fName = parsed.getAsJsonObject().get("first_name").toString();

        JsonObject fName = JsonParser.parseString(responseBody).getAsJsonObject();
        JsonElement name = fName.get("first_name");
        System.out.println(name);

        Assert.assertEquals(statusCode,200,"Bug:status code is coming different");

    }

    @Test

    public void deleteUserTest(){

        RequestSpecification httpRequest = io.restassured.RestAssured.given();
        Response response = httpRequest
                .given().header("Authorization","dHczQGdtYWlsLmNvbTpTbDEyMzQ1NjQ=")
                .request().delete("https://java-3-ilcarro-team-b.herokuapp.com/user");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200,"Bug: status code is coming different");

    }
}
