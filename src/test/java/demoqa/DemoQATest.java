package demoqa;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import demoqa.components.ModalWIndow;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class DemoQATest extends TestBase {
    private String path = "/automation-practice-form";
    RegistrationPage registrationPage = new RegistrationPage();
    ModalWIndow modalWIndow = new ModalWIndow();
    String state = TestData.state;
    String city = TestData.city(state);


    @Owner("TimBart")
    @DisplayName("Заполнение формы регистрации студента")
    @Tag("demoQaTest")
    @Test
    void demoQaTest() {

        step("open page", () -> {
            Selenide.open(path);
            Selenide.executeJavaScript("$('footer').remove()");
            Selenide.executeJavaScript("$('#fixedban').remove()");
            WebDriverRunner.getWebDriver().manage().window().maximize();
        });
        step("fill registration form", () -> {
            registrationPage
                    .checkH5TextOnPage("Student Registration Form")
                    .setFirstName(TestData.firstName)
                    .setLastName(TestData.lastName)
                    .setEmail(TestData.email)
                    .setPhoneNumber(TestData.mobile)
                    .setSubject(TestData.subject)
                    .uploadFile("test.png")
                    .setText(TestData.text)
                    .chooseGender(TestData.gender)
                    .chooseHobby(TestData.hobby)
                    .setDate(TestData.day, TestData.month, TestData.year)
                    .setStateAndCity(state, city)
                    .clickSubmitButton();
        });
        step("verify form", () -> {
            modalWIndow
                    .checkText("Thanks for submitting the form")
                    .verify("Gender", TestData.gender)
                    .verify("Student Name", TestData.firstName + " " + TestData.lastName)
                    .verify("Student Email", TestData.email)
                    .verify("Mobile", TestData.mobile)
                    .verify("Date of Birth", String.format("%s %s,%s", TestData.day, TestData.month, TestData.year))
                    .verify("Subjects", TestData.subject)
                    .verify("Hobbies", TestData.hobby)
                    .verify("Picture", "test.png")
                    .verify("Address", TestData.text)
                    .verify("State and City", state + " " + city);
        });

    }
}
