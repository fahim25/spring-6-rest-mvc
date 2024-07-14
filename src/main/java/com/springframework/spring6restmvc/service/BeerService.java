package com.springframework.spring6restmvc.service;

import com.springframework.spring6restmvc.model.BeerDTO;
import com.springframework.spring6restmvc.model.BeerStyle;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BeerService {

//    List<BeerDTO> listBeers();
//     List<BeerDTO> listBeers(String beerName);
     List<BeerDTO> listBeers(String beerName,  BeerStyle beerStyle, Boolean showInventory);

    Optional <BeerDTO> getBeerById(UUID id);

    BeerDTO saveNewBeer(BeerDTO beerDTO);

//    void updateBeerById(UUID beerId, BeerDTO beerDTO);

    Optional<BeerDTO> updateBeerById(UUID beerId, BeerDTO beer);

//    void deleteById(UUID beerId);


    Boolean deleteById(UUID beerId);
    void patchBeerById(UUID beerId, BeerDTO beerDTO);
}
