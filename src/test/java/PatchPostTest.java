import Base.BasePost;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static Helpers.Helper.GetRandomUUID;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;

@Epic("Post")
@Feature("Patch post test")
public class PatchPostTest extends BasePost {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Base Patch Author Test")
    @Story("This is a BasePatchAuthorTest story")
    public void BasePatchAuthorTest(){
        Map<String, String> map = new HashMap<>();
        map.put("author", GetRandomUUID());

        given().
                contentType(JSON).
                body(map).
        when().
                patch("/{id}", POST_ID).
        then().
                statusCode(200).
                body("author", equalTo(map.get("author")));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Base Patch Title Test")
    @Story("This is a BasePatchTitleTest story")
    public void BasePatchTitleTest(){
        Map<String, String> map = new HashMap<>();
        map.put("title", GetRandomUUID());

        given().
                contentType(JSON).
                body(map).
        when().
                patch("/{id}", POST_ID).
        then().
                statusCode(200).
                body("title", equalTo(map.get("title")));
    }
}
