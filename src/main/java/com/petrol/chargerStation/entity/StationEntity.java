package com.petrol.chargerStation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer stationId;
    private String StationName;
    private String locationName;
    private String power;
    private String createdBy;
    private String updatedBy;
    private String createdAt;
    private String updatedAt;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "station_id")
    private List<PortEntity> ports;

}
