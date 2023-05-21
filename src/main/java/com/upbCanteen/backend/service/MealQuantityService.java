package com.upbCanteen.backend.service;

import com.upbCanteen.backend.model.MealQuantity;
import com.upbCanteen.backend.repository.MealQuantityRepository;
import org.springframework.stereotype.Service;

@Service
public class MealQuantityService {
    private MealQuantityRepository mealQuantityRepository;

    public MealQuantityService(MealQuantityRepository mealQuantityRepository) {
        this.mealQuantityRepository = mealQuantityRepository;
    }

    public void save(MealQuantity mealQuantity) {
        mealQuantityRepository.save(mealQuantity);
    }

    public void delete(MealQuantity mealQuantity) {
        mealQuantityRepository.delete(mealQuantity);
    }
}
