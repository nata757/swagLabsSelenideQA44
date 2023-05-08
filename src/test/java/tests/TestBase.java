package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.ScreenShooter;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    Faker faker = new Faker();

    @BeforeMethod
    public void setUp(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.reportsFolder = "test-result/reports";
        ScreenShooter.captureSuccessfulTests = true;
        Configuration.browserCapabilities = new ChromeOptions().addArguments("-remote-allow-origins=*");
        open("https://www.saucedemo.com");

    }

    @AfterMethod
    public void closeBrowser(){
        Selenide.closeWebDriver();
    }

    public void checkErrorText(String errorText) {
        $x("//div[@class=\"error-message-container error\"]")
                .shouldBe(Condition.visible)
                .shouldHave(Condition.exactText(errorText));

    }

}
