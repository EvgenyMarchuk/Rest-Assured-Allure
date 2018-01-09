package Base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BasePost extends BaseRest {

    protected static final int POST_ID = 1;

    @BeforeClass
    public void SetUpClass(){
        RestAssured.basePath = "/posts";
    }
}
