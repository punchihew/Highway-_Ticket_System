package lk.ijse.ticketservice.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

/**
 * @version: v0.0.1
 * @author: Navishka
 * @date: 7/2/2024
 */

public class ResponseDTO {
    private int status;
    private String message;
    private HashMap<String, Object> data = new HashMap<>();


}