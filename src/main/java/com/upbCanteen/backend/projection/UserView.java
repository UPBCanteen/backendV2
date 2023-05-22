package com.upbCanteen.backend.projection;

import java.util.List;

public interface UserView {
    Long getId();
    String getUsername();
    RoleView getRole();
    String getEmail();
}
