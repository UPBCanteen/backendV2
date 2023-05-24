package com.upbCanteen.backend.dto;

import com.upbCanteen.backend.model.Canteen;
import com.upbCanteen.backend.model.Meal;
import com.upbCanteen.backend.projection.MealView;

public class MealDTO {
    private String name;
    private Long quantity;
    private Long price;
    private String unit;
    private String image;

    public MealDTO(String name, Long quantity, Long price, String unit, String image) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.unit = unit;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
