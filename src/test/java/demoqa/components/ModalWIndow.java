package demoqa.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Modal;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class ModalWIndow {

    SelenideElement
                modalWindowText = $("div.modal-title.h4");

    public ModalWIndow checkText(String text){
        modalWindowText.shouldHave(Condition.text(text));
        return this;
    }

    public ModalWIndow verify(String key, String value){
        $x(String.format("//td[text() = '%s']", key)).sibling(0).shouldHave(Condition.text(value));
        return  this;
    }



}
