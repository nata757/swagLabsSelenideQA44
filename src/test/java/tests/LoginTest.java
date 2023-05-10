package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import page.CatalogPage;
import page.LoginPage;

public class LoginTest extends TestBase {
    String login = "standard_user";
    String password = "secret_sauce";
    LoginPage loginPage;
    CatalogPage catalogPage;
    String wrongLogin = faker.name().username();
    String wrongPassword = faker.internet().password();
    String errorText = "Epic sadface: Username and password do not match any user in this service";


   // @Epic("Authorization test")
    //@Feature("Positive login test")
    @Test(description = "Login with valid data")
    public void loginTest() {
        loginPage = new LoginPage();
        loginPage.login(login, password);
        catalogPage = new CatalogPage();
        catalogPage.isTitleVisible();
    }
   // @Epic("Authorization test")
    //@Feature("Negative login test")
    @Test(description = "Login with not valid password")
    public void loginWithWrongPassword() {
        loginPage = new LoginPage();
        loginPage.login(login, wrongPassword);
        checkErrorText(errorText);
    }

    //@Epic("Authorization test")
    //@Feature("Negative login test")
    @Test(description = "Login with not valid login")
    public void loginWithWrongLogin() {
        loginPage = new LoginPage();
        loginPage.login(wrongLogin, password);
        checkErrorText(errorText);
    }


}
