package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;

public class CatalogPage {
    private SelenideElement pageTitel = $x("//span[@class=\"title\"]");


    public void  isTitelVisible(){
        pageTitel.shouldBe(Condition.visible).shouldHave(Condition.exactText("Products"));

    }
@Test
    public void  loginWithWrongPassword(){

}
@Test
public void  loginWithWrongLogin(){

}

}
