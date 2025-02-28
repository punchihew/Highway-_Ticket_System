package lk.ijse.ticketservice.service;

import lk.ijse.ticketservice.dto.TicketDTO;
import lk.ijse.ticketservice.util.ResponseDTO;

/**
 * @version: v0.0.1
 * @author: Navishka
 * @date: 7/2/2024
 */
public interface TicketService {
    ResponseDTO save(TicketDTO ticketDTO);

    ResponseDTO update(TicketDTO ticketDTO);

    ResponseDTO getAll();

    ResponseDTO getTicket(Long id);
}
