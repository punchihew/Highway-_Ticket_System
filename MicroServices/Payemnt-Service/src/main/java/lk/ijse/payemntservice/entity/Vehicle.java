package lk.ijse.payemntservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @version: v0.0.1
 * @author: Navishka
 * @date: 7/4/2024
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String vehicleId;
    private String vehicleType;
    private String vehicleBrand;
    private String vehicleModel;
    private String vehicleYear;
    private String vehicleColor;
    private String vehicleFuelType;
    private String vehicleTransmissionType;
    private String vehicleEngineCapacity;
    private String vehicleMileage;
    private String vehiclePrice;
    private String vehicleStatus;
    private String vehicleLocation;
    private String vehicleDate;
    private String vehicleTime;

    @OneToMany(mappedBy = "vehicle")
    private List<Ticket> tickets;
}
