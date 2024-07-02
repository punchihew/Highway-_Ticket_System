package lk.ijse.ticketservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version: v0.0.1
 * @author: Navishka
 * @date: 7/2/2024
 */

public class TicketDTO {
    private Long id;
    private String ticketId;
    private String ticketType;
    private String ticketPrice;
    private String ticketQty;
    private String ticketDate;
    private String ticketTime;
    private String ticketStatus;
    private String ticketLocation;
}
