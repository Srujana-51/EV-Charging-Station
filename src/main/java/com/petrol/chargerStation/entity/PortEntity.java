package com.petrol.chargerStation.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PortEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer portId;
    private String portName;
    private String portPower;
    private String status;
    @ManyToOne(fetch = FetchType.LAZY)
    private StationEntity station;
}

