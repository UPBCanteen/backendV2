package com.upbCanteen.backend.projection;


import com.upbCanteen.backend.projection.MealQuantityView;
import com.upbCanteen.backend.projection.MealView;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface OrderView {
    Long getId();
    Date getTime();

    List<MealQuantityView> getMealQuantities();
    UserView getUser();
}
