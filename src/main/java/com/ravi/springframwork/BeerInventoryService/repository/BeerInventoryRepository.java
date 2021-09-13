package com.ravi.springframwork.BeerInventoryService.repository;

import com.ravi.springframwork.BeerInventoryService.domain.BeerInventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BeerInventoryRepository extends JpaRepository<BeerInventory, UUID> {
    Optional<BeerInventory> findBeerByBeerId(UUID beerId);

}
