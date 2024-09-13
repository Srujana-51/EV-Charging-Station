package com.petrol.chargerStation.controller;
import com.petrol.chargerStation.entity.StationEntity;
import com.petrol.chargerStation.entity.dto.ChargerStatusResponse;
import com.petrol.chargerStation.service.StationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@RestController
@RequestMapping("/station")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StationController {
    String url = "http://localhost:8083/port";
    @Autowired
    private StationServiceImp stationServiceImp;
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/save")
    public StationEntity savePort(@RequestBody StationEntity station){

        return stationServiceImp.saveStation(station);
    }

    @GetMapping("/listOfPorts/{location}")
    public List<ChargerStatusResponse> listOfPortsWithStatusOfLocation(@PathVariable String location){
        return stationServiceImp.listOfPortsWithStatusOfLocation(location);
    }
    @GetMapping("/totalStations")
   public List<StationEntity> listOfTotalStationWithLoacation(){
        return stationServiceImp.listOfTotalStationWithLoacation();
    }

}
