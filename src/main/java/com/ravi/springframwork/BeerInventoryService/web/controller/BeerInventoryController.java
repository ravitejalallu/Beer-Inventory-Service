package com.ravi.springframwork.BeerInventoryService.web.controller;

import com.ravi.springframwork.BeerInventoryService.web.model.BeerInventoryDto;
import com.ravi.springframwork.BeerInventoryService.service.BeerInventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerInventoryController {

    private final BeerInventoryService beerInventoryService;

    public BeerInventoryController(BeerInventoryService beerInventoryService) {
        this.beerInventoryService = beerInventoryService;
    }

    @GetMapping("/{beerId}/inventory")
    public ResponseEntity<BeerInventoryDto>listBeersById(@PathVariable("beerId")UUID beerId){
        return new ResponseEntity<BeerInventoryDto>(beerInventoryService.findBeerById(beerId), HttpStatus.OK);
    }
    @GetMapping("/inventory")
    public ResponseEntity<List<BeerInventoryDto>>listBeers(){
        return new ResponseEntity<List<BeerInventoryDto>>(beerInventoryService.findBeers(), HttpStatus.OK);
    }
}
