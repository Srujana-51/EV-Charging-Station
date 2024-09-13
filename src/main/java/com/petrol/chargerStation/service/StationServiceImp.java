package com.petrol.chargerStation.service;

import com.petrol.chargerStation.constant.KafkaConstant;
import com.petrol.chargerStation.entity.PortEntity;
import com.petrol.chargerStation.entity.StationEntity;
import com.petrol.chargerStation.entity.dto.Charger;
import com.petrol.chargerStation.entity.dto.ChargerStatusResponse;
import com.petrol.chargerStation.repo.PortRepo;
import com.petrol.chargerStation.repo.StationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StationServiceImp implements StationService{
    @Autowired
    private RestTemplate restTemplate;

    String url="http://localhost:8083/port";
    @Autowired
    private StationRepo stationRepo;
    @Autowired
    private PortRepo portRepo;

    @Override
    public StationEntity saveStation(StationEntity station) {
        return stationRepo.save(station);
    }
    @Override
    public List<ChargerStatusResponse> listOfPortsWithStatusOfLocation(String location) {
        List<StationEntity> stationEntities = stationRepo.findAllByLocationName(location);
        List<ChargerStatusResponse> listOfChargerStatusResponses = new ArrayList<>();
        for (StationEntity chargerPorts : stationEntities) {
            ChargerStatusResponse chargerStatusResponse = new ChargerStatusResponse();
            chargerStatusResponse.setStationId(chargerPorts.getStationId());
            chargerStatusResponse.setStationName(chargerPorts.getStationName());
            chargerStatusResponse.setPorts((chargerPorts.getPorts()));
            listOfChargerStatusResponses.add(chargerStatusResponse);
        }
        return listOfChargerStatusResponses;
    }
    @KafkaListener(topics = KafkaConstant.STATUS_UPDATE_TOPIC, groupId = KafkaConstant.ID_FOR_CHARGERSTATION)
    public void listen(Charger charger) {
        Integer portId = charger.getPortId();
        Optional<PortEntity> optionalPort = portRepo.findById(portId);
        if(optionalPort.isPresent()){
            PortEntity port = optionalPort.get();
            port.setStatus(charger.getStatus());
            portRepo.save(port);
            System.out.println("Port status updated successfully");
        }
    }
    public List<StationEntity> listOfTotalStationWithLoacation(){
        List<StationEntity> stationEntities=new ArrayList<>();
        for(StationEntity stationEntity:stationRepo.findAll()) {
            StationEntity station = new StationEntity();
            station.setStationId(stationEntity.getStationId());
            station.setLocationName(stationEntity.getLocationName());
            station.setStationName(stationEntity.getStationName());
            station.setPorts(stationEntity.getPorts());
            stationEntities.add(station);
        }
        return stationEntities;
    }
}
