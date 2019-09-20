package test.orderticket.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.orderticket.exception.TicketException;
import test.orderticket.model.ReturnReference;
import test.orderticket.model.TicketEntity;
import test.orderticket.service.TicketService;
import javax.validation.Valid;

@RestController
@RequestMapping("/applicationcreation/")
public class TicketController {
    @Autowired
    private TicketService ticketService;
   @GetMapping(value = "{reference}")
       public ResponseEntity<ReturnReference> getReference(@PathVariable("reference") String reference) {
        TicketEntity ticketEntity = ticketService.findByReference(reference);
        if(ticketEntity==null){
            throw new TicketException.MyResourceNotFoundException( "Element Not Found");
        }
        ReturnReference returnReference = new ReturnReference(ticketEntity.getReference(), ticketEntity.getOrderStatus());
        return new ResponseEntity<>(returnReference, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<TicketEntity> findByRouteNumber(@RequestBody @Valid TicketEntity ticket) {
        ticket.setOrderStatus("start");
        ticketService.save(ticket);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }
}










