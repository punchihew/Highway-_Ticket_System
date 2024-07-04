package lk.ijse.ticketservice.service.impl;

import lk.ijse.ticketservice.dto.TicketDTO;
import lk.ijse.ticketservice.entity.Ticket;
import lk.ijse.ticketservice.repository.TicketRepository;
import lk.ijse.ticketservice.service.TicketService;
import lk.ijse.ticketservice.util.ResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

/**
 * @version: v0.0.1
 * @author: Navishka
 * @date: 7/2/2024
 */
@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final ModelMapper mapper;

    private final RestTemplate restTemplate;

    private final Logger logger = Logger.getLogger(TicketServiceImpl.class.getName());

    public TicketServiceImpl(TicketRepository ticketRepository, ModelMapper mapper, RestTemplate restTemplate) {
        this.ticketRepository = ticketRepository;
        this.mapper = mapper;
        this.restTemplate = restTemplate;
    }

    @Override
    @Transactional
    public ResponseDTO save(TicketDTO ticketDTO) {
        Ticket map = mapper.map(ticketDTO, Ticket.class);
        ResponseDTO forObject = restTemplate.getForObject("http://ticketway-user-service:8080/api/v1/users/actions/get-user/"+ticketDTO.getUserName(), ResponseDTO.class);
        assert forObject != null;
        forObject.getData().forEach((k, v) -> {
            if (k.equals("user")) {
                User user = mapper.map(v, User.class);
                map.setUser(user);
            }
        });

        ResponseDTO vehicle = restTemplate.getForObject("http://ticketway-vehicle-service:8080/api/v1/vehicle/actions/get-vehicle/"+ticketDTO.getVehicleNumber() , ResponseDTO.class);
        System.out.println(vehicle);
        assert vehicle != null;
        vehicle.getData().forEach((k, v) -> {
            if (k.equals("vehicle")) {
                System.out.println(v);
                map.setVehicle(mapper.map(v, Vehicle.class));
            }
        });

        ticketRepository.save(map);
        logger.info("Ticket Saved Successfully");
        return new ResponseDTO("Ticket saved successfully", 200);
    }

    @Override
    public ResponseDTO update(TicketDTO ticketDTO) {
        ticketRepository.save(mapper.map(ticketDTO, Ticket.class));
        logger.info("Ticket Updated Successfully");
        return new ResponseDTO("Ticket updated successfully", 200);
    }

    @Override
    public ResponseDTO getAll() {
        List<TicketDTO> all = ticketRepository.findAll().stream().map(ticket -> mapper.map(ticket, TicketDTO.class)).toList();
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("tickets", all);
        logger.info("Ticket Fetched Successfully");
        return new ResponseDTO(200, "Ticket fetched successfully", objectObjectHashMap);
    }

    @Override
    public ResponseDTO getTicket(Long id) {
        Ticket ticket = ticketRepository.findById(id).get();
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        TicketDTO map = mapper.map(ticket, TicketDTO.class);
        objectObjectHashMap.put("ticket", map);
        logger.info("Ticket Fetched Successfully");
        return new ResponseDTO(200, "Ticket fetched successfully", objectObjectHashMap);
    }
}
