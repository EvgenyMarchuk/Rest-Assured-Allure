package Base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import static Helpers.Common.BASE_USERS_PATH;

public class BaseUser extends BaseRest{

    protected SoftAssert softAssert;

    @BeforeClass
    public void SetUpClass(){
        RestAssured.basePath = BASE_USERS_PATH;
    }
}
