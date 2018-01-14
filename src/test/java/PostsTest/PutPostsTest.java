package PostsTest;

import Base.BasePosts;
import Dto.Post;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import static Helpers.Helper.GetRandomUUID;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;

@Epic("Post")
@Feature("Put post test")
public class PutPostsTest extends BasePosts {

    @Test
    public void EditPostsUsingPutTest(){
        Post post = new Post();
        post.setTitle(GetRandomUUID());
        post.setAuthor(GetRandomUUID());

        given().
                contentType(JSON).
                body(post).
        when().
                put("/{id}", POST_ID).
        then().
                statusCode(200).
                body("title", equalTo(post.getTitle())).
                body("author", equalTo(post.getAuthor()));
    }

    @Test
    public void EditAllPostsUsingPutTest(){
        Post post = new Post();
        int size = get().as(Post[].class).length;

        for (int i = 1; i <= size; i++){
            post.setAuthor(GetRandomUUID());
            post.setTitle(GetRandomUUID());

            given().
                    contentType(JSON).
                    body(post).
            when().
                    put("/{id}", i).
            then().
                    statusCode(200).
                    body("title", equalTo(post.getTitle())).
                    body("author", equalTo(post.getAuthor()));
        }
    }
}
