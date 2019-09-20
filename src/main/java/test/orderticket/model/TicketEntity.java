package test.orderticket.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.RandomStringUtils;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "test2")
@Getter
@Setter
@ToString
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "route_number")
    @NonNull
    private String routeNumber = RandomStringUtils.randomAlphanumeric(10);
    @Column(name = "order_status")
    @NonNull
    private String orderStatus;
    @Column(name = "date")
    @NonNull
    private Date date;
    @Column(name = "time")
    @NonNull
    private Time time;
    @Column(name = "reference")
    @NonNull
    private String reference = RandomStringUtils.randomAlphanumeric(10);
}


