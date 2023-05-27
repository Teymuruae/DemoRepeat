package demoqa.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CalendarDemoQa {

   static SelenideElement
            calendarField = $("input#dateOfBirthInput"),
            monthField = $(".react-datepicker__month-select"),
            yearField = $(".react-datepicker__year-select");
   static ElementsCollection days = $$x("//div[contains(@class , 'react-datepicker__day--') and not(contains(@class, 'outside' ))]");

    public static void chooseDay(String day, String month, String year){
        calendarField.click();
        monthField.selectOption(month);
        yearField.selectOption(year);
        days.findBy(Condition.text(day)).click();
    }
}
