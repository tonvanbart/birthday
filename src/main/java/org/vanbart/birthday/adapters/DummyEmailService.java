package org.vanbart.birthday.adapters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.vanbart.birthday.core.EmailService;
import org.vanbart.birthday.core.Person;

/**
 * @since 14/09/2017.
 */
@Component
public class DummyEmailService implements EmailService {

    private static final Logger logger = LoggerFactory.getLogger(DummyEmailService.class);

    @Override
    public void sendBirthdayWish(Person person) {
        logger.debug("Send greeting to {} {}, born on {}", person.firstName, person.lastName, person.birthday);

    }
}
