package com.ravi.springframwork.BeerInventoryService.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class BeerInventory extends BaseEntity{

    @Builder
    public BeerInventory(UUID id, Long version,
                         Timestamp createdDate,
                         Timestamp modifiedDate,
                         UUID beerId,
                         String upc, String beerName,
                         BeerStyleEnum beerStyle,
                         Integer quantityOnHand) {
        super(id, version, createdDate, modifiedDate);
        this.beerId = beerId;
        this.upc = upc;
        this.beerName = beerName;
        this.beerStyle = beerStyle;
        this.quantityOnHand = quantityOnHand;
    }

    @Column(length = 36, columnDefinition = "varchar(36)")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID beerId;
    private String upc;
    private String beerName;
    @Enumerated(EnumType.STRING)
    private BeerStyleEnum beerStyle;
    private Integer quantityOnHand;



}
