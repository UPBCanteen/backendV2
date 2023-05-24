package com.upbCanteen.backend.dto.convertor;


import com.upbCanteen.backend.dto.UserDTO;
import com.upbCanteen.backend.dto.UserLoginDTO;
import com.upbCanteen.backend.model.User;
import com.upbCanteen.backend.repository.UserRepository;
import org.modelmapper.ModelMapper;

import javax.swing.text.html.Option;
import java.text.ParseException;
import java.util.Optional;

public class UserConvertor {
    private static ModelMapper modelMapper;
    private static UserRepository userRepository;

    public static User convertToEntity(UserDTO userDTO) throws ParseException {
        return modelMapper.map(userDTO, User.class);
    }

    public static UserDTO convertToDto(User user){
        return modelMapper.map(user, UserDTO.class);
    }

    public static User convertUserLoginToEntity(UserLoginDTO userLoginDTO) throws ParseException{
        Optional<User> userOption = userRepository.findByEmail(userLoginDTO.getEmail());
        return userOption.orElse(null);
    }
}
