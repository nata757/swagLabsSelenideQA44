package tests;

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



    @Test
    public void loginTest(){
        loginPage = new LoginPage();
        loginPage.login(login, password);
        catalogPage = new CatalogPage();
        catalogPage.isTitelVisible();

    }
    @Test
    public void loginWithWrongPassword() {
        loginPage = new LoginPage();
        loginPage.login(login, wrongPassword);
        checkErrorText(errorText);

    }
    @Test
    public void loginWithWrongLogin() {
        loginPage = new LoginPage();
        loginPage.login(wrongLogin, password);
        checkErrorText(errorText);

    }

}
