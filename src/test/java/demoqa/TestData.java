package demoqa;

import com.github.javafaker.Faker;

public class TestData {
    private static Faker faker = new Faker();

    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            subject = faker.options().option("English", "Maths", "Arts"),
            hobby = faker.options().option("Sports", "Reading", "Music"),
            mobile = faker.phoneNumber().subscriberNumber(10),
            day = Integer.toString(faker.number().numberBetween(1, 28)),
            month = faker.options().option("May", "June", "July"),
            year = Integer.toString(faker.number().numberBetween(2015, 2023)),
            text = faker.address().fullAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

    public static String city(String stateName) {
        String city = null;
        switch (stateName) {
            case "NCR":
                city = faker.options().option("Delhi", "Gurgaon");
                break;
            case "Uttar Pradesh":
                city = faker.options().option("Agra", "Lucknow");
                break;
            case "Haryana":
                city = faker.options().option("Karnal", "Panipat");
                break;
            case "Rajasthan":
                city = faker.options().option("Jaipur", "Jaiselmer");
                break;
        }
        return city;

    }


}
