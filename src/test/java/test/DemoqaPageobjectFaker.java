package test;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static test.TestData.*;


public class DemoqaPageobjectFaker extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulSubmitFormTest() {
        registrationPage.OpenPage();
        registrationPage.typeFirstName(TestDataFaker.firstName);
        registrationPage.typeLastName(TestDataFaker.lastName);
        registrationPage.typeEmail(TestDataFaker.userEmail);
        registrationPage.clickRadioButton();
        registrationPage.typePhoneNumber(TestDataFaker.userNumber);
        registrationPage.calendar.enterBirthDate("03", "September", "2005");
        registrationPage.uploadPicture();
        registrationPage.typeSubject(subject);
        registrationPage.chooseHobbies();
        registrationPage.submitAndScroll();
        registrationPage.checkIfFormIsOpened();

        registrationPage.checkInfoFake();
    }
}