package Base;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import static Helpers.Common.BASE_PORT;
import static Helpers.Common.BASE_URI;

public class BaseRest {

    private static Properties environment;
    protected static final int POST_ID = 1;

    @BeforeSuite
    public void SetUpSuite(){
        RestAssured.baseURI = BASE_URI;
        RestAssured.port = BASE_PORT;
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.filters(new AllureRestAssured());
    }


    @AfterSuite
    public void TearDownSuite() {
        environment = new Properties();
        environment.put("OS name", System.getProperty("os.name"));
        environment.put("OS version", System.getProperty("os.version"));
        environment.put("URL", BASE_URI);

        saveEnvironment();
    }

    private void saveEnvironment() {
        File resultsFolder = new File("./build/allure-results");
        if (!resultsFolder.exists()) {
            resultsFolder.mkdirs();
        }
        try (OutputStream out = new FileOutputStream("./build/allure-results/environment.properties")){
            environment.store(out, "Allure environment properties");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
