package com.springframework.spring6restmvc.controller;

import com.springframework.spring6restmvc.model.BeerDTO;
import com.springframework.spring6restmvc.model.BeerStyle;
import com.springframework.spring6restmvc.service.BeerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
//@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    public static final String BEER_PATH = "/api/v1/beer";
    public static final String BEER_PATH_ID = BEER_PATH + "/{beerId}";



    @PatchMapping(BEER_PATH_ID)
    public ResponseEntity updateBeerPatchById(@PathVariable("beerId")UUID beerId, @RequestBody BeerDTO beerDTO){

        beerService.patchBeerById(beerId, beerDTO);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @DeleteMapping(BEER_PATH_ID)
    public ResponseEntity deleteById(@PathVariable("beerId") UUID beerId){

//        beerService.deleteById(beerId);

        if(! beerService.deleteById(beerId)){
            throw new NotFoundException();
        }


        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping(BEER_PATH_ID)
    public ResponseEntity updateById(@PathVariable("beerId")UUID beerId, @RequestBody BeerDTO beer){

//        beerService.updateBeerById(beerId, beerDTO);

        if( beerService.updateBeerById(beerId, beer).isEmpty()){
            throw new NotFoundException();
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }




//    @PostMapping(BEER_PATH)
    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping(BEER_PATH)
    public ResponseEntity handlePost(@Validated @RequestBody BeerDTO beer){

        BeerDTO savedBeer = beerService.saveNewBeer(beer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", BEER_PATH + "/" + savedBeer.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

//    @RequestMapping("/api/v1/beer")
//    @GetMapping(value = BEER_PATH)
//    public List<BeerDTO> listBeers(){
//        return beerService.listBeers();
//    }


//    @GetMapping(value = BEER_PATH)
//    public List<BeerDTO> listBeers(@RequestParam(required = false) String beerName,
//                                   @RequestParam(required = false) BeerStyle beerStyle,
//                                   @RequestParam(required = false) Boolean showInventory){
//        return beerService.listBeers(beerName, beerStyle, showInventory);
//    }

    @GetMapping(value = BEER_PATH)
    public Page<BeerDTO> listBeers(@RequestParam(required = false) String beerName,
                                   @RequestParam(required = false) BeerStyle beerStyle,
                                   @RequestParam(required = false) Boolean showInventory,
                                   @RequestParam(required = false) Integer pageNumber,
                                   @RequestParam(required = false) Integer pageSize){
        return beerService.listBeers(beerName, beerStyle, showInventory, pageNumber, pageSize);
    }

//    @GetMapping(value = BEER_PATH)
//    public List<BeerDTO> listBeers(@RequestParam(required = false) String beerName){
//        return beerService.listBeers(beerName);
//    }

//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity handleNotFoundException(){
//
//        System.out.println("Running Nt Found Exception");
//
//        return ResponseEntity.notFound().build();
//    }


    @GetMapping(value = BEER_PATH_ID)
    public BeerDTO getBeerById(@PathVariable("beerId") UUID beerId){

        log.debug("Get Beer by Id - in controller");

//        return beerService.getBeerById(beerId);

        return beerService.getBeerById(beerId).orElseThrow(NotFoundException::new);
    }




}
