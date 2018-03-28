package com.OptionsTest;

import Base.BaseRest;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.isEmptyString;


@Epic("Options")
@Feature("Options tests")
public class OptionsTest extends BaseRest {

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Base Options Test")
    @Story("This is a BaseOptionsTest story")
    public void BaseOptionsTest(){
        given().
        when().
                options().
        then().
                statusCode(204).
                header("Access-Control-Allow-Methods",
                containsString("GET,HEAD,PUT,PATCH,POST,DELETE")).
                body(isEmptyString());

    }

}
