package Base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import static Helpers.Common.BASE_POSTS_PATH;
import static Helpers.Common.BASE_PROFILE_PATH;

public class BaseProfile extends BaseRest {

    @BeforeClass
    public void SetUpClass(){
        RestAssured.basePath = BASE_PROFILE_PATH;
    }
}
