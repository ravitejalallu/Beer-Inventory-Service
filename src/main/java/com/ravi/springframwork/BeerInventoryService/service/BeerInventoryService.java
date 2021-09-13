package com.ravi.springframwork.BeerInventoryService.service;

import com.ravi.springframwork.BeerInventoryService.web.model.BeerInventoryDto;

import java.util.List;
import java.util.UUID;

public interface BeerInventoryService {
    BeerInventoryDto findBeerById(UUID beerId);

    List<BeerInventoryDto> findBeers();
}
