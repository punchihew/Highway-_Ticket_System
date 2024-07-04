package lk.ijse.ticketway.vehicleservice.service.impl;

import lk.ijse.ticketway.vehicleservice.dto.VehicleDTO;
import lk.ijse.ticketway.vehicleservice.entity.Vehicle;
import lk.ijse.ticketway.vehicleservice.repository.VehicleRepository;
import lk.ijse.ticketway.vehicleservice.service.VehicleService;
import lk.ijse.ticketway.vehicleservice.util.ResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

/**
 * @version: v0.0.1
 * @author: Navishka
 * @date: 7/4/2024
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final ModelMapper mapper;

    private final Logger logger = Logger.getLogger(VehicleServiceImpl.class.getName());

    public VehicleServiceImpl(VehicleRepository vehicleRepository, ModelMapper mapper) {
        this.vehicleRepository = vehicleRepository;
        this.mapper = mapper;
    }

    @Override
    public ResponseDTO registerVehicle(VehicleDTO vehicleDTO) {
        try {
            vehicleRepository.save(mapper.map(vehicleDTO, Vehicle.class));
            logger.info("Vehicle Registered Successfully");
            return new ResponseDTO("Vehicle Registered Successfully", 200);
        } catch (Exception e) {
            logger.severe(e.getMessage());
            return new ResponseDTO(e.getMessage(), 500);
        }
    }

    @Override
    public ResponseDTO updateVehicle(VehicleDTO vehicleDTO) {
        try {
            vehicleRepository.save(mapper.map(vehicleDTO, Vehicle.class));
            logger.info("Vehicle Updated Successfully");
            return new ResponseDTO("Vehicle Updated Successfully", 200);
        } catch (Exception e) {
            logger.severe(e.getMessage());
            return new ResponseDTO(e.getMessage(), 500);
        }
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return vehicleRepository.findAll().stream().map(vehicle -> mapper.map(vehicle, VehicleDTO.class)).toList();
    }

    @Override
    public ResponseDTO getVehicle(String id) {
        try {
            Vehicle vehicle = vehicleRepository.findByVehicleNumber(id);
            HashMap<String, Object> objectObjectHashMap = new HashMap<>();
            VehicleDTO map = mapper.map(vehicle, VehicleDTO.class);
            objectObjectHashMap.put("vehicle", map);
            logger.info("Vehicle Fetch Successfully");
            return new ResponseDTO(200,"Vehicle Fetch Successfully" , objectObjectHashMap);
        } catch (Exception e) {
            logger.severe(e.getMessage());
            return new ResponseDTO(e.getMessage(), 500);
        }
    }
}