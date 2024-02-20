package com.lexiechoi.invoicesystem.service;

import com.lexiechoi.invoicesystem.domain.User;
import com.lexiechoi.invoicesystem.dto.UserDTO;

public interface UserService {
    UserDTO createUser(User user);
}
