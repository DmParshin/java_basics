package main;

import main.model.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import request.DealDoneRequest;
import request.DealRequest;
import main.model.Deal;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DealController {

    @Autowired
    private DealRepository dealRepository;

    @GetMapping("/deals/")
    public List<Deal> gelAll(){
        Iterable<Deal> dealIterable = dealRepository.findAll();
        ArrayList<Deal> dealArrayList = new ArrayList<>();
        dealIterable.forEach(deal -> dealArrayList.add(deal));
        return dealArrayList;
    }

    @GetMapping("/deals/{id}")
    public ResponseEntity get(@PathVariable int id){
        Optional<Deal>optionalDeal = dealRepository.findById(id);
        if (!optionalDeal.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalDeal.get());
    }

    @PostMapping("/deals/")
    public int add(Deal deal){
        Deal newDeal = dealRepository.save(deal);
        return newDeal.getId();
    }

    @PostMapping("/deals/{id}")
    public ResponseEntity addId(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(null);
    }

    @DeleteMapping("/deals/")
    public ResponseEntity delAll(){
        Iterable<Deal> dealIterable = dealRepository.findAll();
        if (dealRepository.count() > 0){
            dealRepository.deleteAll();
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/deals/{id}")
    public ResponseEntity del(@PathVariable int id){
        Optional<Deal>optionalDeal = dealRepository.findById(id);
        if (!optionalDeal.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        dealRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PutMapping("/deals/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDeal(
            @Valid @RequestBody DealRequest request,
            @PathVariable int id
    ) {
        Deal deal = new Deal();
        deal.setId(id);
        deal.setNumber(request.number);
        deal.setName(request.name);
        deal.setDone(request.done);
        dealRepository.save(deal);
    }

    @PutMapping("/deals/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAllDeal(
            @Valid @RequestBody DealDoneRequest request
    ) {
        Iterable<Deal> dealIterable = dealRepository.findAll();
        for(Deal deal : dealIterable){
            deal.setDone(request.done);
            dealRepository.save(deal);
        }
    }
}
