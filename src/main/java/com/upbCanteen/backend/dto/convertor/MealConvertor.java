package com.upbCanteen.backend.dto.convertor;

import com.upbCanteen.backend.dto.MealDTO;
import com.upbCanteen.backend.model.Meal;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;

@AllArgsConstructor
public class MealConvertor {
    private static  ModelMapper modelMapper = new ModelMapper();

    public static Meal convertToEntity(MealDTO mealDTO) throws ParseException {
        return  modelMapper.map(mealDTO, Meal.class);
    }

    public static  MealDTO convertToDto(Meal meal){
        return modelMapper.map(meal, MealDTO.class);
    }
}
