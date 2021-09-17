package test;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Condition.text;

public class DemoqaPageobjectFaker extends TestBase {

    static Faker faker = new Faker();
    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            subject = "Computer Science";

    RegistrationPage registrationPage = new RegistrationPage();

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

        registrationPage.finalTable.shouldHave(
                text(firstName),
                text(lastName),
                text(userEmail),
                text(userNumber),
                text("03"),
                text("September"),
                text("2005"),
                text("Sports"));
    }
}