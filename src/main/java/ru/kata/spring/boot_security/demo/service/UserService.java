package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService{
    List<User> allUsers();
    void addUser(User user);
    void deleteUser(Long id);
    User editUser(User user);
    User getById(Long id);
    User getUserByName(String username);
    User getUserByEmail(String email);
    List<Role> getRoleList();
    public Role getRole(String role);
}
