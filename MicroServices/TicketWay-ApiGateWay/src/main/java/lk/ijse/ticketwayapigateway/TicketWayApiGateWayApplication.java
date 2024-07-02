package lk.ijse.ticketwayapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TicketWayApiGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketWayApiGateWayApplication.class, args);
    }

}