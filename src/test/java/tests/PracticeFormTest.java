package tests;

import core.BaseTest;
import io.qameta.allure.Owner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.PracticeFormPage;
import static helpers.FakeUserData.*;
//test comment


@DisplayName("Student registration form")
public class PracticeFormTest extends BaseTest {
    @DisplayName("Fill out student registration form")
    @Owner("Tim Byvalcev")
    @Test
    public void FillOutStudentRegistrationForm() {
        PracticeFormPage practiceFormPage = new PracticeFormPage()
                .openPage()
                .enterFirstName(getFirstName())
                .enterLastName(getLastName())
                .enterEmail(getEmail())
                .tickGender(getGender())
                .enterNumber(getMobileNumber())
                .selectBirthDate()
                .enterSubject(getSubjects())
                .tickHobbies(getHobby())
                .downloadPicture(System.getProperty("user.dir")+"\\images\\image.jpg")
                .enterCurrentAddress(getAddress())
                .selectState(getState())
                .selectCity(getCity())
                .clickSubmitButton();

        Assert.assertTrue(driver.findElement(practiceFormPage.getSubmitConfirmation()).isDisplayed());
        PracticeFormPage practiceFormPage1 = new PracticeFormPage()
                .checkResults(getFirstName())
                .checkResults(getLastName())
                .checkResults(getEmail())
                .checkResults(getGender())
                .checkResults(getMobileNumber())
                .checkResults(getSubjects())
                .checkResults(getHobby())
                .checkResults(getAddress())
                .checkResults(getState())
                .checkResults(getCity());

    }
}
