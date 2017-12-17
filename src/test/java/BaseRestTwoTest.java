import io.qameta.allure.*;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

@Epic("This is Epic Two")
@Feature("This is a Feature Two")
public class BaseRestTwoTest extends BaseRestClientSetting {

    @BeforeClass
    public void SetUpClass(){
        RestAssured.basePath = "/comments";
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Description("New test example One")
    @Story("This is a story")
    public void BaseRestClientOneTest(){
        GetStep("Base Rest Client One Test");
        given().
                contentType(JSON).
        when().
                get().
        then().
                statusCode(200);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("New test example Two")
    @Story("This is a story")
    public void BaseRestClientTwoTest(){
        GetStep("Base Rest Client Two Test");
        given().
                contentType(JSON).
        when().
                get().
        then().
                statusCode(200);
    }

    @Test(dataProvider = "provideGetCommentsId")
    @Severity(SeverityLevel.CRITICAL)
    @Description("New test example Three")
    @Story("This is a data provider story")
    public void BaseRestClientThreeTest(int commentsId){
        GetStep(String.format("Base Rest Client Three Test and commentsId: %d", commentsId));
        given().
                contentType(JSON).
        when().
                get("/{commentsId}", commentsId).
        then().
                statusCode(404);
    }

    @Test(dataProvider = "provideGetCommentsId")
    @Severity(SeverityLevel.CRITICAL)
    @Description("New test example Three")
    @Story("This is a data provider story")
    public void BaseRestClientThreeOneTest(int commentsId){
        GetStep(String.format("Base Rest Client Three  One Test and commentsId: %d", commentsId));
        given().
                contentType(JSON).
                when().
                get("/{commentsId}", commentsId).
                then().
                statusCode(200);
    }

    @Step("The step: {text}")
    private void GetStep(String text) {
        System.out.println(text);
    }

    @DataProvider(name = "provideGetCommentsId")
    public static Object[][] getCommentsId(){
        return new Object[][]{{2}, {3}, {4}, {5}, {6}, {7}, {8}};
    }
}
