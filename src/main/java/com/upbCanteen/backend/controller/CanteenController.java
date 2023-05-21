package com.upbCanteen.backend.controller;

import com.upbCanteen.backend.model.Canteen;
import com.upbCanteen.backend.projection.CanteenAdminView;
import com.upbCanteen.backend.service.CanteenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import net.minidev.json.JSONObject;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/canteen")
public class CanteenController {
    @Autowired
    private CanteenService canteenService;

    @PostMapping(path = "/add")
    public ResponseEntity<Canteen> save(@RequestBody Canteen canteen){
        canteenService.save(canteen);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public List<CanteenAdminView> getAllCafeteria(){
        return canteenService.findAll();
    }

    @PutMapping(path = "/edit")
    @ResponseStatus(HttpStatus.OK)
    public void updateCanteen(@RequestBody Canteen canteen) throws ParseException {
        canteenService.save(canteen);
    }

    @DeleteMapping(path = "/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCanteen(@PathVariable Long id) {
        Optional<Canteen> canteen = canteenService.findById(id);
        if (!canteen.isEmpty())
            canteenService.delete(id);
    }

}
