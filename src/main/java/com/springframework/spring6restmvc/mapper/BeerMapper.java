package com.springframework.spring6restmvc.mapper;


import com.springframework.spring6restmvc.entities.Beer;
import com.springframework.spring6restmvc.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    Beer beerDtoToBeer(BeerDTO dto);

    BeerDTO beerToBeerDto(Beer beer);
}
