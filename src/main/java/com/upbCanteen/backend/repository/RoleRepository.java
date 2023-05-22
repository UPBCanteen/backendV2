package com.upbCanteen.backend.repository;

import com.upbCanteen.backend.model.ERole;
import com.upbCanteen.backend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(ERole name);
}
