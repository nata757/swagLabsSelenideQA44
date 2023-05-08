package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private SelenideElement userNameInput = $x( "//input[@id=\"user-name\"]");
    private SelenideElement passwordInput = $x ("//input[@id=\"password\"]");
    private SelenideElement loginButton = $x ("//input[@id=\"login-button\"]");
    public void login(String login, String password) {
        userNameInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

}
