package com.upbCanteen.backend.service;

import com.upbCanteen.backend.model.Meal;
import com.upbCanteen.backend.repository.MealRepository;
import org.springframework.stereotype.Service;

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
}
