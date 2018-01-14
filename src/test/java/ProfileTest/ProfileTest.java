package ProfileTest;

import Base.BaseProfile;
import Dto.Profile;
import org.testng.annotations.Test;

import static Helpers.Helper.GetRandomUUID;
import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;

public class ProfileTest extends BaseProfile {

    @Test
    public void GetProfileTest(){
        get().
        then().
                statusCode(200).
                contentType(JSON);
    }

    @Test
    public void PostProfileTest(){
        Profile profile = new Profile();
        profile.setName(GetRandomUUID());

        given().
                contentType(JSON).
                body(profile).
        when().
                post().
        then().
                statusCode(201).
                body("name", equalTo(profile.getName()));
    }

    @Test
    public void PutProfileTest(){
        Profile profile = new Profile();
        profile.setName(GetRandomUUID());

        given().
                contentType(JSON).
                body(profile).
        when().
                put().
        then().
                statusCode(200).
                body("name", equalTo(profile.getName()));

    }

    @Test
    public void PatchProfileTest(){
        Profile profile = new Profile();
        profile.setName(GetRandomUUID());

        given().
                contentType(JSON).
                body(profile).
        when().
                patch().
        then().
                statusCode(200).
                body("name", equalTo(profile.getName()));
    }

    @Test
    public void DeleteProfileTest(){
        delete().
        then().
                statusCode(404);
    }
}
