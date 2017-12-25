package Helpers;

import io.qameta.allure.Step;
import org.testng.annotations.DataProvider;

public class DataproviderClass {

    @DataProvider(name = "provideGetUserId", parallel = true)
    public static Object[][] getUserId(){
        return new Object[][]{{20}, {21}, {22}, {23}, {24}, {5}, {28}, {29} , {310}, {311}, {312}, {313}, {314}};
    }

    @DataProvider(name = "provideGetCommentsId", parallel = true)
    public static Object[][] getCommentId(){
        return new Object[][]{{20}, {21}, {22}, {23}, {24}, {5}, {28}, {29} , {310}, {311}, {312}, {313}, {314}};
    }

    @Step("The step: {text}")
    public static void GetStep(String text) {
        System.out.println(text);
    }
}
