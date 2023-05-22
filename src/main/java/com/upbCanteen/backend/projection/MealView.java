package com.upbCanteen.backend.projection;

import com.upbCanteen.backend.model.Canteen;

public interface MealView {
    Long getId();
    Canteen getCanteen();
    String getName();
    Long getQuantity();
    Long getPrice();
    String getUnit();
    String getImage();
    Long getRemainQuantity();
}
