package org.vanbart.birthday.adapters;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.vanbart.birthday.core.EmployeeRepository;
import org.vanbart.birthday.core.Person;

import java.time.LocalDate;
import java.util.stream.Stream;

/**
 * Implementation which hard coded Persons, whose birthday is today.
 */
@Component
@Profile("today")
public class TodayEmployeeRepository implements EmployeeRepository {

    final Person p1 = new Person("Birthday", "Girl", LocalDate.now(), "bdaygrl@localhost.com");

    final Person p2 = new Person("Birthday", "Boy", LocalDate.now(), "bdayboy@localhost.com");

    @Override
    public Stream<Person> findByBirthday(LocalDate localDate) {
        return Stream.of(p1, p2);
    }
}
