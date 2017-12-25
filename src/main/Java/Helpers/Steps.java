package Helpers;

import io.qameta.allure.Step;

public class Steps {

    @Step("The step: {text}")
    public static void GetStep(String text) {
        System.out.println(text);
    }
}
