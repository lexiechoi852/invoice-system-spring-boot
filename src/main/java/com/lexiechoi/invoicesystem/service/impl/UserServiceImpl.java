package com.lexiechoi.invoicesystem.service.impl;

import com.lexiechoi.invoicesystem.domain.User;
import com.lexiechoi.invoicesystem.dto.UserDTO;
import com.lexiechoi.invoicesystem.dtomapper.UserDTOMapper;
import com.lexiechoi.invoicesystem.repository.UserRepository;
import com.lexiechoi.invoicesystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository<User> userRepository;

    @Override
    public UserDTO createUser(User user) {
        return UserDTOMapper.fromUser(userRepository.create(user));
    }
}
