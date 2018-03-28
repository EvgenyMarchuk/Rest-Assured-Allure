package com.UserTest;

import Base.BaseUser;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;

public class UserEmbedTest extends BaseUser {


    @Test
    public void UserEmbedToDosTest(){
        int userId = 2;
        given().
                contentType(JSON).
                param("_embed", "todos").
        when().
                get("/{userId}", userId).
        then().
                statusCode(200).
                body("todos.userId", everyItem(is(userId))).
                body("todos.id", everyItem(greaterThanOrEqualTo(1)));
    }
}
