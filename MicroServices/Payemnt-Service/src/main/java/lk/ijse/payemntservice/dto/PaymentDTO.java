package lk.ijse.payemntservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version: v0.0.1
 * @author: Navishka
 * @date: 7/4/2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    private Long id;
    private String paymentId;
    private String paymentType;
    private Double paymentAmount;
    private String paymentTime;
    private String paymentStatus;
    private String paymentLocation;
    private Long ticketId;
}
