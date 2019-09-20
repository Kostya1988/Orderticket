package test.orderticket.scheduled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import test.orderticket.model.TicketEntity;
import test.orderticket.service.TicketService;
import java.util.List;

public class SheduledFixedRate {
  @Autowired
    TicketService ticketService;
    @Scheduled(fixedRate = 60000)
    private void findByOrderStatus() {
        List<TicketEntity> start = ticketService.orderStatus("start");
        for (TicketEntity ticketEntity : start) {
            ticketEntity.setOrderStatus(ticketService.randomOrderStatus());
            ticketService.save(ticketEntity);
        }
    }
}
