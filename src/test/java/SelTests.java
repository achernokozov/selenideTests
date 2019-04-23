import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.screenshot;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelTests  {

    @Test(priority = 1)
    public void firstTest() { //Test 1: Business critical fields, labels and buttons are existed after opening www.americanexpress.com page;

        open("https://www.americanexpress.com/");
        $("img[src*=\"/dls-logo-bluebox-solid.svg\"]").shouldBe(visible);
        $("#gnav_login").shouldBe(visible);
        $("input[placeholder=\"User ID\"]").shouldBe(visible);
        $("input[placeholder=\"Password\"]").shouldBe(visible);
        $("option[value=\"cards\"]").shouldHave(text("Cards - My Account"));
        $("#login-submit").shouldBe(visible);
        $("span[class=\"axp-footer__footer__countryName___1w3gS\"]").shouldHave(text("United States"));
        screenshot("Test_1");
    }
    @Test(priority = 2)
    public void secondTest(){ //Test 2: Login page fields are existed

        open("https://www.americanexpress.com/");
        $("#gnav_login").click();
        $("#eliloUserID").shouldBe(visible);
        $("#eliloPassword").shouldBe(visible);
        $("button[class=\"btn-fluid margin-0-b \"]").shouldBe(visible);
//
//                $("button[type=\"submit\"]").click();
//                $(".margin-1-l").shouldHave(text("Both the User ID and Password are required."));
        screenshot("Test_2");
    }
    @Test(priority = 3)
    public void thirdTest(){ //Test 3: Site should be changed according to the selected country
        open("https://www.americanexpress.com/");
        $("a[title=\"Change your American Express Website\"]").click();
        $("#GlobalSplashContainer").shouldBe(visible);
        $("a[href=\"/uk/\"]").click();
        $("input[placeholder=\"User ID\"]").shouldBe(visible);
        $("input[placeholder=\"Password\"]").shouldBe(visible);
        $("option[value=\"cards\"]").shouldHave(text("Cards - My Account"));
        $("#login-submit").shouldBe(visible);
        $("span.axp-footer__footer__countryName___1w3gS").shouldHave(text("United Kingdom"));
        screenshot("Test_3");

    }
    @Test(priority = 5)
    public void fourthTest(){ //Test 4: "Start Saving" page counting is correct
        open("https://www.americanexpress.com/");
        $("a[alt=\"Start Saving\"]").click();
        $("#initial-deposit").setValue("8000");
        $("#recurring-deposit").setValue("500").pressEnter();
        $("#future-value").shouldHave(text("39,963"));
        $("#interest-earned").shouldHave(text("2,463"));
        screenshot("Test_4");
    }
    @Test(priority = 4)
    public void fifthTest(){ //Test 5: Search for article is working
        open("https://www.americanexpress.com/");
        $("label[for*=\"lP8fm\"]").click();
        $("form.axp-global-header__dls__margin0___1PHt0").click();
        $("input[class*=\"axp-global-header__dls__formControl___Xc9-9\"]").setValue("dispute").pressEnter();
        $("section[class*=\"margin-center\"]").waitUntil(exist,20000);
        $("a[title=\"Merchant Dispute Policy | American Express\"]").shouldBe(visible).click();
        $("link[href=\"https://www.americanexpress.com/us/merchant/manage-disputes.html\"]").shouldBe(exist);
        screenshot("Test_5");

    }




}