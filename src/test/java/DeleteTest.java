import Base.BasePost;
import Dto.Post;
import org.testng.annotations.Test;

import static Helpers.Helper.getLast;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class DeleteTest extends BasePost {

    @Test
    public void BaseDeleteTest(){
        int id = getLast(get().as(Post[].class)).getId();

        given().
                contentType(JSON).
        when().
                delete("/{id}", id).
        then().
                statusCode(200);
    }
}
