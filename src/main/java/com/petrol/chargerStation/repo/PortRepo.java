package com.petrol.chargerStation.repo;

import com.petrol.chargerStation.entity.PortEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortRepo extends JpaRepository<PortEntity,Integer> {
}
