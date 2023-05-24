package com.upbCanteen.backend.projection;



public interface MealQuantityView {
     Long getId();

    MealWithoutCanteen getMeal();

    Long getQuantity();
}
