package Helpers;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "provideGetUserId", parallel = true)
    public static Object[][] getUserId(){
        return new Object[][]{{200}, {201}, {202}, {203}, {204}, {205}, {206}, {207} , {208}, {209}, {230}, {231}, {232}};
    }

    @DataProvider(name = "provideGetCommentsId", parallel = true)
    public static Object[][] getCommentId(){
        return new Object[][]{{200}, {201}, {202}, {203}, {204}, {205}, {206}, {207} , {208}, {209}, {230}, {231}, {232}};
    }
}
