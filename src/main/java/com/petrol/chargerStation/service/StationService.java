package com.petrol.chargerStation.service;

import com.petrol.chargerStation.entity.StationEntity;
import com.petrol.chargerStation.entity.dto.ChargerStatusResponse;

import java.util.List;

public interface StationService {
//    public List<Integer> findAllStationForLocaion(String location);
//
//    List<ChargerStatusResponse> getAllPortStatusForLocation(String locationName);
    public StationEntity saveStation(StationEntity station);
    public List<ChargerStatusResponse> listOfPortsWithStatusOfLocation(String location);
}
