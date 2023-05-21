package com.upbCanteen.backend.repository;

import com.upbCanteen.backend.model.MealQuantity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealQuantityRepository extends JpaRepository<MealQuantity, Long> {
}
