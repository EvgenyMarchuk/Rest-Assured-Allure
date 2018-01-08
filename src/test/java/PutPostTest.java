import Dto.Post;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Helpers.Helper.GetRandomUUID;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;

@Epic("Post")
@Feature("Put post test")
public class PutPostTest extends BaseRestClientSetting{

    @BeforeClass
    public void SetUpClass(){
        RestAssured.basePath = "/posts";
    }

    @Test
    public void BasePutTest(){
        Post post = new Post();
        post.setTitle(GetRandomUUID());
        post.setAuthor(GetRandomUUID());

        given().
                contentType(JSON).
                body(post).
        when().
                put("/1").
        then().
                statusCode(200);

        when().
                get("/1").
        then().
                statusCode(200).
                body("title", equalTo(post.getTitle())).
                body("author", equalTo(post.getAuthor()));

    }
}
