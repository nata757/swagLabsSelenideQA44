package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CatalogPage;
import page.LoginPage;

import java.util.List;

public class SocialLinksTest extends TestBase {

    CatalogPage catalogPage;
    LoginPage loginPage;

    String urlTwitter = "https://twitter.com/saucelabs";
    String urlFacebook = "https://www.facebook.com/saucelabs";
String urlLinkedin = "https://www.linkedin.com/company/sauce-labs/";


    @BeforeMethod
    public void  login(){
        loginPage = new LoginPage();
        loginPage.login("standard_user", "secret_sauce");


    }
    @Test
    public void socialLinkTest(){
        catalogPage = new CatalogPage();
        catalogPage.isTitleVisible();


        catalogPage.checkAndClickToSocialLink("Twitter", urlTwitter);
        catalogPage.checkUrl(urlTwitter);

        List<String> linkText  = catalogPage.linkText;



        catalogPage.checkAndClickToSocialLink("Facebook", urlFacebook);
        catalogPage.checkUrl(urlFacebook);

        catalogPage.checkAndClickToSocialLink("Linkedin", urlLinkedin);
        catalogPage.checkUrlLinkedin();
    }
}

