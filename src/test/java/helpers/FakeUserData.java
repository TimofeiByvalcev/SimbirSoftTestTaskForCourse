package helpers;
import com.github.javafaker.Faker;

public class FakeUserData {

    static Faker faker = new Faker();

    public static String FIRST_NAME = faker.name().firstName();

    public static String LAST_NAME = faker.name().lastName();

    public static String EMAIL = faker.internet().emailAddress();

    public static String MOBILE_NUMBER = faker.phoneNumber().subscriberNumber(10);

    public static String SUBJECTS = "Maths";

    public static String ADDRESS = faker.address().streetAddress();

    public static String STATE = "Uttar Pradesh";

    public static String CITY = "Agra";

    public static String GENDER = "Male";

    public static String HOBBY = "Sports";

    public static String getFirstName() {
        return FIRST_NAME;
    }

    public static String getLastName() {
        return LAST_NAME;
    }

    public static String getEmail() {
        return EMAIL;
    }

    public static String getMobileNumber() {
        return MOBILE_NUMBER;
    }

    public static String getSubjects() {
        return SUBJECTS;
    }

    public static String getAddress() {
        return ADDRESS;
    }

    public static String getState() {
        return STATE;
    }

    public static String getCity() {
        return CITY;
    }

    public static String getGender() {
        return GENDER;
    }

    public static String getHobby() {
        return HOBBY;
    }
}

