package lk.ijse.ticketservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version: v0.0.1
 * @author: Navishka
 * @date: 7/2/2024
 */

public class WebAppConfig {

    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}