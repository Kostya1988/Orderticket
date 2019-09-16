package test.orderticket.service;


import test.orderticket.model.ReturnReference;
import test.orderticket.model.TicketEntity;

import java.util.List;


public interface TicketService {

   void save(TicketEntity ticket);

   List<TicketEntity> orderStatus(String orderStatus);
   TicketEntity findByReference(String routeNumber);

}
