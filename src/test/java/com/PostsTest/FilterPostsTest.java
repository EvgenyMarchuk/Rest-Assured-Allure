package com.PostsTest;

import Base.BasePosts;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.hasItems;

public class FilterPostsTest extends BasePosts {

    @Test
    public void GetPostsUsingFilterIdTest(){
        int firstId = 1;
        int lastId = 5;

        given().
                contentType(JSON).
                param("id", firstId).
                param("id", lastId).
        when().
                get().
        then().
                statusCode(200).
                body("id", hasItems(firstId, lastId));


    }

}
