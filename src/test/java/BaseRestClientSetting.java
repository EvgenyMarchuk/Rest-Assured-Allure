import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.*;
import java.util.Properties;


public class BaseRestClientSetting {

    protected Properties environment;

    private final String baseUrl =  "http://127.0.0.1";

    @BeforeSuite
    public void SetUpSuite(){
        RestAssured.baseURI = baseUrl;
        RestAssured.port = 3000;

        RestAssured.filters(new AllureRestAssured());
    }


    @AfterSuite
    public void TearDownSuite() {
        environment = new Properties();
        environment.put("OS name", System.getProperty("os.name"));
        environment.put("OS version", System.getProperty("os.version"));
        //environment.put("OS", System.getProperty("os"));
        environment.put("URL", baseUrl);

        saveEnvironment();
    }

    protected void saveEnvironment() {
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
