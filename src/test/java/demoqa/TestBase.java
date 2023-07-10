package demoqa;

import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;




public class TestBase {

    //name in Jenkins Tim_DemoQA
    //Allure testOps Tima_allure_demoQa
    private static String baseUrl = System.getProperty("baseUrl", "https://demoqa.com");
    private static String browser = System.getProperty("browser", "Chrome100");

    @BeforeAll
    static void beforeAll() {

        Configuration.pageLoadStrategy = "eager";
//        Configuration.headless = true;
        Configuration.pageLoadTimeout = 30000;
        Configuration.baseUrl = baseUrl;
//        Configuration.driverManagerEnabled = true;
        switcher(browser);
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;

    }

    @BeforeEach
    void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());

    }

    @AfterEach
    void afterEach() {
//        Attachments.addVideo();
        Attachments.pageSource2();
        Attachments.attachScreenshot();
//        Attachments.browserConsoleLogs();

    }

    public static void switcher(String browser1) {
        switch (browser1) {
            case "chrome100":
                Configuration.browser = "Chrome";
                Configuration.browserVersion = "100.0";
                break;
            case "fireFox97":
                Configuration.browser = "fireFox";
                Configuration.browserVersion = "97.0";
                break;
            case "fireFox98":
                Configuration.browser = "fireFox";
                Configuration.browserVersion = "98.0";
                break;
            case "chrome99":
                Configuration.browser = "Chrome";
                Configuration.browserVersion = "99.0";
        }

    }
}
