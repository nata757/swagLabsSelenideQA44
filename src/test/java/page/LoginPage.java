package page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private SelenideElement userNameInput = $x( "//input[@id=\"user-name\"]");
    private SelenideElement passwordInput = $x ("//input[@id=\"password\"]");
    private SelenideElement loginButton = $x ("//input[@id=\"login-button\"]");

   // @Step("Login in the app with login: {login}, password: {password}")
    public void login(String login, String password) {
        userNameInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.click();
    }


}
