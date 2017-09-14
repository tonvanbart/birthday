## Birthday greetings kata

Spring Boot commandline implementation of the
[birthday greetings kata](http://matteo.vaccari.name/blog/archives/154)
(hexagonal architecture).

The project can be run from within your IDE, or from the commandline using the supplied Maven wrapper:

    ./mvnw spring-boot:run
     
To force greetings being sent, you can switch on the "today" profile which will 
always show 2 persons having their birthday on the current day.

    ./mvnw spring-boot:run -Dspring.profiles.active=today