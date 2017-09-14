package org.vanbart.birthday.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @since 08/09/2017.
 */
@Component
public class BirthdayService {

    private final EmployeeRepository employeeRepository;

    private final EmailService emailService;

    private static final Logger logger = LoggerFactory.getLogger(BirthdayService.class);

    @Autowired
    public BirthdayService(EmployeeRepository employeeRepository, EmailService emailService) {
        logger.debug("BirthdayService()");
        this.employeeRepository = employeeRepository;
        this.emailService = emailService;
    }

    public void sendGreetings(LocalDate localDate) {
        logger.debug("sendGreetings({})", localDate);
        employeeRepository.findByBirthday(localDate)
                .forEach(person -> emailService.sendBirthdayWish(person));
    }
}
