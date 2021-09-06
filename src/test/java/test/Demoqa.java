package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Demoqa {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }


    @Test
    void successfulSubmitFormTest() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Anton");
        $("#lastName").setValue("Yakushenko");
        $("#userEmail").setValue("yakushenkoaa73@gmail.com");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("9874561232");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("2005");
        $(".react-datepicker__day--003").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/Rubiks_cube.jpg"));
        $("#subjectsInput").sendKeys("What is this?");
        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-2]").click();
        $("[for=hobbies-checkbox-3]").click();
        $("#submit").scrollTo().click();

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
}