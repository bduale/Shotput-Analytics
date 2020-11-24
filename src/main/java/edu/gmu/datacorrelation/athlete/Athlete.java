package edu.gmu.datacorrelation.athlete;

import edu.gmu.datacorrelation.toss.Throw;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

@Getter
@Setter
public class Athlete {

    private final String uniqueID; // G-Number, etc.
    private String firstname;
    private String surname;
    private Gender gender;
    private PreferredHand preferredHand;
    private LocalDate dob;
    private double height;

    /**
     * Creates an Athlete.
     *
     * @param uniqueID      the unique ID for this athlete
     * @param firstname     the athlete's first name
     * @param surname       the athlete's last name
     * @param preferredHand the athlete's preferred hand
     * @param gender        the athlete's gender
     * @param dob           the athlete's date of birth
     * @param height        the athlete's height in inches
     */
    public Athlete(String uniqueID, String firstname, String surname, PreferredHand preferredHand, Gender gender, LocalDate dob, double height) {
        this.uniqueID = uniqueID;
        this.firstname = firstname;
        this.surname = surname;
        this.preferredHand = preferredHand;
        this.gender = gender;
        this.dob = dob;
        this.height = height;
    }

    /**
     * Creates a NEW Athlete. Generates a new random unique ID.
     *
     * @param firstname     the athlete's first name
     * @param surname       the athlete's last name
     * @param preferredHand the athlete's preferred hand
     * @param gender        the athlete's gender
     * @param dob           the athlete's date of birth
     * @param height        the athlete's height in inches
     */
    public Athlete(String firstname, String surname, PreferredHand preferredHand, Gender gender, LocalDate dob, double height) {
        this.uniqueID = UUID.randomUUID().toString().replaceAll("-", "");
        this.firstname = firstname;
        this.surname = surname;
        this.preferredHand = preferredHand;
        this.gender = gender;
        this.dob = dob;
        this.height = height;
    }

    /**
     * Creates an athlete with null attributes and a new randomly-generated unique ID.
     */
    public Athlete() {
        this.uniqueID = UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * Gets the athlete's age in years as of a provided date.
     *
     * @param now the date to stop counting age at
     * @return the number of years the athlete has been alive
     */
    public int getAge(LocalDate now) {
        return Period.between(dob, now).getYears();
    }

    /**
     * Gets the athlete's age in years as of now.
     *
     * @return the number of years the athlete has been alive
     */
    public int getAge() {
        return getAge(LocalDate.now());
    }
}
