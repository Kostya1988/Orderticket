package test.orderticket.service;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.orderticket.model.TicketEntity;
import test.orderticket.repository.TicketRepository;

import java.util.List;
import java.util.Random;


@Slf4j
@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketRepository ticketRepository;

    @Override
    public void save(TicketEntity ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    public String randomOrderStatus() {
        String[] status = {"Failed", "Error", "Final"};
        int index = new Random().nextInt(status.length);
        return status[index];
    }

    @Override
    public List<TicketEntity> orderStatus(String orderStatus) {
        return ticketRepository.findByOrderStatus(orderStatus);
    }

    @Override
    public TicketEntity findByReference(String routeNumber) {
        return ticketRepository.findByReference(routeNumber);
    }
}















