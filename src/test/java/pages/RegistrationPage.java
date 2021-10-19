package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private final String thankForm = "Thanks for submitting the form";
    private SelenideElement
    firstNameInput = $("#firstName"),
    lastNameInput = $("#lastName"),
    emailInput = $("#userEmail"),
    numberInput = $("#userNumber"),
    uploadInput =  $("#uploadPicture"),
    subjectInput =   $("#subjectsInput"),
    checkboxSportInput = $("[for=hobbies-checkbox-1]"),
    submitInput = $("#submit"),
    thankInput = $("#example-modal-sizes-title-lg");
    public static SelenideElement finalTable =  $(".modal-body");

    public CalendarComponent calendar = new CalendarComponent();

    @Step("Открыть страницу demoqa.com/automation-practice-form")
    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }

    @Step("Заполнить поле First Name")
    public void typeFirstName(String value) {
      firstNameInput.setValue(value);
    }

    @Step("Заполнить поле Last Name")
    public void typeLastName(String value) {
       lastNameInput.setValue(value);
    }

    @Step("Заполнить поле Email")
    public void typeEmail(String value) {
       emailInput.setValue(value);
    }

    @Step("Выбрать радиокнопку Gender")
    public void clickRadioButton() {
        $("[for=gender-radio-1]").click();
    }

    @Step("Заполнить поле Mobile")
    public void typePhoneNumber(String value) {
        numberInput.setValue(value);
    }

    @Step("Загрузка картинки")
    public void uploadPicture() {
       uploadInput.uploadFromClasspath("Rubiks_cube.jpg");
    }

    @Step("Выбрать предмет")
    public void typeSubject(String value){
      subjectInput.sendKeys(value);
      subjectInput.pressEnter();
    }

    @Step("Выбрать хобби спорт")
    public void chooseHobbieSport(){
        checkboxSportInput.click();
    }

    public void submitAndScroll(){
        submitInput.scrollTo().click();
    }

    @Step("Проверка соответствия")
    public void checkFormIsOpened() {
       thankInput.shouldHave(Condition.text(thankForm));
    }
}