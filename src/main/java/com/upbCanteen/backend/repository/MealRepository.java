package com.upbCanteen.backend.repository;

import com.upbCanteen.backend.model.Canteen;
import com.upbCanteen.backend.model.Meal;
import com.upbCanteen.backend.projection.MealView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {
    List<MealView> findAllByCanteen(Canteen canteen);
}
