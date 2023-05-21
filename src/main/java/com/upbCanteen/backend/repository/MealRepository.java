package com.upbCanteen.backend.repository;

import com.upbCanteen.backend.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {
}
