package com.upbCanteen.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserLoginDTO {
    private String email;
    private String password;


    public UserLoginDTO() {

    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
