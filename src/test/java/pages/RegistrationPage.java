package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import test.TestDataFaker;

import java.io.File;

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
    checkbox1Input = $("[for=hobbies-checkbox-1]"),
    checkbox2Input = $("[for=hobbies-checkbox-2]"),
    checkbox3Input = $("[for=hobbies-checkbox-3]"),
    submitInput = $("#submit"),
    thankInput = $("#example-modal-sizes-title-lg");


    public CalendarComponent calendar = new CalendarComponent();

    public void OpenPage() {
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
       uploadInput.uploadFile(new File("src/test/resources/Rubiks_cube.jpg"));
    }

    public void typeSubject(String value){
      subjectInput.sendKeys(value);
    }

    public void chooseHobbies(){
        checkbox1Input.click();
        checkbox2Input.click();
        checkbox3Input.click();
    }

    public void submitAndScroll(){
        submitInput.scrollTo().click();
        }

    public void checkIfFormIsOpened() {
       thankInput.shouldHave(Condition.text(thankForm));
    }

    public void checkInfo(){
        $(".modal-body").shouldHave(
                text("Anton"),
                text("Yakushenko"),
                text("yakushenkoaa73@gmail.com"),
                text("Male"),
                text("987456123"),
                text("03"),
                text("September"),
                text("2005"),
                text("Sports"),
                text("Reading"),
                text("Music"));

    }
    public void checkInfoFake(){
        $(".modal-body").shouldHave(
                text(TestDataFaker.firstName),
                text(TestDataFaker.lastName),
                text(TestDataFaker.userEmail),
                text(TestDataFaker.userNumber),
                text("03"),
                text("September"),
                text("2005"),
                text("Sports"),
                text("Reading"),
                text("Music"));
    }
}