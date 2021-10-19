package test;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Condition.text;
import static io.qameta.allure.Allure.step;

public class DemoqaPageobjectFaker extends TestBase {

    static Faker faker = new Faker();
    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            subject = "Computer Science";

    RegistrationPage registrationPage = new RegistrationPage();

    @Feature("Forms")
    @Story("Заполнение форм")
    @Owner("Anton Yakushenko")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "demoqa", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Заполнение Registration Form")
    @Test
    void successfulSubmitFormTest() {
        registrationPage.openPage();
        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeEmail(userEmail);
        registrationPage.clickRadioButton();
        registrationPage.typePhoneNumber(userNumber);
        registrationPage.calendar.enterBirthDate("03", "September", "2005");
        registrationPage.uploadPicture();
        registrationPage.typeSubject(subject);
        registrationPage.chooseHobbieSport();
        registrationPage.submitAndScroll();
        registrationPage.checkFormIsOpened();


        step("Проверить основные поля в форме", () -> {
            registrationPage.finalTable.shouldHave(
                    text(firstName),
                    text(lastName),
                    text(userEmail),
                    text(userNumber),
                    text("03"),
                    text("September"),
                    text("2005"),
                    text("Sports"));
        });
    }
}