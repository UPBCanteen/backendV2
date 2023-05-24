package com.upbCanteen.backend.controller;

import com.upbCanteen.backend.model.Meal;
import com.upbCanteen.backend.model.MealQuantity;
import com.upbCanteen.backend.model.Order;
import com.upbCanteen.backend.model.User;
import com.upbCanteen.backend.projection.OrderView;
import com.upbCanteen.backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private MealService mealService;
    @Autowired
    private MealQuantityService mealQuantityService;
    @Autowired
    private CanteenService canteenService;


    @GetMapping(path = "getAll")
    public List<OrderView> getAll(){
        return orderService.getAllOrders();
    }

    @PostMapping(path = "newOrder/{id}/{time}/{canteenId}")
    public void addNewOrder(@PathVariable Long id, @PathVariable String time, @PathVariable Long canteenId){
        User user =  userService.getUserByEmail(userService.getCurrentUserEmail());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        Optional<Order> order = orderService.findByTimeAndUser(date, user);
        Meal meal = mealService.getMealById(id);
        MealQuantity mealQuantity = new MealQuantity();
        mealQuantity.setMeal(meal);

        mealQuantity.setQuantity(1L);

        if(order.isPresent()){
            mealQuantity.setOrder(order.get());
            order.get().getMealQuantities().add(mealQuantity);
            order.get().setMealQuantities(order.get().getMealQuantities());
        } else {
            Order orderNew = new Order();
            orderNew.setUser(user);
            orderNew.setCanteen(canteenService.findById(canteenId).orElse(null));
            orderNew.setTime(date);
            orderNew.getMealQuantities().add(mealQuantity);
            orderNew.setMealQuantities(orderNew.getMealQuantities());
            orderService.save(orderNew);
            mealQuantity.setOrder(orderNew);
        }
        mealQuantityService.save(mealQuantity);

    }
}
