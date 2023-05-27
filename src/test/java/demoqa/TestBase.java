package demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


public class TestBase {

    @BeforeAll
    static void beforeAll(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.pageLoadTimeout = 30000;
//        Configuration.timeout = 10000;
//        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @BeforeEach
    void setUp(){
        SelenideLogger.addListener("allure", new AllureSelenide());

    }

    @AfterEach
    void afterEach(){
       Attachments.addVideo();
       Attachments.pageSource2();
       Attachments.attachScreenshot();
       Attachments.browserConsoleLogs();

    }
}
