package com.upbCanteen.backend.service;

import com.upbCanteen.backend.model.Canteen;
import com.upbCanteen.backend.model.Meal;
import com.upbCanteen.backend.projection.CanteenAdminView;
import com.upbCanteen.backend.projection.MealCanteenView;
import com.upbCanteen.backend.projection.MealView;
import com.upbCanteen.backend.repository.MealRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    private MealRepository mealRepository;

    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public void save(Meal meal) {
        mealRepository.save(meal);
    }

    public void delete(Meal meal) {
        mealRepository.delete(meal);
    }

    public List<MealCanteenView> findAllByCanteen(Canteen canteen) {
        return mealRepository.findAllByCanteen(canteen);
    }

    public Meal getMealById(Long id){
        return mealRepository.findById(id).orElse(null);
    }
}
