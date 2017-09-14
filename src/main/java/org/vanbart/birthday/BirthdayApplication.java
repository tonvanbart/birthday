package org.vanbart.birthday;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.vanbart.birthday.core.BirthdayService;
import org.vanbart.birthday.core.EmailService;
import org.vanbart.birthday.core.EmployeeRepository;

import java.time.LocalDate;

@SpringBootApplication
public class BirthdayApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(BirthdayApplication.class);

    @Autowired
    BirthdayService birthdayService;

	public static void main(String[] args) {
		SpringApplication.run(BirthdayApplication.class, args);
	}

//	@Bean
//    EmailService emailService() {
//	    return new EmailService() {
//        };
//    }
//
//    @Bean
//    EmployeeRepository employeeRepository() {
//	    return new EmployeeRepository() {
//        };
//    }

    @Override
    public void run(String... strings) throws Exception {
        logger.debug("run()");
        birthdayService.sendGreetings(LocalDate.now());
    }
}
