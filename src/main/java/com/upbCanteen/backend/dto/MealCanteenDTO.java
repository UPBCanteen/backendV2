package com.upbCanteen.backend.dto;

public class MealCanteenDTO {
    private Long canteenId;
    private MealDTO mealDTO;


    public MealCanteenDTO(Long canteenId, MealDTO mealDTO) {
        this.canteenId = canteenId;
        this.mealDTO = mealDTO;
    }

    public Long getCanteenId() {
        return canteenId;
    }

    public void setCanteenId(Long canteenId) {
        this.canteenId = canteenId;
    }

    public MealDTO getMealDTO() {
        return mealDTO;
    }

    public void setMealDTO(MealDTO mealDTO) {
        this.mealDTO = mealDTO;
    }
}
