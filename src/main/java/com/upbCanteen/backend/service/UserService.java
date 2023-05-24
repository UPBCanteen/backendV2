package com.upbCanteen.backend.service;

import com.upbCanteen.backend.model.User;
import com.upbCanteen.backend.projection.UserView;
import com.upbCanteen.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }


    public List<UserView> getUsersForAdmin(){
        return userRepository.findAllBy();
    }

    public boolean isPresent(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public User getUserByEmail(String email){
        if(isPresent(email))
            return userRepository.findByEmail(email).get();
        else
            return null;
    }

    public Long getUserNr(){
        return userRepository.countUserBy();
    }
}
