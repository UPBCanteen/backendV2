package com.upbCanteen.backend.repository;

import com.upbCanteen.backend.model.User;
import com.upbCanteen.backend.projection.UserBarView;
import com.upbCanteen.backend.projection.UserView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    List<UserView> findAllBy();

    Optional<User> findByEmail(String email);

    Long countUserBy();
    UserBarView findAllByEmail(String email);

}
