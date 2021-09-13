package com.ravi.springframwork.BeerInventoryService.bootstrap;

import com.ravi.springframwork.BeerInventoryService.domain.BeerInventory;
import com.ravi.springframwork.BeerInventoryService.domain.BeerStyleEnum;
import com.ravi.springframwork.BeerInventoryService.repository.BeerInventoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class BeerInventoryBootstrap implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";
    public static final UUID BEER_1_UUID = UUID.fromString("0a818933-087d-47f2-ad83-2f986ed087eb");
    public static final UUID BEER_2_UUID = UUID.fromString("a712d914-61ea-4623-8bd0-32c0f6545bfd");
    public static final UUID BEER_3_UUID = UUID.fromString("026cc3c8-3a0c-4083-a05b-e908048c1b08");

   private final BeerInventoryRepository beerInventoryRepository;

    public BeerInventoryBootstrap(BeerInventoryRepository beerInventoryRepository) {
        this.beerInventoryRepository = beerInventoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        beerInventoryRepository.save(BeerInventory.builder()
                .beerName("Mango bobs")
                .beerStyle(BeerStyleEnum.ALE)
                .beerId(BEER_1_UUID)
                .upc(BEER_1_UPC)
                .quantityOnHand(50)
                .build());
        beerInventoryRepository.save(BeerInventory.builder()
                .beerName("Banana bobs")
                .beerId(BEER_2_UUID)
                .beerStyle(BeerStyleEnum.PALE_ALE)
                .upc(BEER_2_UPC)
                .quantityOnHand(5)
                .build());
        beerInventoryRepository.save(BeerInventory.builder()
                .beerName("Apple bobs")
                .beerStyle(BeerStyleEnum.LAGER)
                .beerId(BEER_3_UUID)
                .upc(BEER_3_UPC)
                .quantityOnHand(100)
                .build());
   log.info("Total Size" + beerInventoryRepository.count());

    }
}
