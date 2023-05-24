package com.upbCanteen.backend.projection;

import com.upbCanteen.backend.model.Canteen;

public interface MealCanteenView {
    Long getId();
    String getName();
    Long getQuantity();
    Long getPrice();
    String getUnit();
    String getImage();
    Long getRemainQuantity();
}
