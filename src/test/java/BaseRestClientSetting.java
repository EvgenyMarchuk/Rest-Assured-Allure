import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.*;
import java.util.Properties;


public class BaseRestClientSetting {

    private Properties environment;

    private final String baseUrl =  "http://127.0.0.1";

    @BeforeSuite
    public void SetUpSuite(){
        RestAssured.baseURI = baseUrl;
        RestAssured.port = 3000;
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.filters(new AllureRestAssured());
    }


    @AfterSuite
    public void TearDownSuite() {
        environment = new Properties();
        environment.put("OS name", System.getProperty("os.name"));
        environment.put("OS version", System.getProperty("os.version"));
        environment.put("URL", baseUrl);

        saveEnvironment();
    }

    private void saveEnvironment() {
        File resultsFolder = new File("./target/allure-results");
        if (!resultsFolder.exists()) {
            resultsFolder.mkdirs();
        }
        try (OutputStream out = new FileOutputStream("./target/allure-results/environment.properties")){
            environment.store(out, "Allure environment properties");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
