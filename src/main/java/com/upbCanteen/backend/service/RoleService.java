package com.upbCanteen.backend.service;

import com.upbCanteen.backend.model.ERole;
import com.upbCanteen.backend.model.Role;
import com.upbCanteen.backend.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getRoleName(ERole name){
        return roleRepository.findByName(name);
    }
}
