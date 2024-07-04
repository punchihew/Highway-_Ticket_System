package lk.ijse.payemntservice.service;

import lk.ijse.payemntservice.dto.PaymentDTO;
import lk.ijse.payemntservice.util.ResponseDTO;

/**
 * @version: v0.0.1
 * @author: Navishka
 * @date: 7/4/2024
 */
public interface PaymentService {
    ResponseDTO add(PaymentDTO paymentDTO);

    ResponseDTO update(PaymentDTO paymentDTO);
}
