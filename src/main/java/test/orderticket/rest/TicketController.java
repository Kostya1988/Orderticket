package test.orderticket.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;



import test.orderticket.Exception.MyResourceNotFoundException;
import test.orderticket.model.ReturnReference;
import test.orderticket.model.TicketEntity;
import test.orderticket.service.TicketService;

import javax.validation.Valid;

import java.util.List;
import java.util.Random;

@RestController

@RequestMapping("/applicationcreation/")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "{reference}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public ResponseEntity<ReturnReference> getReference(@PathVariable("reference") String reference) {

        TicketEntity ticketEntity = ticketService.findByReference(reference);
        if(ticketEntity==null){
            throw new MyResourceNotFoundException( "Element Not Found");
        }
        ReturnReference returnReference = new ReturnReference(ticketEntity.getReference(), ticketEntity.getOrderStatus());

        return new ResponseEntity<>(returnReference, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<TicketEntity> findByRouteNumber(@RequestBody @Valid TicketEntity ticket) {
        ticket.setOrderStatus("start");
        ticketService.save(ticket);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    @Scheduled(fixedRate = 60000)
    private void findByOrderStatus() {
        List<TicketEntity> start = ticketService.orderStatus("start");
        for (TicketEntity ticket : start) {
            ticket.setOrderStatus(randomOrderStatus());
            ticketService.save(ticket);
        }
    }

    private String randomOrderStatus() {
        String[] status = {"proceed", "error", "held"};
        int index = new Random().nextInt(status.length);
        return status[index];
    }
}










