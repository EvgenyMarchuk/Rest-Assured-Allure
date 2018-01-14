package UserTest;

import Base.BaseUser;
import Dto.*;
import org.testng.annotations.Test;

import static Helpers.Helper.getLast;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;

public class UserTest extends BaseUser {

    @Test
    public void CreateUserTest(){
        Geo geo = new Geo();
        geo.setLat("-45.78");
        geo.setLng("80.28");

        Address address = new Address();
        address.setStreet("Kile kill");
        address.setSuite("Apt. 200");
        address.setCity("Minsk");
        address.setZipcode("220015");
        address.setGeo(geo);

        Company company = new Company();
        company.setName("Test Ltd.");
        company.setCatchPhrase("We're the fastest.");
        company.setBs("real team");

        User user = new User();
        user.setName("John Gabriel");
        user.setUsername("JG");
        user.setEmail("JohnGabriel@gmail.com");
        user.setAddress(address);
        user.setPhone("1-771-736-8031 x114477");
        user.setWebsite("testEmail.com");
        user.setCompany(company);

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
                body("phone", equalTo(user.getPhone())).
                body("website", equalTo(user.getWebsite())).
                body("company.name", equalTo(user.getCompany().getName())).
                body("company.catchPhrase", equalTo(user.getCompany().getCatchPhrase())).
                body("company.bs", equalTo(user.getCompany().getBs())).
                body("address.geo.lat", equalTo(user.getAddress().getGeo().getLat())).
                body("address.geo.lng", equalTo(user.getAddress().getGeo().getLng()));
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
