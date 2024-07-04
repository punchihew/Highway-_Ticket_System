package lk.ijse.payemntservice.service.impl;

import lk.ijse.payemntservice.dto.PaymentDTO;
import lk.ijse.payemntservice.entity.Payment;
import lk.ijse.payemntservice.repositoty.PaymentRepository;
import lk.ijse.payemntservice.service.PaymentService;
import lk.ijse.payemntservice.util.ResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

/**
 * @version: v0.0.1
 * @author: Navishka
 * @date: 7/4/2024
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;
    private final Logger logger = Logger.getLogger(PaymentServiceImpl.class.getName());

    public PaymentServiceImpl(PaymentRepository paymentRepository, ModelMapper modelMapper, RestTemplate restTemplate) {
        this.paymentRepository = paymentRepository;
        this.modelMapper = modelMapper;
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseDTO add(PaymentDTO paymentDTO) {
        Payment map = modelMapper.map(paymentDTO, Payment.class);
        ResponseDTO forObject = restTemplate.getForObject("http://ticketway-ticket-service:8080/api/v1/ticket/actions/get-ticket/" + paymentDTO.getTicketId(), ResponseDTO.class);
        assert forObject != null;
        forObject.getData().forEach((k, v) -> {
            if (k.equals("ticket")) {
                map.setTicket(modelMapper.map(v, Ticket.class));
            }
        });
        Payment save = paymentRepository.save(map);
        if (save != null) {
            logger.info("Payment Saved Successfully");
        } else {
            logger.severe("Error in Saving Payment");
        }
        return save != null ? new ResponseDTO("Success", 200) : new ResponseDTO("Error", 500);
    }

    @Override
    public ResponseDTO update(PaymentDTO paymentDTO) {
        Payment map = modelMapper.map(paymentDTO, Payment.class);
        ResponseDTO forObject = restTemplate.getForObject("http://ticketway-ticket-service:8080/api/v1/ticket/actions/get-ticket/" + paymentDTO.getTicketId(), ResponseDTO.class);
        assert forObject != null;
        forObject.getData().forEach((k, v) -> {
            if (k.equals("ticket")) {
                map.setTicket(modelMapper.map(v, Ticket.class));
            }
        });
        Payment save = paymentRepository.save(map);
        if (save != null) {
            logger.info("Payment Updated Successfully");
        } else {
            logger.severe("Error in Updating Payment");
        }
        return save != null ? new ResponseDTO("Success", 200) : new ResponseDTO("Error", 500);
    }
}
