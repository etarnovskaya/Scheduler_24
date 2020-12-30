package com.sch.tests.tests;



import org.apache.http.HttpHost;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
import org.testng.annotations.Test;

import java.io.IOException;

public class APIUserRegistrationTests {


    @Test
    public void createUserTest() throws IOException {
        Response response = Request.Post("super-scheduler-app.herokuapp.com/api/login")
                .addHeader("Content-Type", "application/json")
                .bodyString("{\"email\": \"qa24Ro@gmail.com\", \"password\": \"string\"}", ContentType.APPLICATION_JSON).execute();
        System.out.println(response);

    }

}
