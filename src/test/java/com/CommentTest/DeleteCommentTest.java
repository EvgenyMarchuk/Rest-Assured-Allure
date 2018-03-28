package com.CommentTest;

import Base.BaseComments;
import Dto.Comment;
import org.testng.annotations.Test;

import static Helpers.Helper.getLast;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class DeleteCommentTest extends BaseComments {

    @Test
    public void DeleteTest(){
        int id = getLast(get().as(Comment[].class)).getId();

        given().
                contentType(JSON).
                when().
         delete("/{id}", id).
                then().
                statusCode(200);
    }
}
