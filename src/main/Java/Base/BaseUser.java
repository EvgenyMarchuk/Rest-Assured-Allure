package Base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import static Helpers.Common.BASE_USERS_PATH;

public class BaseUser extends BaseRest{

    @BeforeClass
    public void SetUpClass(){
        RestAssured.basePath = BASE_USERS_PATH;
    }
}
