package org.vanbart.birthday.core;

import java.time.LocalDate;
import java.util.stream.Stream;

/**
 * @since 08/09/2017.
 */
public interface EmployeeRepository {

    Stream<Person> findByBirthday(LocalDate localDate);

}
