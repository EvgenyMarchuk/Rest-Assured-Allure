import Base.BasePost;
import Dto.Post;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import static Helpers.Helper.*;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.core.IsEqual.equalTo;


@Epic("Post")
@Feature("Create post and Read collection post")
public class PostTest extends BasePost {

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

        System.out.println("The last element in collection is: " + getLast(posts).toString());
        System.out.println("Get Element By position: " + getElementByPosition(posts,3).toString());
        System.out.println("Get First Element: " + getFirst(posts).toString());

    }

    @Test
    public void CreatePostsTest(){
        Post post = new Post();
        post.setTitle(GetRandomUUID());
        post.setAuthor(GetRandomUUID());

        given().
                contentType(JSON).
                body(post).
        when().
                post().
        then().
                statusCode(201).
                body("title", equalTo(post.getTitle())).
                body("author", equalTo(post.getAuthor()));
    }
}
