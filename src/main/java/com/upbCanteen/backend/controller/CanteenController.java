package com.upbCanteen.backend.controller;

import com.upbCanteen.backend.model.Canteen;
import com.upbCanteen.backend.service.CanteenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/canteen")
public class CanteenController {
    @Autowired
    private CanteenService canteenService;

    @PostMapping(path = "/add")
//    @CrossOrigin(origins = "http://localhost:8081")
    public ResponseEntity<Canteen> save(@RequestBody Canteen canteen){
        canteenService.save(canteen);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
