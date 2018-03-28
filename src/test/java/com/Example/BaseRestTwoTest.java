package com.Example;

import Base.BasePosts;
import Helpers.DataProviderClass;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Helpers.Steps.GetStep;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

@Epic("This is Epic Two")
@Feature("This is a Feature Two")
public class BaseRestTwoTest extends BasePosts {

    @BeforeClass
    public void SetUpClass(){
        RestAssured.basePath = "/comments";
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Description("New test example One")
    @Story("This is a story")
    public void BaseRestClientOneTwoTest(){
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
    public void BaseRestClientTwoTwoTest(){
        GetStep("Base Rest Client Two Test");
        given().
                contentType(JSON).
        when().
                get().
        then().
                statusCode(200);
    }

    @Test(dataProvider = "provideGetCommentsId", dataProviderClass = DataProviderClass.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("New test example Three")
    @Story("This is a data provider story")
    public void BaseRestClientThreeTwoTest(int id){
        GetStep(String.format("Base Rest Client Three Test and commentsId: %d", id));
        given().
                contentType(JSON).
        when().
                get("/{id}", id).
        then().
                statusCode(404);
    }

    @Test(dataProvider = "provideGetCommentsId", dataProviderClass = DataProviderClass.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("New test example Three")
    @Story("This is a data provider story")
    public void BaseRestClientFourTwoTest(int id){
        GetStep(String.format("Base Rest Client Three  One Test and commentsId: %d", id));
        given().
                contentType(JSON).
        when().
                get("/{id}", id).
        then().
                statusCode(404);
    }

    @Test(dataProvider = "provideGetCommentsId", dataProviderClass = DataProviderClass.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("New test example Three")
    @Story("This is a data provider story")
    public void BaseRestClientFiveTwoTest(int id){
        GetStep(String.format("Base Rest Client Three  One Test and commentsId: %d", id));
        given().
                contentType(JSON).
        when().
                get("/{id}", id).
        then().
                statusCode(404);
    }

}
