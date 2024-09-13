package com.petrol.chargerStation.entity.dto;
import com.petrol.chargerStation.entity.PortEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChargerStatusResponse {
    private Integer stationId;
    private String stationName;
    private List<PortEntity> ports;
}
