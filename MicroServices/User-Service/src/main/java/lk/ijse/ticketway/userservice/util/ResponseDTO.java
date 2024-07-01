package lk.ijse.ticketway.userservice.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private int status;
    private String message;
    private HashMap<String, Object> data = new HashMap<>();

    public ResponseDTO(String message, int status) {
        this.message = message;
        this.status = status;
    }
}
