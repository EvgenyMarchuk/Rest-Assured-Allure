package UserTest;

import Base.BaseUser;
import Dto.User;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static Helpers.Helper.getLast;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.http.ContentType.JSON;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;

@Epic("Users")
@Feature("User")
public class UserTest extends BaseUser {

    @Test
    public void CreateUserTest(){
        softAssert = new SoftAssert();
        User user = User.createUser();

        given().
                contentType(JSON).
                body(user).
        when().
                post().
        then().
                statusCode(HttpStatus.SC_CREATED);

        int id = getLast(get().as(User[].class)).getId();

        User newUser = get("/{id}", id).as(User.class);

        softAssert.assertEquals(newUser.getName(), user.getName());
        softAssert.assertEquals(newUser.getUsername(), user.getUsername());
        softAssert.assertEquals(newUser.getEmail(), user.getEmail());
        softAssert.assertEquals(newUser.getAddress().getStreet(), user.getAddress().getStreet());
        softAssert.assertEquals(newUser.getAddress().getSuite(), user.getAddress().getSuite());
        softAssert.assertEquals(newUser.getAddress().getCity(), user.getAddress().getCity());
        softAssert.assertEquals(newUser.getAddress().getZipcode(), user.getAddress().getZipcode());
        softAssert.assertEquals(newUser.getAddress().getGeo().getLat(), user.getAddress().getGeo().getLat());
        softAssert.assertEquals(newUser.getAddress().getGeo().getLng(), user.getAddress().getGeo().getLng());
        softAssert.assertEquals(newUser.getPhone(), user.getPhone());
        softAssert.assertEquals(newUser.getWebsite(), user.getWebsite());
        softAssert.assertEquals(newUser.getCompany().getName(), user.getCompany().getName());
        softAssert.assertEquals(newUser.getCompany().getCatchPhrase(), user.getCompany().getCatchPhrase());
        softAssert.assertEquals(newUser.getCompany().getBs(), user.getCompany().getBs());
        softAssert.assertAll();
    }

    @Test
    public void DeleteUserTest(){
        int id = getLast(get().as(User[].class)).getId();

        given().
                contentType(JSON).
        when().
                delete("/{id}", id).
        then().
                statusCode(200);
    }
}
