package CommentRest;

import Base.BaseComments;
import Dto.Comment;
import org.testng.annotations.Test;

import static Helpers.Helper.GetRandomUUID;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;

public class PutComment extends BaseComments {

    @Test
    public void PutCommentTest(){
        Comment comment = new Comment();
        comment.setBody(GetRandomUUID());
        comment.setPostId(COMMENT_POST_ID);

        given().
                contentType(JSON).
                body(comment).
        when().
                put("/{id}", POST_ID).
        then().
                statusCode(200).
                body("body", equalTo(comment.getBody())).
                body("postId", equalTo(comment.getPostId()));
    }

    @Test
    public void PutAllCommentTest(){
        int NEW_COMMENT_POST_ID = 7;

        Comment comment = new Comment();
        int size = get().as(Comment[].class).length;

        for (int i = 1; i <= size; i++){
            comment.setBody(GetRandomUUID());
            comment.setPostId(NEW_COMMENT_POST_ID);

            given().
                    contentType(JSON).
                    body(comment).
            when().
                    put("/{id}", i).
            then().
                    statusCode(200).
                    body("body", equalTo(comment.getBody())).
                    body("postId", equalTo(comment.getPostId()));
        }
    }
}
