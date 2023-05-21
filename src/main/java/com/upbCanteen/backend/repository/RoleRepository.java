package com.upbCanteen.backend.repository;

import com.upbCanteen.backend.model.ERole;
import com.upbCanteen.backend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
