import Dto.Post;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

@Epic("Post")
@Feature("Create post and Read collection post")
public class PostTest extends BaseRestClientSetting{


    @BeforeClass
    public void SetUpClass(){
        RestAssured.basePath = "/posts";
    }

    @Test
    public void ReadCollectionOnePostsTest(){
        Post[] posts= get().
                as(Post[].class);
        for (Post post : posts) {
            System.out.println(post.toString());
        }

    }

    @Test
    public void ReadCollectionTwoPostsTest(){
        Post[] posts= get().
                as(Post[].class);
        for (Post post : posts) {
            System.out.println(post.toString());
        }

    }

    @Test
    public void CreatePostsTest(){
        Post post = new Post();
        post.setTitle("Test Title");
        post.setAuthor("Test Author");

        given().
                contentType(ContentType.JSON).
                body(post).
        when().
                post().
        then().
                statusCode(201);
    }
}
