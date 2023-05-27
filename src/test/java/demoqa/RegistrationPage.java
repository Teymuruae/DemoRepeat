package demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import demoqa.components.CalendarDemoQa;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private SelenideElement
                                firstNameField = $("#firstName"),
                                lastNameField = $("#lastName"),
                                emailField = $("#userEmail"),
                                phoneField = $("#userNumber"),
                                subjectField = $("input#subjectsInput"),
                                uploadButton  = $("#uploadPicture"),
                                textArea = $(Selectors.byTagName("textarea")),
                                stateField = $(Selectors.byId("state")),
                                cityField = $(Selectors.byId("city")),
                                submitButton = $(Selectors.byId("submit")),
                                h5Text = $(Selectors.byTagName("h5"));



    private ElementsCollection
                                genderRadio = $$("div.custom-radio"),
                                hobbiesCheckbox = $$("div.custom-checkbox"),
                                stateNames = $$x("//div[contains(@id, 'react-select-3-option')]"),
                                cityNames = $$x("//div[contains(@id, 'react-select-4-option')]");


    public RegistrationPage setFirstName(String name){
        firstNameField.setValue(name);
        return this;
    }

    public RegistrationPage setLastName(String lastName){
        lastNameField.setValue(lastName);
    return this;
    }

    public RegistrationPage setEmail(String email){
        emailField.setValue(email);
        return this;
    }

    public RegistrationPage setPhoneNumber(String phoneNumber){
        phoneField.setValue(phoneNumber);
        return this;
    }

    public RegistrationPage setSubject(String subject){
        subjectField.setValue(subject).pressTab();
        return  this;
    }

    public RegistrationPage uploadFile(String fileName){
        uploadButton.uploadFromClasspath(fileName);
        return this;
    }

    public RegistrationPage setText(String text){
        textArea.setValue(text);
        return this;
    }
    public RegistrationPage checkH5TextOnPage(String h5){
        h5Text.shouldHave(Condition.text(h5));
        return this;
    }

    public RegistrationPage clickSubmitButton(){
        submitButton.click();
        return  this;
    }

    public RegistrationPage chooseGender(String gender){
        genderRadio.findBy(Condition.text(gender)).click();
        return this;
    }

    public RegistrationPage chooseHobby(String hobby){
        hobbiesCheckbox.findBy(Condition.text(hobby)).click();
        return this;
    }

    public RegistrationPage setDate(String day, String month, String year){
        CalendarDemoQa.chooseDay(day, month,year);
        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city){
        stateField.click();
        stateNames.findBy(Condition.text(state)).click();
        cityField.click();
        cityNames.findBy(Condition.text(city)).click();
        return  this;
    }

}
