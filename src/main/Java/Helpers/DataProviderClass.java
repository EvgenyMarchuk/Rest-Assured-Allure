package Helpers;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "provideGetUserId", parallel = true)
    public static Object[][] getUserId(){
        return new Object[][]{{2000}, {2001}, {2002}, {2003}, {2004}, {2005}, {2006}};
    }

    @DataProvider(name = "provideGetCommentsId", parallel = true)
    public static Object[][] getCommentId(){
        return new Object[][]{{2000}, {2001}, {2002}, {2003}, {2004}, {2005}, {2006}};
    }
}
