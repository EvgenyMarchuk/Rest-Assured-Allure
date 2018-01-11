package Example;

import Base.BasePosts;
import Helpers.DataProviderClass;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static Helpers.Steps.GetStep;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

@Epic("This is Epic One")
@Feature("This is a Feature One")
public class BaseRestOneTest extends BasePosts {

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

    @Test(dataProvider = "provideGetPostId", dataProviderClass = DataProviderClass.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("New test example Three")
    @Story("This is a data provider story")
    public void BaseRestClientThreeOneTest(int id){
        GetStep(String.format("Base Rest Client Three One Test and Id: %d", id));
        given().
                contentType(JSON).
        when().
                get("/{id}", id).
        then().
                statusCode(404);
    }

    @Test(dataProvider = "provideGetPostId", dataProviderClass = DataProviderClass.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("New test example Three")
    @Story("This is a data provider story")
    public void BaseRestClientFourOneTest(int id){
        GetStep(String.format("Base Rest Client Three One Test and Id: %d", id));
        given().
                contentType(JSON).
        when().
                get("/{id}", id).
        then().
                statusCode(404);
    }

    @Test(dataProvider = "provideGetPostId", dataProviderClass = DataProviderClass.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("New test example Three")
    @Story("This is a data provider story")
    public void BaseRestClientFiveOneTest(int id){
        GetStep(String.format("Base Rest Client Three One Test and Id: %d", id));
        given().
                contentType(JSON).
        when().
                get("/{id}", id).
        then().
                statusCode(404);
    }

}
