package org.vanbart.birthday.core;

import java.time.LocalDate;

/**
 * @since 14/09/2017.
 */
public class Person {

    public final String firstName;

    public final String lastName;

    public final LocalDate birthday;

    public final String email;

    public Person(String firstName, String lastName, LocalDate birthday, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
    }
}
