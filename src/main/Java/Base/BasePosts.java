package Base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import static Helpers.Common.BASE_POSTS_PATH;

public class BasePosts extends BaseRest {

    @BeforeClass
    public void SetUpClass(){
        RestAssured.basePath = BASE_POSTS_PATH;
    }
}
