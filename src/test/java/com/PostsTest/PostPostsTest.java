package com.PostsTest;

import Base.BasePosts;
import Dto.Post;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import static Helpers.Helper.GetRandomUUID;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.core.IsEqual.equalTo;


@Epic("Post")
@Feature("Create post and Read collection post")
public class PostPostsTest extends BasePosts {

    @Test
    public void CreatePostsTest(){
        Post post = new Post();
        post.setTitle(GetRandomUUID());
        post.setBody(GetRandomUUID());
        post.setUserId(5);

        given().
                contentType(JSON).
                body(post).
        when().
                post().
        then().
                statusCode(201).
                body("title", equalTo(post.getTitle())).
                body("body", equalTo(post.getBody())).
                body("userId", equalTo(post.getUserId()));
    }
}
