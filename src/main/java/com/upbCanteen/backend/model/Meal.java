package com.upbCanteen.backend.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "meals")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name  = "meal_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "canteen_id")
    private Canteen canteen;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private Float quantity;

    @Column(name = "remain_quantity")
    private Long remainQuantity;

    @Column(name = "price")
    private Float price;

    @Column(name = "unit")
    private String unit;

    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy = "meal", cascade = CascadeType.PERSIST)
    private Set<MealQuantity> mealQuantities = new HashSet<>();

    public Meal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Canteen getCanteen() {
        return canteen;
    }

    public void setCanteen(Canteen canteen) {
        this.canteen = canteen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getRemainQuantity() {
        return remainQuantity;
    }

    public void setRemainQuantity(Long remainQuantity) {
        this.remainQuantity = remainQuantity;
    }

    public Set<MealQuantity> getMealQuantities() {
        return mealQuantities;
    }

    public void setMealQuantities(Set<MealQuantity> mealQuantities) {
        this.mealQuantities = mealQuantities;
    }
}