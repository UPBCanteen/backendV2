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
    private Long quantity;

    @Column(name = "remain_quantity")
    private Long remain_quantity;

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

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getRemain_quantity() {
        return remain_quantity;
    }

    public void setRemain_quantity(Long remain_quantity) {
        this.remain_quantity = remain_quantity;
    }

    public Set<MealQuantity> getMealQuantities() {
        return mealQuantities;
    }

    public void setMealQuantities(Set<MealQuantity> mealQuantities) {
        this.mealQuantities = mealQuantities;
    }
}