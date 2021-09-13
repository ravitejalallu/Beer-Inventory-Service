package com.ravi.springframwork.BeerInventoryService.service;

import com.ravi.springframwork.BeerInventoryService.domain.BeerInventory;
import com.ravi.springframwork.BeerInventoryService.web.mapper.BeerInventoryMapper;
import com.ravi.springframwork.BeerInventoryService.web.model.BeerInventoryDto;
import com.ravi.springframwork.BeerInventoryService.repository.BeerInventoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BeerInventoryServiceImpl implements BeerInventoryService{

   private final BeerInventoryRepository beerInventoryRepository;

    public BeerInventoryServiceImpl(BeerInventoryRepository beerInventoryRepository) {
        this.beerInventoryRepository = beerInventoryRepository;
    }


    @Override
    public BeerInventoryDto findBeerById(UUID beerId) {
        Optional<BeerInventory> beer = beerInventoryRepository.findBeerByBeerId(beerId);
        log.info("BeerId "+beer.get().getBeerId());
        return BeerInventoryMapper.beerInventoryToBeerInventoryDto(beer.get());


    }

    @Override
    public List<BeerInventoryDto> findBeers() {
        return beerInventoryRepository.findAll()
                .stream()
                .map(BeerInventoryMapper::beerInventoryToBeerInventoryDto)
                .collect(Collectors.toList());
    }
}
