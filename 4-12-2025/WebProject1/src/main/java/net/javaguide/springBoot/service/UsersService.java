package net.javaguide.springBoot.service;

import java.util.List;
import net.javaguide.springBoot.entity.User;

public interface UsersService {
    User createUser(User user);
    User getUserById(Long userId);
    List<User> getAllUsers();
    User updateUser(User user);
    void deleteUser(Long userId);
}

