package lk.ijse.ticketservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @version: v0.0.1
 * @author: Navishka
 * @date: 7/2/2024
 */
@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final ModelMapper mapper;

    public TicketServiceImpl(TicketRepository ticketRepository, ModelMapper mapper) {
        this.ticketRepository = ticketRepository;
        this.mapper = mapper;
    }

    @Override
    public ResponseDTO save(TicketDTO ticketDTO) {
        ticketRepository.save(mapper.map(ticketDTO, Ticket.class));
        return new ResponseDTO("Ticket saved successfully", 200);
    }

    @Override
    public ResponseDTO update(TicketDTO ticketDTO) {
        ticketRepository.save(mapper.map(ticketDTO, Ticket.class));
        return new ResponseDTO("Ticket updated successfully", 200);
    }


}