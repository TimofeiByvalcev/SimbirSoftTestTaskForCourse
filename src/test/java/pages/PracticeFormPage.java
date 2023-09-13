package pages;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PracticeFormPage extends BasePage {

    private String url = "https://demoqa.com/automation-practice-form";
    private By firstNameInput = By.cssSelector("#firstName");
    private By lastNameInput = By.xpath("//input[@id='lastName']");
    private By emailInput = By.xpath("//input[@id='userEmail']");
    private By mobilePhoneInput = By.xpath("//input[@id='userNumber']");
    private By submitConfirmation = By.xpath("//div[text()='Thanks for submitting the form']");
    private By addressInput = By.xpath("//textarea[@id='currentAddress']");
    private By submitButton = By.xpath("//button[text()='Submit']");
    private By uploadButton = By.id("uploadPicture");

    //private By subjects = By.xpath("//div[@id = 'subjectsContainer']");
    private By subjectsInput = By.xpath("//div[@id = 'subjectsContainer']//input[@id = 'subjectsInput']");

    private By hobbiesCheckbox = By.xpath("//*[text()='");

    private By calendarField = By.id("dateOfBirthInput");

    private By calendarDates = By.xpath("//div[@id='dateOfBirth']//div[text() = 10]");

    private By stateField = By.cssSelector("#stateCity-wrapper #state");

    private By cityField = By.cssSelector("#stateCity-wrapper #city");


    public By getSubmitConfirmation() {
        return submitConfirmation;
    }

    //@Step("Заполнить поле First Name")
    public PracticeFormPage enterFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        return new PracticeFormPage();
    }

    //@Step("Выбрать в календаре Date of Birth")
    public PracticeFormPage selectBirthDate() {
        driver.findElement(calendarField).click();
        driver.findElement(calendarDates).click();
        return new PracticeFormPage();
    }

    //@Step("Заполнить поле Last Name")
    public PracticeFormPage enterLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
        return new PracticeFormPage();
    }

    //@Step("Заполнить поле Email")
    public PracticeFormPage enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
        return new PracticeFormPage();
    }

    //@Step("Нажать Gender")
    public PracticeFormPage tickGender(String gender) {
        driver.findElement(By.xpath("//*[text()='" + gender + "']")).click();
        return new PracticeFormPage();

    }

    //@Step("Заполнить поле Mobile Number")
    public PracticeFormPage enterNumber(String phoneNumber) {
        driver.findElement(mobilePhoneInput).sendKeys(phoneNumber);
        return new PracticeFormPage();
    }

    //@Step("Заполнить поле Subjects")
    public PracticeFormPage enterSubject(String subject) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(subjectsInput));
        element.sendKeys(subject);
        element.sendKeys(Keys.ENTER);

        return new PracticeFormPage();
    }


    public PracticeFormPage tickHobbies(String hobby) {
        driver.findElement(By.xpath("//*[text()='" + hobby + "']")).click();
        return new PracticeFormPage();
    }

    public PracticeFormPage downloadPicture(String filePath) {
        driver.findElement(uploadButton).sendKeys(filePath);
        return new PracticeFormPage();
    }

    //@Step("Заполнить поле Address")
    public PracticeFormPage enterCurrentAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
        return new PracticeFormPage();
    }

    //@Step("Нажать кнопку Submit")
    public PracticeFormPage clickSubmitButton() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(submitButton));

        Actions builder = new Actions(driver);
        builder.moveToElement(element).click().build().perform();
        return new PracticeFormPage();
    }

    public PracticeFormPage selectState(String state) {
        // WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = driver.findElement(stateField);//wait.until(ExpectedConditions.elementToBeClickable(stateField));
        element.click();
        driver.findElement(By.xpath("//div[@id = 'state']//div[contains(text(), '" + state + "')]")).click();
        return new PracticeFormPage();
    }

    public PracticeFormPage selectCity(String city) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(cityField));
        element.click();
        driver.findElement(By.xpath("//div[@id = 'city']//div[contains(text(), '" + city + "')]")).click();
        return new PracticeFormPage();
    }

    public PracticeFormPage openPage() {
        driver.get(url);
        return new PracticeFormPage();
    }

    public PracticeFormPage checkResults(String value) {
        List<WebElement> elements = driver.findElements(By.cssSelector(".table-responsive td:nth-child(2)"));
        for (WebElement element : elements) {
            if (element.getText().contains(value)) {
                return this;
            }
        }
        return null;
    }


}