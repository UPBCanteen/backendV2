package com.upbCanteen.backend.controller;

import com.upbCanteen.backend.dto.MealCanteenDTO;
import com.upbCanteen.backend.dto.MealDTO;
import com.upbCanteen.backend.dto.convertor.MealConvertor;
import com.upbCanteen.backend.model.Canteen;
import com.upbCanteen.backend.model.Meal;
import com.upbCanteen.backend.projection.CanteenAdminView;
import com.upbCanteen.backend.projection.MealCanteenView;
import com.upbCanteen.backend.projection.MealView;
import com.upbCanteen.backend.service.CanteenService;
import com.upbCanteen.backend.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.SchemaOutputResolver;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/meal")
public class MealController {

    @Autowired
    private MealService mealService;
    @Autowired
    private CanteenService canteenService;

    @PostMapping(path = "/add")
    public ResponseEntity<Meal> save(@RequestBody MealCanteenDTO mealCanteenDTO) throws ParseException {
        System.out.println(mealCanteenDTO.getMealDTO().toString());
        System.out.println(mealCanteenDTO.getCanteenId());
        Optional<Canteen> canteen = canteenService.findById(mealCanteenDTO.getCanteenId());
        Meal meal = MealConvertor.convertToEntity(mealCanteenDTO.getMealDTO());
        System.out.println(meal.toString());
        canteen.ifPresent(meal::setCanteen);
        mealService.save(meal);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/get-by-canteen-id/{canteen_id}")
    public List<MealCanteenView> getAllByCanteenId(@PathVariable Long canteen_id) {
        System.out.println(canteen_id);
        Optional<Canteen> canteen = canteenService.findById(canteen_id);
        return canteen.map(value -> mealService.findAllByCanteen(value)).orElse(null);
    }

    @PutMapping(path = "/edit")
    @ResponseStatus(HttpStatus.OK)
    public void updateMeal(@RequestBody Meal meal) throws ParseException {
        System.out.println(meal.getId());
        mealService.save(meal);
    }
}
