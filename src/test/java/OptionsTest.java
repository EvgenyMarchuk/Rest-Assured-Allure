import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


@Epic("Options")
@Feature("Options tests")
public class OptionsTest extends BaseRestClientSetting {

    @BeforeClass
    public void SetUpClass(){
        RestAssured.basePath = "/";
    }

    @Test
    public void BaseOptionsTest(){
        given().
        when().
                options().
        then().
                log().all().
                statusCode(204).
                header("Access-Control-Allow-Methods",
                containsString("GET,HEAD,PUT,PATCH,POST,DELETE")).
                body(isEmptyString());

    }

}
