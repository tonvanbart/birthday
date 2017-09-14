package org.vanbart.birthday.adapters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.vanbart.birthday.core.EmployeeRepository;
import org.vanbart.birthday.core.Person;
import org.vanbart.birthday.util.Tuple;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.stream.Stream;

import static java.time.LocalDate.parse;

/**
 * @since 14/09/2017.
 */
@Component
@Profile("default")
public class CsvEmployeeRepository implements EmployeeRepository {

    private static final String FILENAME = "employees.csv";

    private static final Logger logger = LoggerFactory.getLogger(CsvEmployeeRepository.class);

    @Override
    public Stream<Person> findByBirthday(LocalDate localDate) {
        logger.trace("findByBirthday({})", localDate);
        URL resource = getClass().getClassLoader().getResource(FILENAME);

        if (resource == null) {
            logger.error("Failed to create URL from filename '{}'", FILENAME);
            return Stream.empty();
        }

        try {
            Path path = Paths.get(resource.toURI());
            return Files.readAllLines(path).stream()
                    .skip(1)
                    .map(line -> line.split(","))
                    .map(parts -> new Tuple<>(parts[0].trim(), parts[1].trim(),
                            parse(parts[2].trim()), parts[3].trim()))
                    .map(tuple -> new Person(tuple.t, tuple.u, tuple.v, tuple.w))
                    .filter(person -> person.birthday.equals(localDate));

        } catch (URISyntaxException e) {
            logger.error("Failed to resolve '{}'", FILENAME, e);
            return Stream.empty();
        } catch (IOException e) {
            logger.error("Failed to read '{}'", FILENAME, e);
            return Stream.empty();
        }
    }
}
