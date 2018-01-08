import Dto.Post;
import com.sun.org.apache.xpath.internal.operations.NotEquals;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static Helpers.Helper.GetRandomUUID;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

@Epic("Post")
@Feature("pATCH post test")
public class PatchPostTest extends BaseRestClientSetting {

    @BeforeClass
    public void SetUpClass(){
        RestAssured.basePath = "/posts";
    }

    @Test
    public void BasePatchAuthorTest(){
        Map<String, String> map = new HashMap<>();
        map.put("author", GetRandomUUID());

        Post oldPost = get("/1").
                as(Post.class);

        given().
                contentType(JSON).
                body(map).
        when().
                patch("/1").
        then().
                statusCode(200).
                body("title", equalTo(oldPost.getTitle())).
                body("author", equalTo(map.get("author")));
    }

    @Test
    public void BasePatchTitleTest(){
        Map<String, String> map = new HashMap<>();
        map.put("title", GetRandomUUID());

        Post oldPost = get("/1").
                as(Post.class);

        given().
                contentType(JSON).
                body(map).
        when().
                patch("/1").
        then().
                statusCode(200).
                body("author", equalTo(oldPost.getTitle())).
                body("title", equalTo(map.get("title")));
    }
}
