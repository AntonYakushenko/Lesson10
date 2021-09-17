package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
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

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }

    public void typeFirstName(String value) {
      firstNameInput.setValue(value);
    }

    public void typeLastName(String value) {
       lastNameInput.setValue(value);
    }

    public void typeEmail(String value) {
       emailInput.setValue(value);
    }

    public void clickRadioButton() {
        $("[for=gender-radio-1]").click();
    }

    public void typePhoneNumber(String value) {
        numberInput.setValue(value);
    }

    public void uploadPicture() {
       uploadInput.uploadFromClasspath("Rubiks_cube.jpg");
    }

    public void typeSubject(String value){
      subjectInput.sendKeys(value);
      subjectInput.pressEnter();
    }

    public void chooseHobbieSport(){
        checkboxSportInput.click();
    }

    public void submitAndScroll(){
        submitInput.scrollTo().click();
    }

    public void checkFormIsOpened() {
       thankInput.shouldHave(Condition.text(thankForm));
    }
}