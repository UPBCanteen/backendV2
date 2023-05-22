package com.upbCanteen.backend.dto.convertor;

import com.upbCanteen.backend.dto.MealDTO;
import com.upbCanteen.backend.model.Meal;
import org.modelmapper.ModelMapper;

import java.text.ParseException;

public class MealConvertor {
    private static ModelMapper modelMapper;

    public static Meal convertToEntity(MealDTO mealDTO) throws ParseException {
        return modelMapper.map(mealDTO, Meal.class);
    }

    public static MealDTO convertToDto(Meal meal){
        return modelMapper.map(meal, MealDTO.class);
    }
}
