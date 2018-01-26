package UserTest;

import Base.BaseUser;
import Dto.User;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import static Helpers.Helper.getLast;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;

@Epic("Users")
@Feature("User")
public class UserTest extends BaseUser {

    @Test
    public void CreateUserTest(){
        User user = User.createUser();

        System.out.println(user.toString());

        given().
                contentType(JSON).
                body(user).
        when().
                post().
        then().
                statusCode(201).
                body("name", equalTo(user.getName())).
                body("username", equalTo(user.getUsername())).
                body("email", equalTo(user.getEmail())).
                body("address.street", equalTo(user.getAddress().getStreet())).
                body("address.suite", equalTo(user.getAddress().getSuite())).
                body("address.city", equalTo(user.getAddress().getCity())).
                body("address.zipcode", equalTo(user.getAddress().getZipcode())).
                body("address.geo.lat", equalTo(user.getAddress().getGeo().getLat())).
                body("address.geo.lng", equalTo(user.getAddress().getGeo().getLng())).
                body("phone", equalTo(user.getPhone())).
                body("website", equalTo(user.getWebsite())).
                body("company.name", equalTo(user.getCompany().getName())).
                body("company.catchPhrase", equalTo(user.getCompany().getCatchPhrase())).
                body("company.bs", equalTo(user.getCompany().getBs()));
    }

    @Test
    public void DeleteUserTest(){
        int id = getLast(get().as(User[].class)).getId();

        given().
                contentType(JSON).
        when().
                delete("/{id}", id).
        then().
                log().all().
                statusCode(200);
    }
}
