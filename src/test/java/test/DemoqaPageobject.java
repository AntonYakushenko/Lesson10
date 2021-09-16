package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static test.TestData.*;


public class DemoqaPageobject extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulSubmitFormTest() {
        registrationPage.OpenPage();
        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeEmail(email);
        registrationPage.clickRadioButton();
        registrationPage.typePhoneNumber(number);
        registrationPage.calendar.enterBirthDate("03", "September", "2005");
        registrationPage.uploadPicture();
        registrationPage.typeSubject(subject);
        registrationPage.chooseHobbies();
        registrationPage.submitAndScroll();
        registrationPage.checkIfFormIsOpened();

        registrationPage.checkInfo();
    }
}