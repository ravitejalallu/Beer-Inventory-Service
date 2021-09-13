package com.ravi.springframwork.BeerInventoryService.web.mapper;

import com.ravi.springframwork.BeerInventoryService.domain.BeerInventory;
import com.ravi.springframwork.BeerInventoryService.web.model.BeerInventoryDto;

import java.util.UUID;

public class BeerInventoryMapper {

    public static BeerInventoryDto beerInventoryToBeerInventoryDto(BeerInventory beerInventory){
        return BeerInventoryDto.builder()
                .id(beerInventory.getId())
                .beerId(beerInventory.getBeerId())
                .beerName(beerInventory.getBeerName())
                .beerStyle(beerInventory.getBeerStyle())
                .createdDate(DateMapper.asOffsetDateTime(beerInventory.getCreatedDate()))
                .lastModifiedDate(DateMapper.asOffsetDateTime(beerInventory.getCreatedDate()))
                .quantityOnHand(beerInventory.getQuantityOnHand())
                .upc(beerInventory.getUpc())
                .version(beerInventory.getVersion())
                .build();
    }

    public static BeerInventory beerInventoryDtoToBeerInventory(BeerInventoryDto beerInventoryDto){
        return BeerInventory.builder()
                .id(beerInventoryDto.getId())
                .beerName(beerInventoryDto.getBeerName())
                .beerStyle(beerInventoryDto.getBeerStyle())
                .beerId(beerInventoryDto.getBeerId())
                .createdDate(DateMapper.asTimestamp(beerInventoryDto.getCreatedDate()))
                .modifiedDate(DateMapper.asTimestamp(beerInventoryDto.getCreatedDate()))
                .quantityOnHand(beerInventoryDto.getQuantityOnHand())
                .upc(beerInventoryDto.getUpc())
                .version(beerInventoryDto.getVersion())
                .build();
    }


}
