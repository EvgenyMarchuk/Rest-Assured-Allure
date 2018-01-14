package CommentTest;

import Base.BaseComments;
import Dto.Comment;
import org.testng.annotations.Test;

import static Helpers.Helper.GetRandomUUID;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class PostCommentTest extends BaseComments{

    @Test
    public void CreateCommentTest(){
        Comment comment = new Comment();
        comment.setBody(GetRandomUUID());
        comment.setPostId(COMMENT_POST_ID);

        given().
                contentType(JSON).
                body(comment).
        when().
                post().
        then().
                statusCode(201).
                body("body", equalTo(comment.getBody())).
                body("postId", is(comment.getPostId()));
    }
}
