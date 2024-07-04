package lk.ijse.payemntservice.controller;

import lk.ijse.payemntservice.dto.PaymentDTO;
import lk.ijse.payemntservice.service.PaymentService;
import lk.ijse.payemntservice.util.ResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version: v0.0.1
 * @author: Navishka
 * @date: 7/1/2024
 */

@RestController
@RequestMapping("/actions")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/validate")
    public ResponseDTO add(@RequestBody PaymentDTO paymentDTO) {
        try{
            return paymentService.add(paymentDTO);
        }catch (Exception e) {
            return new ResponseDTO("Error", 500);
        }
    }

    @PostMapping("/process")
    public ResponseDTO update(@RequestBody PaymentDTO paymentDTO) {
        try{
            return paymentService.update(paymentDTO);
        }catch (Exception e) {
            return new ResponseDTO("Error", 500);
        }
    }
}
