package main;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import request.DealDoneRequest;
import request.DealRequest;
import response.Deal;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DealController {

    @GetMapping("/deals/")
    public List<Deal> gelAll(){
        return Storage.getAllDeals();
    }

    @GetMapping("/deals/{id}")
    public ResponseEntity get(@PathVariable int id){
        Deal deal = Storage.getDeal(id);
        if (deal == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(deal);
    }

    @PostMapping("/deals/")
    public int add(Deal deal){
        return Storage.addDeal(deal);
    }

    @PostMapping("/deals/{id}")
    public ResponseEntity addId(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(null);
    }

    @DeleteMapping("/deals/")
    public ResponseEntity delAll(){
        if (Storage.getAllDeals().size() != 0){
            Storage.delAllDeal();
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/deals/{id}")
    public ResponseEntity del(@PathVariable int id){
        Deal deal = Storage.getDeal(id);
        if (deal == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Storage.delDeal(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PutMapping("/deals/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDeal(
            @Valid @RequestBody DealRequest request,
            @PathVariable int id
    ) {
        Storage.updateDeal(id, request.number, request.name, request.done);
    }

    @PutMapping("/deals/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAllDeal(
            @Valid @RequestBody DealDoneRequest request
    ) {
        Storage.updateAllDeal(Boolean.valueOf(request.done));
    }
}
