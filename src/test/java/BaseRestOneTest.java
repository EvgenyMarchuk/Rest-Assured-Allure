import Helpers.DataProviderClass;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Helpers.Steps.GetStep;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

@Epic("This is Epic One")
@Feature("This is a Feature One")
public class BaseRestOneTest extends BaseRestClientSetting {

    @BeforeClass
    public void SetUpClass(){
        RestAssured.basePath = "/posts";
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Description("New test example One")
    @Story("This is a story")
    public void BaseRestClientOneOneTest(){
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
    public void BaseRestClientTwoOneTest(){
        GetStep("Base Rest Client Two Test");
        given().
                contentType(JSON).
        when().
                get().
        then().
                statusCode(200);
    }

    @Test(dataProvider = "provideGetUserId", dataProviderClass = DataProviderClass.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("New test example Three")
    @Story("This is a data provider story")
    public void BaseRestClientThreeOneTest(int userId){
        GetStep(String.format("Base Rest Client Three Test and userId: %d", userId));
        given().
                contentType(JSON).
        when().
                get("/{userId}", userId).
        then().
                statusCode(404);
    }

    @Test(dataProvider = "provideGetUserId", dataProviderClass = DataProviderClass.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("New test example Three")
    @Story("This is a data provider story")
    public void BaseRestClientFourOneTest(int userId){
        GetStep(String.format("Base Rest Client Three  One Test and userId: %d", userId));
        given().
                contentType(JSON).
        when().
                get("/{userId}", userId).
        then().
                statusCode(404);
    }

    @Test(dataProvider = "provideGetUserId", dataProviderClass = DataProviderClass.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("New test example Three")
    @Story("This is a data provider story")
    public void BaseRestClientFiveOneTest(int userId){
        GetStep(String.format("Base Rest Client Three  One Test and userId: %d", userId));
        given().
                contentType(JSON).
        when().
                get("/{userId}", userId).
        then().
                statusCode(404);
    }




}
