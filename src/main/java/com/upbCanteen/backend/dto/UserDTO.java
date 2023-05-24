package com.upbCanteen.backend.dto;

import com.upbCanteen.backend.model.Role;

public class UserDTO {
    private Long id;
    private Role role;
    private String email;
    private String password;

    public UserDTO(Long id, Role role, String email, String password) {
        this.id = id;
        this.role = role;
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
