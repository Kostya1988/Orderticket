package test.orderticket.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import test.orderticket.model.TicketEntity;

import java.util.List;


public interface TicketRepository extends JpaRepository<TicketEntity, Long> {


    List<TicketEntity> findByOrderStatus(String orderStatus);

    TicketEntity findByReference(String routeNumber);


}


