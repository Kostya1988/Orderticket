package test.orderticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling

public class TicketDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketDemoApplication.class);
    }
}